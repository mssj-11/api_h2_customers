package com.mss.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mss.springboot.web.app.entity.CustomerEntity;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

}
