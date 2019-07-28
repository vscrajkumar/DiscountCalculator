package com.redflex.billing.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.redflex.billing.discount.DiscountManager;
import com.redflex.billing.helper.ParserHelper;
import com.redflex.billing.helper.RoundOfHelper;

public class BillingStation {

	public List<String> purchasedItemsList;
	public ParserHelper helper;
	public DiscountManager discountManager = new DiscountManager();
	
	public BillingStation scanPurchasedItems() {

		Scanner in = new Scanner(System.in);
		try {
			purchasedItemsList = new ArrayList<String>();
			int itemsCount = in.nextInt();
			
			for (int items = 0; items < itemsCount; items++) {
				String purcheseItem="";
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				purcheseItem=reader.readLine();
				purchasedItemsList.add(purcheseItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return this;
	}

	public BillingStation calculateAndPrintDiscountedBilling() {

		float discountedPrice = 0;
		float discountedTotalPrice = 0;
		float originalTotalPrice=0;
		try {
			for (String items : purchasedItemsList) {
				helper = new ParserHelper(items);
				helper.parse();
				discountedPrice = RoundOfHelper.roundOfAmount(discountManager.getDiscountedPrice(helper));
				originalTotalPrice+=helper.getPrice();
				discountedTotalPrice += discountedPrice;
				String originalItemType=helper.isClerance()?("clearance "+helper.getItemType()):helper.getItemType();
				System.out.println(helper.getQuantity() + " " + originalItemType+ " at " + discountedPrice);
			}
			System.out.println("Total:" + discountedTotalPrice);
			System.out.println("You saved:" + RoundOfHelper.roundOfAmount(originalTotalPrice-discountedTotalPrice));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public static void main(String[] args) {

		new BillingStation().scanPurchasedItems().calculateAndPrintDiscountedBilling();
	}
}
