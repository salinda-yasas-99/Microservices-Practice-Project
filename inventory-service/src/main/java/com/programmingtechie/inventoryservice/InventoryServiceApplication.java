package com.programmingtechie.inventoryservice;

import com.programmingtechie.inventoryservice.model.Inventory;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventoryServiceApplication.class, args);

		/*// Initialize the Spring Boot application context
		ApplicationContext context = SpringApplication.run(InventoryServiceApplication.class, args);

		// Get the InventoryRepository bean from the context
		InventoryRepository inventoryRepository = context.getBean(InventoryRepository.class);

		// Define a list of SKU codes that you want to search for
		List<String> skuCodes = Arrays.asList("Iphone_13", "Iphone_13_red", "SKU789");

		// Call the repository method to retrieve matching Inventory items
		List<Inventory> matchingInventory = inventoryRepository.findBySkuCodeIn(skuCodes);

		boolean iphone13Found = false;

		// You can now print the retrieved inventory items to the console for inspection
		for (Inventory inventory : matchingInventory) {
			System.out.println("Found Inventory Item: " + inventory);

			// Check if the SKU code is "Iphone_13"
			if ("Iphone_1".equals(inventory.getSkuCode())) {
				iphone13Found = true;
			}
		}

		// Print "found" or "not found" based on the boolean variable
		if (iphone13Found) {
			System.out.println("Found Iphone_13");
		} else {
			System.out.println("Not Found Iphone_13");
		}
*/
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("Iphone_13");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("Iphone_13_red");
			inventory1.setQuantity(0);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}

}
