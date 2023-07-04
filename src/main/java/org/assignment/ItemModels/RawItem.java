package org.assignment.ItemModels;

public class RawItem extends Item{
    public RawItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTax() {
        return 0.125 * price;
    }
}

