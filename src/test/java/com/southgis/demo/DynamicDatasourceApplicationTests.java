package com.southgis.demo;


import com.southgis.demo.domain.p.User;
import com.southgis.demo.domain.s.Message;
import com.southgis.demo.service.IMessageService;
import com.southgis.demo.service.IUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DynamicDatasourceApplicationTests {

	@Autowired
	private IMessageService messageService;
	@Autowired
	private IUserService userService;

	@Before
	public void setUp() {
	}

	@Test
//	@Transactional
	public void test() {
		User user = new User();
		user.setId("01");
		user.setName("a");
		user.setAge(10);
		userService.add(user);
//		userService.save(new User("2","bbb", 20));
//		userService.save(new User("3","ccc", 30));
//		userService.save(new User("4","ddd", 40));
//		userService.save(new User("5","eee", 50));

		Assert.assertEquals(1, userService.findAll().size());

		messageService.save(new Message("o1", "aaaaaaaaaa"));
		messageService.save(new Message("o2", "bbbbbbbbbb"));
		messageService.save(new Message("o3", "cccccccccc"));

		Assert.assertEquals(3, messageService.findAll().size());
	}


}
