package kanq.gz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class UserController {
 
    @Resource(name="redisTemplate")
    private ListOperations<String, String[]> listUser;
    
    @Resource
    private kanq.gz.test.RedisService redisService;
    
    @RequestMapping(value="/list",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<String[]> list(){
        List<String[]> list=listUser.range("user", 0, -1);
        list.add(new String[]{"1111"});
        return list;
    }
     
    @RequestMapping("/add")
    @ResponseBody
    public void add(String... user){
        listUser.leftPush("user", user);
    }
    
    @RequestMapping("/redis")
    @ResponseBody
    public String redisTest() throws InterruptedException{
    	String flag = redisService.ping();
    	System.out.println(flag);
    	redisService.set("name", "andy",15);
    	System.out.println(redisService.get("name"));
    	System.out.println(redisService.saveJedis());
    	Thread.sleep(10);
    	System.out.println(redisService.get("name"));
    	return flag;
    }
}
