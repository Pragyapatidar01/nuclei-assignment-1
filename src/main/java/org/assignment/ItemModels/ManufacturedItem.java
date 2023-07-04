package org.assignment.ItemModels;

public class ManufacturedItem extends Item{

    public ManufacturedItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTax() {
        return 0.125 * price + 0.02 * (price + 0.125 * price);
    }

}
