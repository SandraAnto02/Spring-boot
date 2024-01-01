package edu.training.jwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.training.jwt.model.Inventory;
import edu.training.jwt.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication 
{
	
	//@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)
	{
		return args -> {
			Inventory phone = Inventory.builder().build();
			
			phone.setProductName("Moto");
			phone.setQuantity(9);
			
			inventoryRepository.save(phone);
			
			Inventory laptop = Inventory.builder().build();
			
			laptop.setProductName("Asus");
			laptop.setQuantity(92);
			
			inventoryRepository.save(laptop);
			
		};
	}

	public static void main(String[] args) 
	{
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
