package com.lambazon.domain;

public class Product {

	private Integer id;
	private String name, description, details;
	private static int quantity;
	private static double price;
	// Declaration of the variable
	public static double InventoryPrice;


	public Product(int id, int quantity, double price, String name, String description) {
		setId(id);
		setQuantity(quantity);
		setPrice(price);
		setName(name);
		setDescription(description);

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		// Condition for quantity will never be negative
		// If negative quantity = 0
		if (quantity < 0) {
			this.quantity = 0;
		} else {
			this.quantity = quantity;
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
        // Condition for price never be negative and never above 1000
		// If price is under 0, price is equal to 0
		if (price < 0)
			this.price = 0;

        // If price exceeds 1000, price is allays equal to 1000
		else if (price > 1000)
			this.price = 1000;

		// In other conditions price is the price listed
		else {
			this.price = price;
		}

	}

	public static double getInventoryPrice() {
		// Adding method to calculate the Inventory Price
		InventoryPrice = quantity * price;
		return InventoryPrice;
	}

}




