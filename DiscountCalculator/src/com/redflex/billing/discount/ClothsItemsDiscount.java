package com.redflex.billing.discount;

import java.util.Arrays;

public class ClothsItemsDiscount implements IDiscountStrategy {

	private static final float discountPercentage = 20;
	private static final String itemsList[]={"shirt","dress"};

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
