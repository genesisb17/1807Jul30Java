package com.iantimothyjohnson.assignments.project1.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * A class consisting of various static helper methods for working with strings.
 * 
 * @author Ian Johnson
 */
public final class StringUtils {
    /**
     * The DecimalFormat to use for formatting currency strings.
     */
    public static final DecimalFormat MONEY_FORMAT = new DecimalFormat(
        "$#,##0.00");
    
    private StringUtils() {
    }
    
    /**
     * Formats a BigDecimal as a monetary amount string.
     * 
     * @param amount the amount to format
     * @return a nicely formatted string representing the amount
     */
    public static String formatMoney(BigDecimal amount) {
        return MONEY_FORMAT.format(amount);
    }
}
