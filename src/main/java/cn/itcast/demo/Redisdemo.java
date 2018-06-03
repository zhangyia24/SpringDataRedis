package cn.itcast.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class Redisdemo {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 设置
	 * @throws Exception
	 */
	@Test
	public void setValue() throws Exception {
		redisTemplate.boundValueOps("name1").set("张三");
	}
	
	/**
	 * 获取
	 */
	@Test
	public void getName() throws Exception {
		String name= (String) redisTemplate.boundValueOps("name1").get();
		System.out.println(name);
	}
	
	/**
	 * 删除
	 * @throws Exception
	 */
	@Test
	public void testName() throws Exception {
		redisTemplate.delete("name1");
		
		
		
		
	}
	
}
