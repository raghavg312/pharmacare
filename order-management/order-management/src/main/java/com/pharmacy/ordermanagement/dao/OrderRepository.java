package com.pharmacy.ordermanagement.dao;

import com.pharmacy.ordermanagement.models.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Orders,String> {

   public List<Orders> findAll();
   @Override
   Optional<Orders> findById(String s);
   public List<Orders> findByPickedUp(boolean flag);
   public List<Orders> findByVerified(boolean flag);
   public List<Orders> findByDoctorId(String id);

}
