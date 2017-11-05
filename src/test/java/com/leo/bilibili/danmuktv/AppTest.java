package com.leo.bilibili.danmuktv;

import org.junit.Assert;
import org.junit.Test;

import com.leo.bilibili.danmuktv.utils.PlayerConfig;
import com.leo.bilibili.danmuktv.utils.Requester;


public class AppTest {
	
	@Test
	public void testPropsUtil() {
		String musicPlayer = PlayerConfig.getProperty("player");
		Assert.assertNotNull(musicPlayer);
		System.out.println("测试配置的音乐播放器："+musicPlayer);
	}
	
	@Test
	public void testRequester() {
		String music = "威风堂堂";
		String musicInfo = Requester.sendPost("http://music.163.com/api/search/get/",
				"s=" + music + "&limit=1&type=1&offset=0");
		System.out.println(musicInfo);
		
//		String patternString = "\"id\":[0-9]*";
//		Pattern myPattern = Pattern.compile(patternString);
//		Matcher matcher = myPattern.matcher(musicInfo);
//		if (matcher.find()) {
//			String[] id = matcher.group(0).split(":");
//			System.out.println(id[1]);
//			System.out.println("Found Music~");
//		}else{
//			System.out.println("Search Failure!");
//		}
	}
		
}
