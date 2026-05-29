package com.bytebytego.grocery_store.grocery.discount.strategy;

import java.math.BigDecimal;

// Interface for discount calculation strategies
public interface DiscountCalculationStrategy {
    // Calculates the discounted price based on the original price
    BigDecimal calculateDiscountedPrice(BigDecimal originalPrice);
}

