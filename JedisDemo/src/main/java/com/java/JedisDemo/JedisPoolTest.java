package com.java.JedisDemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
	public static void main(String[] args) {
		JedisPoolConfig jConfig=new JedisPoolConfig();
		jConfig.setMaxTotal(100);//设置最大连接数
		jConfig.setMaxIdle(100);//设置最大空闲连接数
		
		JedisPool jPool=new JedisPool(jConfig,"192.168.198.128",6379);
		Jedis jedis=null;
		try {
			jedis=jPool.getResource();
			jedis.set("myname","cyw");
			String myname=jedis.get("myname");
			System.out.println(myname);
		} finally {
			// TODO: handle finally clause
			if(jedis!=null) {
				jedis.close();	
			}
			if(jPool!=null) {
				jPool.close();
			}
		}
		
	}
}
