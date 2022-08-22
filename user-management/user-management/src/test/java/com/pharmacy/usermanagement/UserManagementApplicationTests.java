package com.pharmacy.usermanagement;

import com.pharmacy.usermanagement.Entity.Users;
import com.pharmacy.usermanagement.Service.UserService;
import com.pharmacy.usermanagement.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class 	UsersManagementApplicationTests {

	@MockBean
	private UserRepository userRepository;
	@Autowired
	private UserService userService;

	@Test
	public void getUsersTest() {
		when(userRepository.findAll()).thenReturn(Stream
				.of(new Users("id1", "name1", "email1", "pass1", "as", "admin"))
				.collect(Collectors.toList()));
		assertEquals(1, userRepository.findAll().size());
	}

	@Test
	public void createUsersTest() {
		Users user = new Users("id1", "name1", "email1", "pass1", "as", "admin");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userRepository.save(user));
	}

	@Test
	public void deleteUsersTest() {
		Users user = new Users("id1", "name1", "email1", "pass1", "as", "admin");
		userRepository.delete(user);
		verify(userRepository, times(1)).delete(user);
	}
}
