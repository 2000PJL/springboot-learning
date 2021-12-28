/*
 * @Description:
 * @Version: 2.0
 * @Autor: 葛璐豪
 * @Date: 2020-12-21 18:13:47
 * @LastEditors: Seven
 * @LastEditTime: 2020-12-26 16:40:35
 */
package com.hunau.bluetooth228;

import com.intel.bluetooth.RemoteDeviceHelper;

import javax.bluetooth.*;
import javax.microedition.io.Connector;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RemoteDeviceDiscovery {

	public final static Set<RemoteDevice> devicesDiscovered = new HashSet<RemoteDevice>();

	public static void runDiscovery() throws IOException, InterruptedException {
		findDevices();
	}

	private static void findDevices() throws IOException, InterruptedException {

		final Object inquiryCompletedEvent = new Object();

		devicesDiscovered.clear();

		DiscoveryListener listener = new DiscoveryListener() {
			public void inquiryCompleted(int discType) {
				System.out.println("#" + "搜索完成");
				synchronized (inquiryCompletedEvent) {
					inquiryCompletedEvent.notifyAll();
				}
			}

			@Override
			public void deviceDiscovered(RemoteDevice remoteDevice, DeviceClass deviceClass) {
				devicesDiscovered.add(remoteDevice);

				try {
					System.out.println("#发现设备" + remoteDevice.getFriendlyName(false));
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			@Override
			public void servicesDiscovered(int arg0, ServiceRecord[] arg1) {
				System.out.println("#" + "servicesDiscovered");
			}

			@Override
			public void serviceSearchCompleted(int arg0, int arg1) {
				System.out.println("#" + "serviceSearchCompleted");
			}
		};

		synchronized (inquiryCompletedEvent) {

			LocalDevice ld = LocalDevice.getLocalDevice();

			System.out.println("#本机蓝牙名称:" + ld.getFriendlyName());

			boolean started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC,listener);

			if (started) {
				System.out.println("#" + "等待搜索完成...");
				inquiryCompletedEvent.wait();
				LocalDevice.getLocalDevice().getDiscoveryAgent().cancelInquiry(listener);
				System.out.println("#发现设备数量：" + devicesDiscovered.size());
			}
		}

	}

	public static Set<RemoteDevice> getDevices() {

		return devicesDiscovered;
	}

	public static String deviceName(RemoteDevice d) {

		String address = d.getBluetoothAddress();

		String name = "";
		try {
			name = d.getFriendlyName(false);
		} catch (IOException e) {
			System.out.println("#Error: " + e.getMessage());
			try {
				name = d.getFriendlyName(false);
			} catch (IOException e2) {
				System.out.println("#Error: " + e2.getMessage());
			}

		}

		String rssi = "NA";

		String toret = "";

		if (com.hunau.bluetooth228.BlucatState.csv)
			toret += (new Date()).getTime() + ", ";

		toret += com.hunau.bluetooth228.BluCatUtil.clean(address) + ", " + "\"" + com.hunau.bluetooth228.BluCatUtil.clean(name) + "\", " + "Trusted:"
				+ d.isTrustedDevice() + ", " + "Encrypted:" + d.isEncrypted();

		if (com.hunau.bluetooth228.BlucatState.rssi) {
			try {
				rssi = String.valueOf(RemoteDeviceHelper.readRSSI(d));
			} catch (Throwable e) {

				String url = "btl2cap://" + d.getBluetoothAddress() + ":1";

				try {
					com.hunau.bluetooth228.BlucatState.connection = Connector.open(url, Connector.READ_WRITE, true);
					rssi = String.valueOf(RemoteDeviceHelper.readRSSI(d));
					com.hunau.bluetooth228.BlucatState.connection.close();

				} catch (IOException e1) {
				}
			}

			toret += ", " + rssi;

		}

		return toret;

	}

}
