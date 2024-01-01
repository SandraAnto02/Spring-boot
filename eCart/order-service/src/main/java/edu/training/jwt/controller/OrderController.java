package edu.training.jwt.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.training.jwt.dto.OrderRequest;
import edu.training.jwt.dto.ProductResponse;
import edu.training.jwt.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController 
{
	private final OrderService orderService;
	
	@PostMapping
	@CircuitBreaker(name="inventory", fallbackMethod = "fallBackMethod")
	@TimeLimiter(name="inventory")
	@Retry(name="inventory")
	public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest)
	{
		System.out.println("In post mapping");
		System.out.println(orderRequest);
		
		String msg = orderService.placeOrder(orderRequest);
		
		return CompletableFuture.supplyAsync(() -> msg);
		
	}
	
	public CompletableFuture<String>  fallBackMethod(OrderRequest orderRequest, RuntimeException exception)
	{
		System.out.println("Fallback Mechanism");
		return CompletableFuture.supplyAsync(() ->"Call back method error in placing order");
		
		
	}
	
	
	
	@GetMapping("/product")
	public List<ProductResponse> getAllProducts()
	{
		List<ProductResponse> responseList = orderService.getAllProducts();
		
		return responseList;
		
	}

}
