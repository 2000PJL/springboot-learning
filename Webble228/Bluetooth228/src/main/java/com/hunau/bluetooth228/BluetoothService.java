/*
 * @Description:
 * @Version: 2.0
 * @Autor: 葛璐豪
 * @Date: 2020-12-26 16:36:14
 * @LastEditors: Seven
 * @LastEditTime: 2020-12-26 16:41:41
 */
package com.hunau.bluetooth228;

import com.hunau.entity228.CollData;
import com.hunau.service228.CollDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@Component
public class BluetoothService extends Thread{
	@Autowired
	protected CollDataService collDataService;

	private static BluetoothService serverHandler;

	private Boolean stopFlag = false;

	private LocalDevice local = null;
	// 流连接
	private StreamConnection streamConnection = null;
	// 接受数据的字节流
	private byte[] acceptdByteArray = new byte[1024];
	// 输入流
	private DataInputStream inputStream;
	private StreamConnectionNotifier notifier;

	public OutputStream out;

	//private  final static ExecutorService service = Executors.newCachedThreadPool();

	/**配合@Component注解获取service层的bean*/
	@PostConstruct
	public void init(){
		serverHandler = this;
		serverHandler.collDataService = this.collDataService;
		try {
			com.hunau.bluetooth228.BluCatUtil.doctorDevice(); 					// 驱动检查
			RemoteDeviceDiscovery.runDiscovery();		// 搜索附近所有的蓝牙设备
		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			local = LocalDevice.getLocalDevice();

			if (!local.setDiscoverable(DiscoveryAgent.GIAC))
				System.out.println("请将蓝牙设置为可被发现");

			Set<RemoteDevice> devicesDiscovered = RemoteDeviceDiscovery.getDevices();		//附近所有的蓝牙设备，必须先执行 runDiscovery
			Iterator<RemoteDevice> it = devicesDiscovered.iterator();
			while (it.hasNext()) {									//连接
				RemoteDevice device = it.next();
				if(device.getFriendlyName(false).equals(BlucatState.blue_name)) {
					serverHandler.streamConnection = (StreamConnection)Connector.open("btspp://" + device.getBluetoothAddress() + ":1");
					System.out.println("连接蓝牙成功");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public synchronized void run() {
		try {
			System.out.println("FIND SUCCESS");
			System.out.println("Bluetooth stream open.");
			InputStream in = serverHandler.streamConnection.openInputStream();
			OutputStream out = serverHandler.streamConnection.openOutputStream();

			int length;
			String inStr = null;
			while (true) {
				length = in.read(acceptdByteArray);
				if(length>0) {
					inStr = new String(acceptdByteArray,0,length);
					System.out.println("蓝牙原始字符:"+inStr);
					String data[] = inStr.split(",");
					String address = "";
					String temp = "";
					String hum = "";
					String supersonic = "";
					if(data.length==6) {
						try {
							address = data[1];
							supersonic = data[2];
							hum = data[3];
							temp = data[4];
							CollData collData=new CollData();
							Date time=new Date();
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							collData.setAddress(address);
							collData.setHum(hum);
							collData.setTemp(temp);
							collData.setSupersonic(supersonic);
							collData.setColltime(df.format(time));
							System.out.println(collData);
							serverHandler.collDataService.insertCollData(collData);
						} catch(ArrayIndexOutOfBoundsException e) {
							System.out.println("该次数据有问题 抛弃");
						}
					}
				}
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException ex) {
			System.out.println("出现异常");
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
				if (streamConnection != null)

					streamConnection.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
