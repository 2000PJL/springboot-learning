/*
 * @Description: 
 * @Version: 2.0
 * @Autor: 葛璐豪
 * @Date: 2020-12-26 16:32:44
 * @LastEditors: Seven
 * @LastEditTime: 2020-12-26 16:40:11
 */
package com.hunau.showchart.bluetooth;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ScheduledExecutorService;

import javax.microedition.io.Connection;

public class BlucatState {
	//蓝牙名字 
	public static String blue_name = "PJL";
	 public static boolean verbose = false;
	 public static boolean vverbose = false;
	 public static boolean zip = false;
	 public static boolean keepalive = false;

	 public static int buffersize = 1024;



	 public static OutputStream os = null;
	 public static InputStream is = null;
	 public static Connection connection = null;
	 public static Connection serverConnection = null;
	 public static ScheduledExecutorService rssiexec = null;
	 public static ScheduledExecutorService pushexec = null;

	 public static boolean shutdown = false;
	 public static int timeout = 10000;
	 public static boolean csv;
	 public static boolean l2cap;


	 public static String execString = "";
	 public static boolean rssi = false;
	 public static boolean push = false; //disabled befor now
}
