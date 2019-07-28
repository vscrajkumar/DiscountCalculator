package com.redflex.billing.helper;

public class ParserHelper {

	String items;
	int quantity;
	String itemType;
	double price;
	boolean clerance;
	static String clearanceItem="clearance";
	public ParserHelper(String items){
		this.items=items;
	}

	public void parse(){
		
		quantity=Integer.parseInt(items.split(" ")[0]);

		price=Double.parseDouble(items.split(" at")[1]);

		itemType=items.substring(items.indexOf(" ") + 1, items.indexOf(" at"));
		
		if(itemType.startsWith(clearanceItem)){
			clerance=true;
			itemType=itemType.substring(itemType.indexOf(" ") + 1, itemType.length());
		}else{
			clerance=false;
		}
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isClerance() {
		return clerance;
	}

	public void setClerance(boolean clerance) {
		this.clerance = clerance;
	}
	
}
