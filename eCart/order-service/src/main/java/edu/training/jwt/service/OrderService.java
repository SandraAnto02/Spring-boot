package edu.training.jwt.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import edu.training.jwt.dto.OrderLineItemsDto;
import edu.training.jwt.dto.OrderRequest;
import edu.training.jwt.dto.ProductResponse;
import edu.training.jwt.dto.RequestInventory;
import edu.training.jwt.model.Order;
import edu.training.jwt.model.OrderLineItems;
import edu.training.jwt.repository.OrderRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class OrderService 
{
	private final OrderRepository orderRepository;
	
	private final WebClient.Builder webClientBuilder;


	
	public String placeOrder(OrderRequest orderRequest)
	{
		
		String msg;
		Order order= new Order();
		order.setOrderNumber(UUID.randomUUID().toString());  //generate random numberOrderLineItemsDto
		order.setOrderLineItems(orderRequest.getOrderLineItemsDtoList().stream().map(dto ->mapToDto(dto)).toList());
//		orderRepository.save(order);
		
		
		List<String> productName = order.getOrderLineItems().stream().map(names->names.getProductName()).toList();
		
        //Connection between order and inventory 
		
		RequestInventory[] inventoryResponseArray = webClientBuilder.build().get()
//		.uri("http://localhost:8003/inventory",uriBuilder -> uriBuilder.queryParam("productName", productName).build())
				
		.uri("http://inventory-service/inventory",uriBuilder -> uriBuilder.queryParam("pName", productName).build())		
		.retrieve()
		//converting list to object
		.bodyToMono(RequestInventory[].class)
		.block();
		
		
		
		boolean stockCheckStatics = Arrays.stream(inventoryResponseArray).allMatch(inventory -> inventory.isQuantity());
		
		if(stockCheckStatics)
		{
			orderRepository.save(order);
			msg="Order placed successfully";
		}
		else
		{
			msg="Out of stock";
//			throw new IllegalArgumentException("Out Of stock!!");
		}
		
		return msg;
		
		
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
	
	public List<ProductResponse> getAllProducts()
	{
		ProductResponse[] productList = webClientBuilder.build().get()
		.uri("http://product-service/product")
		.retrieve()
		.bodyToMono(ProductResponse[].class)
		.block();
		
		List<ProductResponse> pList = Arrays.stream(productList).toList();
		
		return pList;
		
		
	}

}
