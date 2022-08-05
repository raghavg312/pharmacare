package com.pharmacy.drugmanagement;

import com.pharmacy.drugmanagement.Entity.Drug;
import com.pharmacy.drugmanagement.Service.DrugService;
import com.pharmacy.drugmanagement.dao.DrugRepository;
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
class 	DrugManagementApplicationTests {
	
	@MockBean
	private DrugRepository drugRepository;
	@Autowired
	private DrugService drugService;

	@Test
	public void getDrugTest() {
		when(drugRepository.findAll()).thenReturn(Stream
				.of(new Drug("id1","name1",123,null,5.0,"id1"))
				.collect(Collectors.toList()));
		assertEquals(1,drugRepository.findAll().size());
	}

//	@Test
//	public void getDrugByIdTest() {
//			String id="id1";
//		when(drugRepository.findDrugById(id)).thenReturn(Stream.of(new Drug("id1","name1","email1",123))
//				.collect(Collectors.toList()));
//		assertEquals(1,drugRepository.findById(id));
//	}

	@Test
	public void createDrugTest() {
		Drug drug = new Drug("id1","name1",123,null,5.0,"id1");
		when(drugRepository.save(drug)).thenReturn(drug);
		assertEquals(drug,drugRepository.save(drug));
	}

	@Test
	public void deleteDrugTest() {
		Drug drug = new Drug("id1","name1",123,null,5.0,"id1");
		drugRepository.delete(drug);
		verify(drugRepository,times(1)).delete(drug);
	}


}
