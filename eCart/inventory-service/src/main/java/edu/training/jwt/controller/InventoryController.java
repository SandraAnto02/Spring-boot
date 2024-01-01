package edu.training.jwt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.training.jwt.dto.RequestInventory;
import edu.training.jwt.service.InventoryService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
@Data
public class InventoryController 
{
	
	private final InventoryService inventoryService;
	
	@GetMapping
	public List<RequestInventory> isInStrock(@RequestParam List<String> pName)
	{
		return inventoryService.isInStock(pName);
		
	}

}
