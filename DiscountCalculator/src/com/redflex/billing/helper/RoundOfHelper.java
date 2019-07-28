package com.redflex.billing.helper;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RoundOfHelper {

    private static DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public static Float roundOfAmount(double amount) throws Exception {
	    decimalFormat.setRoundingMode(RoundingMode.UP);
    	return Float.parseFloat(decimalFormat.format(amount));
    }
}
