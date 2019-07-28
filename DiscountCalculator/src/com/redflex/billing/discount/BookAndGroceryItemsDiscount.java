package com.redflex.billing.discount;

import java.util.Arrays;

public class BookAndGroceryItemsDiscount implements IDiscountStrategy {

	private static final float discountPercentage = 5;
	private static final String itemsList[]={"book","chocolate bar","bottle of wine","box of chocolates"};
	

	@Override
	public double calculateDiscountedPrice(int quantity, double price) throws Exception {
		// TODO Auto-generated method stub
		return ( price - ((quantity * price) * (discountPercentage/100)));

	}

	@Override
	public boolean isBelongsThisDiscount(String ItemType) throws Exception {
		// TODO Auto-generated method stub
		if(Arrays.asList(itemsList).contains(ItemType.trim())){
			return true;
		}
		
		return false;
	}

}
