package com.uncleray.test.redis;

import com.alibaba.fastjson.JSONObject;
import com.uncleray.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @program: uncle-ray
 * @description:
 * @author: lei pei
 * @create: 2020-10-29 22:38
 */
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        // redisTemplate    操作不同的数据类型，api和我们的指令是一样的
        // redisTemplate.opsForValue()  操作字符串 类似String
        // redisTemplate.opsForList()   操作List 类似List
        // redisTemplate.opsForSet()    操作Set 类似Set，无序集合
        // redisTemplate.opsForHash()   操作Hash 哈希
        // redisTemplate.opsForZSet()   操作ZSet 有序集合
        // redisTemplate.opsForGeo()    操作地理位置 范围查询
        // redisTemplate.opsForHyperLogLog()    操作超日志，比如基数统计

        // 除了基本的操作，我们常用的方法都是可以直接通过redisTemplate操作，比如事务，和基本的CURD

        // 获取redis的连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        System.out.println(connection);
        //org.springframework.data.redis.connection.lettuce.LettuceConnection@33060020
//        connection.flushDb();
//        connection.flushAll();

        String jsonString = JSONObject.toJSONString("叔叔大法好");
        redisTemplate.opsForValue().set("myKey", jsonString);
        Object myKey = redisTemplate.opsForValue().get("myKey");
        System.out.println(myKey);

    }

    @Test
    void redisString() {
        BoundValueOperations<String, String> kobe = stringRedisTemplate.boundValueOps("kobe");
        kobe.set("bryant");
        kobe.append(" 24");
//        kobe.set("lakers");
//        kobe.set("24");
    }

    @Test
    void redis() {
//        BoundValueOperations kobe = redisTemplate.boundValueOps("kobe1");
//        kobe.set("24");
//        kobe.append("lakers");
//        redisTemplate.opsForValue().set("p", 24);
//        redisTemplate.opsForValue().set(8, "kobe");
//        Object p = redisTemplate.opsForValue().get("p");
//        Object o = redisTemplate.opsForValue().get(8);
//        System.out.println(p);
//        System.out.println(o);
        Person person = new Person();
        person.setName("leipei");
        person.setAge(25);
        String jsonPerson = JSONObject.toJSONString(person);
        redisTemplate.opsForValue().set("person", person);
        System.out.println(redisTemplate.opsForValue().get("person"));
    }
}
