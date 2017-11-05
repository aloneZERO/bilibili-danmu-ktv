package com.leo.bilibili.danmuktv.utils;


/**
 * 字节工具类
 * 
 * @author aloneZero
 */
public class ByteUtil {
	
	public static byte[] merge(byte[] b1, byte[] b2) {
		byte[] b3 = new byte[b1.length + b2.length];
		System.arraycopy(b1, 0, b3, 0, b1.length);
		System.arraycopy(b2, 0, b3, b1.length, b2.length);
		return b3;
	}
	
	/**
	 * int到byte[]
	 * 
	 * @param i
	 * @return
	 */
	public static byte[] intToByteArray(int num) {
		byte[] result = new byte[4]; 
		result[0] = (byte) (num & 0xff); // 最低位 
		result[1] = (byte) ((num >> 8) & 0xff); // 次低位 
		result[2] = (byte) ((num >> 16) & 0xff); // 次高位 
		result[3] = (byte) (num >>> 24); // 最高位,无符号右移。 
	    return result;
	}

	/**
	 * byte[]转int
	 * 
	 * @param bytes
	 * @return
	 */
	public static int byteArrayToInt(byte[] bytes) {
		int value = 0;
		// 由高位到低位
		for (int i = 0; i < 4; i++) {
			int shift = (4 - 1 - i) * 8;
			value += (bytes[i] & 0x000000FF) << shift; // 往高位游
		}
		return value;
	}
	
	// 工具类构造器私有化
	private ByteUtil() {};
	
}
