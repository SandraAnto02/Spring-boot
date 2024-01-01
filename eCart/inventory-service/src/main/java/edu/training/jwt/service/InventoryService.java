package edu.training.jwt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.training.jwt.dto.RequestInventory;
import edu.training.jwt.model.Inventory;
import edu.training.jwt.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService 
{
	private final InventoryRepository inventoryRepository;
	public List<RequestInventory> isInStock(List<String> productName)
	{
		try 
		{
			System.out.println("Thread started sleeping");
			Thread.sleep(10000);
			System.out.println("Thread awake");
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		List<Inventory> iList = inventoryRepository.findByProductNameIn(productName);
		List<RequestInventory> rList = iList.stream().map(product -> mapToRequestInventory(product)).toList();
		return rList;
		
	}
	
	
	public RequestInventory mapToRequestInventory(Inventory inv)
	{
		return RequestInventory.builder()
				.productName(inv.getProductName())
				.quantity(inv.getQuantity()>0)
				.build();
		
		
	}
	

}
