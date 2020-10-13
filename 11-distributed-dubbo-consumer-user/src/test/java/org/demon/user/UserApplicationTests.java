package org.demon.user;

import org.demon.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserApplicationTests {

	@Autowired
	UserService userService;

	@Test
	void testBuy() {
		userService.buy();
	}

}
