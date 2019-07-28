package com.redflex.billing.discount;

public class ClearanceDiscount {

	private static final float discountPercentage = 20;
   
	public static double calculateDiscountedPrice(double totalPrice) throws Exception {
		return (totalPrice-((totalPrice) * (discountPercentage/100)));
	}

}
