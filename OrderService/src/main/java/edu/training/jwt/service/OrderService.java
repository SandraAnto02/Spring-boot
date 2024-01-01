package edu.training.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.training.jwt.dto.OrderLineItemsDto;
import edu.training.jwt.dto.OrderRequest;
import edu.training.jwt.model.Order;
import edu.training.jwt.model.OrderLineItems;
import edu.training.jwt.repository.OrderRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class OrderService 
{
	private final OrderRepository orderRepository;
	

	

	
	public void placeOrder(OrderRequest orderRequest)
	{
		List<Order> or = new ArrayList<>();
		
		Order order= new Order();
		order.setOrderNumber(UUID.randomUUID().toString());  //generate random numberOrderLineItemsDto
		order.setOrderLineItems(orderRequest.getOrderLineItemsDtoList().stream().map(dto ->mapToDto(dto)).toList());
		orderRepository.save(order);
			
	}
	
	
	public OrderLineItems mapToDto(OrderLineItemsDto dto)
	{
		return OrderLineItems.builder()
				.id(dto.getProductId())
				.productName(dto.getProductName())
				.productPrice(dto.getProductPrice())
				.productQuantity(dto.getProductQuantity())
				.build();
	}
	
	
	
	
	
	
	

}
