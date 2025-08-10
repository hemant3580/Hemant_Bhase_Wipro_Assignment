// Assignment 5: Builder Pattern & Encapsulation: Immutable Product
package AssignmentDay5;

public class Assignment5 {
	public static void main(String[] args) {
		Product p = new Product.Builder()
				.withName("Laptop")
				.withCode("LP123")
				.withPrice(50000)
				.withCategory("Electronics")
				.build();
		System.out.println("Product: " + p.getName() + ", Code: " + p.getCode() + ", Price: " + p.getPrice() + ", Category: " + p.getCategory());
	}
}

class Product {
	private final String name;
	private final String code;
	private final double price;
	private final String category;

	private Product(Builder builder) {
		this.name = builder.name;
		this.code = builder.code;
		this.price = builder.price;
		this.category = builder.category;
	}

	public String getName() { return name; }
	public String getCode() { return code; }
	public double getPrice() { return price; }
	public String getCategory() { return category; }

	public static class Builder {
		private String name;
		private String code;
		private double price;
		private String category;

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withCode(String code) {
			this.code = code;
			return this;
		}

		public Builder withPrice(double price) {
			if (price >= 0) {
				this.price = price;
			}
			return this;
		}

		public Builder withCategory(String category) {
			this.category = category;
			return this;
		}

		public Product build() {
			return new Product(this);
		}
	}
}
