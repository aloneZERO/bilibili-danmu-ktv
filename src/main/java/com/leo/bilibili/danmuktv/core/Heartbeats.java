package com.leo.bilibili.danmuktv.core;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import com.leo.bilibili.danmuktv.utils.ByteUtil;

/**
 * @author BlindingDark 发送心跳包的线程
 */
public class Heartbeats implements Runnable {

	OutputStream os;
	// 心跳包格式
	byte[] heartMsg1 = ByteUtil.intToByteArray(16);
	byte[] heartMsg2 = ByteUtil.intToByteArray(1048577);
	byte[] heartMsg3 = ByteUtil.intToByteArray(2);
	byte[] heartMsg4 = ByteUtil.intToByteArray(1);

	byte[] heartMsg = ByteUtil.merge(
			ByteUtil.merge(
					ByteUtil.merge(heartMsg1, heartMsg2), heartMsg3), heartMsg4);

	Socket socket;

	public Heartbeats(Socket _socket) {
		this.socket = _socket;
		getOutputStream();
	}

	/**
	 * 获取弹幕服务器的 OutputStream
	 */
	void getOutputStream() {
		try {
			this.os = socket.getOutputStream();
		} catch (IOException e) {
			System.out.println("向弹幕服务器发送消息失败……正在重试……");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			this.getOutputStream();
		}
	}

	/**
	 * 发送心跳包
	 */
	public void send() {
		try {
			os.write(heartMsg);
		} catch (IOException e) {
			this.getOutputStream();
			this.send();
		}
	}

	/**
	 * 发送线程启动
	 */
	@Override
	public void run() {
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				return;
			}
			this.send();
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
