package object_and_classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AndreyAndBilliard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Shop shop = new Shop();
		String line = sc.nextLine();
		for (int i = 0; i < n; i++) {
			shop.addItem(Shop.readItem(line));
			line = sc.nextLine();
		}
		
		Map<String, Customer> customers = new TreeMap<>();
		while(!line.equals("end of clients")){
			String[] input = line.split("[-,]");
			String customerName = input[0];
			String itemName = input[1];
			int quantity = Integer.parseInt(input[2]);	
			
			if(shop.contains(itemName)){
				if(customers.containsKey(customerName)){
					customers.get(customerName).addItem(shop.getItem(itemName), quantity);
				}else {
					Customer customer = new Customer(customerName);
					customer.addItem(shop.getItem(itemName), quantity);
					customers.put(customerName, customer);
				}
			}
			line = sc.nextLine();
		}
		sc.close();
		formatInput(customers);
	}
	
	public static void formatInput(Map<String, Customer> customers){
		
		customers.values().forEach(cust -> {
			System.out.println(cust.getName());
			cust.getShopingList().entrySet().forEach(item -> {
				System.out.printf("-- %s - %d%n", item.getKey().getItemName(), item.getValue());				
			});
			System.out.printf("Bill: %.2f%n", cust.getBill());			
		});
		
		double totalBill = customers.entrySet().stream()
				.mapToDouble(es -> es.getValue().getBill()).sum();
		System.out.printf("Total bill: %.2f%n", totalBill);

	}

}

class Shop {
	
	private Map<String, Item> items = new HashMap<>();	
	
	public static Item readItem(String line){
		String[] input = line.split("-");
		return new Item(input[0], Double.parseDouble(input[1]));
	}
	
	public void addItem(Item item){
		this.items.compute(item.getItemName(), (k, v) ->item);
	}
	
	public Item getItem(String itemName){
		return items.get(itemName);
	}
	
	public boolean contains(String itemName){
		return this.items.containsKey(itemName);
	}

	@Override
	public String toString() {
		return "Shop [items=" + items + "]";
	}	
	
}

class Customer{
	private String name;
	private Map<Item, Integer> shopingList;
	
	public Customer(String name) {
		this.shopingList = new HashMap<>();
		this.name = name;
	}
	
	public void addItem(Item item, int quantity){
		this.shopingList.computeIfPresent(item, (k, v) -> v + quantity);
		this.shopingList.computeIfAbsent(item, v -> quantity);
	}
	
	public double getBill(){
		return this.shopingList.entrySet().stream()
				.mapToDouble(es -> es.getKey().getItemPrice() * es.getValue()).sum();
	}

	public String getName() {
		return name;
	}	

	public Map<Item, Integer> getShopingList() {
		return shopingList;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", shopingList=" + shopingList + "]";
	}
	
}

class Item{
	private String itemName;
	private double itemPrice;
	
	public Item(String itemName, double itemPrice) {		
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}	
	
	
}
