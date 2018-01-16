package kanq.gz.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:spring-redis.xml")
public class RedisTest extends AbstractJUnit4SpringContextTests{
	
//	@Autowired
//	@Qualifier()
	private JedisPool jedisPool;
	
//	@Test
	public void basicTest(){
		Jedis jedis = jedisPool.getResource();
		jedis.set("user.name", "andy");
		jedis.set("user.pass", "123");
		
		String name = jedis.get("user.name");
		String pass = jedis.get("user.pass");
		
		Assert.assertEquals("andy", name);
		Assert.assertEquals("123", pass);
		
		jedis.del("user.name");
		Boolean exists = jedis.exists("user.name");
		Assert.assertEquals(false, exists);
		
		exists = jedis.exists("user.pass");
        Assert.assertEquals(true, exists);
        jedis.disconnect();
	}
}
