package com.github.thrift.service2;

import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.thrift.consumer.ThriftReference;
import com.github.thrift.service1.order.OrderService;
import com.github.thrift.service1.user.UserService;

@Controller
public class ConsumerService
{
	@ThriftReference(version="1.1.1")
	UserService.Iface userClient;
	
	@ThriftReference(version="1.1.2")
	OrderService.Iface orderClient;
	
	@RequestMapping("/comsume")
	public void consume() throws TException
	{
		userClient.getById(0L);
		orderClient.getById(1L);
	}
}
