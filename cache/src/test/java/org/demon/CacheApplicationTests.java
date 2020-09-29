package org.demon;

import org.demon.entity.Employee;
import org.demon.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class CacheApplicationTests {

	@Autowired
	EmployeeMapper mapper;

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;

	@Test
	void testStringRedisTemplate() {
		//stringRedisTemplate.opsForValue().append("msg", "hello");
		String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println(msg);
	}

	@Test
	void testRedisTemplate(){
		// Employee emp = mapper.findEmpById(1);
		// redisTemplate.opsForValue().set("emp_1", emp);
		String emp = redisTemplate.opsForValue().get("emp_1").toString();
		System.out.println(emp);
	}

	@Test
	void testEmpRedisTemplate(){
		Employee emp = mapper.findEmpById(1);
		empRedisTemplate.opsForValue().set("emp_1", emp);
	}

}
