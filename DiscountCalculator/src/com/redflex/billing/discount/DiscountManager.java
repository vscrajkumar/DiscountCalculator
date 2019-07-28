package com.redflex.billing.discount;

import java.util.ArrayList;
import java.util.List;
import com.redflex.billing.helper.ParserHelper;
import com.redflex.billing.discount.ClearanceDiscount;

public class DiscountManager {

	List<IDiscountStrategy> discountStrategy = new ArrayList<IDiscountStrategy>();

	public DiscountManager() {

		discountStrategy.add(new BookAndGroceryItemsDiscount());
		discountStrategy.add(new ClothsItemsDiscount());
		discountStrategy.add(new OtherItemsDiscount());
	}

	public double getDiscountedPrice(ParserHelper helper) {
		
		try {
			IDiscountStrategy discount = getDiscountStrategy(helper);
			if(helper.isClerance())
				return  ClearanceDiscount.calculateDiscountedPrice(discount.calculateDiscountedPrice(helper.getQuantity(), helper.getPrice()));
			else{
				return discount.calculateDiscountedPrice(helper.getQuantity(), helper.getPrice());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public IDiscountStrategy getDiscountStrategy(ParserHelper helper) {
		
		try {
			for (IDiscountStrategy discount : discountStrategy) {
				if (discount.isBelongsThisDiscount(helper.getItemType())) {
					return discount;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new OtherItemsDiscount();
	}
}
