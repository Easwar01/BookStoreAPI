package com.reflections.bookstoreapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reflections.bookstoreapi.model.Orders;
import com.reflections.bookstoreapi.service.OrderService;

@RestController
@RequestMapping("/v1/bookstore")
public class OrderController {
	
	@Autowired
	private OrderService service;

	@RequestMapping(method = RequestMethod.POST, value = "/order")
	public ResponseEntity<Integer> placeOrder(@RequestBody Orders order) {
		if(order == null) {
			return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Integer>(service.placeOrder(order), HttpStatus.OK);
	}
	
	@RequestMapping("/orders")
	public ResponseEntity<List<Orders>> getAllOrders(){
		return new ResponseEntity<List<Orders>>(service.getAllOrders(), HttpStatus.OK);
	}
}
