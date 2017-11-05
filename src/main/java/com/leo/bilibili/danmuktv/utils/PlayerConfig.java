package com.leo.bilibili.danmuktv.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PlayerConfig {
	
	private static Properties props = new Properties();
	static {
		InputStream in = PlayerConfig.class.getResourceAsStream("/player");
		try {
			props.load(in);
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/**
	 * 根据 key 获取属性
	 * @param key
	 * @return 属性值
	 */
	public static String getProperty(String key) {
		return props.getProperty(key);
	}
	
	private PlayerConfig() {}
}
