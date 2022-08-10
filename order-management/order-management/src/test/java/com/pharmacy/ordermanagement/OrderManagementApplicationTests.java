package com.pharmacy.ordermanagement;

import com.pharmacy.ordermanagement.dao.OrderRepository;
import com.pharmacy.ordermanagement.models.Orders;
import com.pharmacy.ordermanagement.models.Orders;
import com.pharmacy.ordermanagement.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrderManagementApplicationTests {
	@MockBean
	private OrderRepository orderRepository;
	@Autowired
	private OrderService orderService;

	@Test
	public void getOrderTest(){
		when(orderRepository.findAll()).thenReturn(Stream
				.of(new Orders("id1",null,"id1",120,false,false))
				.collect(Collectors.toList()));
		assertEquals(1,orderRepository.findAll().size());

	}
	@Test
	public void getOrderByIdTest(){
		String id ="id1";
		when(orderRepository.findByOrderId(id)).thenReturn(Stream
				.of(new Orders("id1",null,"id1",120,false,false))
				.collect(Collectors.toList()));
		assertEquals(1,orderRepository.findByOrderId(id).size());
	}
	@Test
	public void saveOrderTest(){
		Orders order = new Orders("id1",null,"id1",120,false,false);
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order,orderRepository.save(order));

	}
	@Test
	public void deleteOrderTest(){
		Orders order = new Orders("id1",null,"id1",120,false,false);
		orderRepository.delete(order);
		verify(orderRepository,times(1)).delete(order);
	}

}

























































//	@Test
//	public void verifyOrderTest(){
//
//	}
//	@Test
//	public void pickUpOrderTest(){
//
//	}