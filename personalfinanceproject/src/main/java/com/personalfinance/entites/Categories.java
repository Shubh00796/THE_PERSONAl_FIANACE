package com.personalfinance.entites;
public enum Categories {
    FOOD("Food"),
    TRAVEL("Travel"),
    HEALTHCARE("Healthcare"),
    SHOPPING("Shopping"),
    RENT("Rent"),
    OTHERS("Others");

    private final String category;

    Categories(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
    
}
