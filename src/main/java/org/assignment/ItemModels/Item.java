package org.assignment.ItemModels;

public abstract class Item {
    protected String name;
    protected double price;
    protected int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTax();

    public ItemOutput addItemDetails(){

        double tax = calculateTax();
        double finalPricePerItem = price + tax;
        double totalFinalPrice = finalPricePerItem * quantity;

        return ItemOutput.builder()
                .name(name)
                .price(price)
                .salesTax(tax)
                .pricePerItem(finalPricePerItem)
                .totalPrice(totalFinalPrice)
                .build();
    }
}