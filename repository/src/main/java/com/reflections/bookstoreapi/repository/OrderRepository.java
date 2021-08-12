package com.reflections.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reflections.bookstoreapi.model.Orders;

public interface OrderRepository  extends JpaRepository<Orders, Integer>{

}
