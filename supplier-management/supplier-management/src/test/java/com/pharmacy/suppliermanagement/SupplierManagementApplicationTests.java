package com.pharmacy.suppliermanagement;

import com.pharmacy.suppliermanagement.Entity.Supplier;
import com.pharmacy.suppliermanagement.Service.SupplierService;
import com.pharmacy.suppliermanagement.dao.SupplierRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class 	SupplierManagementApplicationTests {

//	@Test
//	void contextLoads() {
//	}

		@MockBean
		private SupplierRepository supplierRepository;
		@Autowired
		private SupplierService supplierService;

		@Test
		public void getSupplierTest() {
			when(supplierRepository.findAll()).thenReturn(Stream
					.of(new Supplier("id1","name1","email1",123))
					.collect(Collectors.toList()));
			assertEquals(1,supplierRepository.findAll().size());
		}

//	@Test
//	public void getSupplierByIdTest() {
//			String id="id1";
//		when(supplierRepository.findSupplierById(id)).thenReturn(Stream.of(new Supplier("id1","name1","email1",123))
//				.collect(Collectors.toList()));
//		assertEquals(1,supplierRepository.findById(id));
//	}

	@Test
	public void createSupplierTest() {
			Supplier supplier = new Supplier("id1","name1","email1",1);
		when(supplierRepository.save(supplier)).thenReturn(supplier);
		assertEquals(supplier,supplierRepository.save(supplier));
	}

	@Test
	public void deleteSupplierTest() {
		Supplier supplier = new Supplier("id1","name1","email1",1);
		supplierRepository.delete(supplier);
		verify(supplierRepository,times(1)).delete(supplier);
	}


}
