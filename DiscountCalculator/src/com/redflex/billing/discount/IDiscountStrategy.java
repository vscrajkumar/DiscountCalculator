package com.redflex.billing.discount;

public interface IDiscountStrategy {

	public  double calculateDiscountedPrice(int quantity,double price) throws Exception;
	public boolean isBelongsThisDiscount(String ItemType) throws Exception;
}
