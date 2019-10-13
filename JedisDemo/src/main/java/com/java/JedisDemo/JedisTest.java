package com.java.JedisDemo;

import redis.clients.jedis.Jedis;

public class JedisTest {
	public static void main(String[] args) {
		Jedis jedis=new Jedis("192.168.198.128",6379);
		jedis.set("name","java");
		String valueString=jedis.get("name");
		jedis.close();
		System.out.println(valueString);
	}

}
