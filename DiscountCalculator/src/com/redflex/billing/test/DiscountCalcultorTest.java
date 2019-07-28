package com.redflex.billing.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.redflex.billing.discount.DiscountManager;
import com.redflex.billing.helper.ParserHelper;
import com.redflex.billing.helper.RoundOfHelper;

public class DiscountCalcultorTest {

	ParserHelper helper;
	DiscountManager discountManager = new DiscountManager();
	
	@Test
	public void assertCheck_BookItems() throws Exception {

		float discountedPrice = 0;
		
		helper = new ParserHelper("1 book at 14.49");
		helper.parse();
		discountedPrice = RoundOfHelper.roundOfAmount(discountManager.getDiscountedPrice(helper));
		assertEquals(discountedPrice,(float)13.77);
	}

	@Test
	public void assertCheck_ClothsItems() throws Exception {

		float discountedPrice = 0;
		
		helper = new ParserHelper("1 dress at 9.75");
		helper.parse();
		discountedPrice = RoundOfHelper.roundOfAmount(discountManager.getDiscountedPrice(helper));
		assertEquals(discountedPrice,(float)0.95);
	}

	@Test
	public void assertCheck_OtherItems() throws Exception {

		float discountedPrice = 0;

		helper = new ParserHelper("1 bottle of perfume at 27.99");
		helper.parse();
		discountedPrice = RoundOfHelper.roundOfAmount(discountManager.getDiscountedPrice(helper));
		assertEquals(discountedPrice,(float)27.15);
	}
	
	@Test
	public void assertCheck_ClearenceItems() throws Exception {

		float discountedPrice = 0;

		helper = new ParserHelper("1 clearance chocolate bar at 2.00");
		helper.parse();
		discountedPrice = RoundOfHelper.roundOfAmount(discountManager.getDiscountedPrice(helper));
		assertEquals(discountedPrice,(float)1.52);
	}
	

}
