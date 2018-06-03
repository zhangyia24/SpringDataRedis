package cn.itcast.demo;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

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
	
	
	
	
	
	
	//set
	@Test
	public void set1Name() throws Exception {
		redisTemplate.boundSetOps("setname1").add("zhangsan ");
		redisTemplate.boundSetOps("setname1").add("lisi ");
		redisTemplate.boundSetOps("setname1").add("wangwu ");
		redisTemplate.boundSetOps("setname1").add("zhaoliu ");
	}
	
	@Test
	public void get1Name() throws Exception {
	Set set=    redisTemplate.boundSetOps("setname1").members();
	System.out.println(set);
	}
	
	
	
	//删除某一个
	@Test
	public void deloneName() throws Exception {
		redisTemplate.boundSetOps("setname1").remove("zhangsan ");
		
	}
	
	//删除所有
	@Test
	public void delallName() throws Exception {
		redisTemplate.delete("setname1");
		
	}
	
	
	
	
	
	/**
	 * List
	 */
	@Test
	public void listsetName() throws Exception {
		redisTemplate.boundListOps("listname").leftPush("张三");
		redisTemplate.boundListOps("listname").leftPush("李四");
		redisTemplate.boundListOps("listname").leftPush("王五");
	}
	
	
	@Test
	public void listgetName() throws Exception {
	List<String> list=	redisTemplate.boundListOps("listname").range(0, 100);
	for (String string : list) {
		System.out.println(string);
	}
	}
	
	//删除所有
	@Test
	public void delallName1() throws Exception {
		redisTemplate.delete("listname");
		
	}
	
	@Test
	public void listName() throws Exception {
		redisTemplate.boundListOps("listname2").rightPush("刘备");
		redisTemplate.boundListOps("listname2").rightPush("关羽");
		redisTemplate.boundListOps("listname2").rightPush("张飞");
		
		
		
	}
	
	
	@Test
	public void listgetName2() throws Exception {
	List<String> list=	redisTemplate.boundListOps("listname2").range(0, 100);
	for (String string : list) {
		System.out.println(string);
	}
}
	
//	根据索引查询元素
	@Test
	public void findName() throws Exception {
	String string	=(String) redisTemplate.boundListOps("listname2").index(1);
		System.out.println(string);
	}
	
	//移除指定元素
	@Test
	public void removeName() throws Exception {
		redisTemplate.boundListOps("listname2").remove(2, "关羽");
		
	}
	
	
	
	
	
	
	//hash
	@Test
	public void hashName() throws Exception {
		redisTemplate.boundHashOps("hashname11").put("name1", "张三");
		redisTemplate.boundHashOps("hashname11").put("name2", "李四");
		redisTemplate.boundHashOps("hashname11").put("name3", "王五");
		
	}
	
	//删除
	@Test
	public void hashdelName() throws Exception {
		redisTemplate.delete("hashname11");
		
	}
	
	
	@Test
	public void gethashName() throws Exception {
		
	Set set=	redisTemplate.boundHashOps("hashname11").keys();
	System.out.println(set);
	}
	
	
	
	@Test
	public void getvalhashName() throws Exception {
		
	String list=	(String) redisTemplate.boundHashOps("hashname11").get("name1");
	System.out.println(list);
	
	}
	
	
	@Test
	public void getvalhashNam1e() throws Exception {
		
		List<String> list=	 redisTemplate.boundHashOps("hashname11").values();
		for (String string : list) {
			System.out.println(string);
		}
		
	}
	
	//删除指定
	@Test
	public void test22Name() throws Exception {
		redisTemplate.boundHashOps("hashname11").delete("name1");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}