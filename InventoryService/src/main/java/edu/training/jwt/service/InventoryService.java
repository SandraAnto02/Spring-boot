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
