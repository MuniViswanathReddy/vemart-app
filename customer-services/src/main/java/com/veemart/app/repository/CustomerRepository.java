package com.veemart.app.repository;

import com.veemart.app.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query(value = "from Customer where mobileNo=:phoneNo")
    public Customer findByPhoneNo(String phoneNo);
}
