package com.spain.csd.os.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spain.csd.os.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
