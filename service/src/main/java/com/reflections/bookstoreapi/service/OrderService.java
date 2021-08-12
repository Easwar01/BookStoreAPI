package com.reflections.bookstoreapi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reflections.bookstoreapi.model.Orders;
import com.reflections.bookstoreapi.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	public int placeOrder(Orders order) {
		int orderId = 0;
		order.setPurchaseDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		try {
			orderId = orderRepo.save(order).getOrderId();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		return orderId;
	}

	public List<Orders> getAllOrders() {
		return orderRepo.findAll();
	}
}
