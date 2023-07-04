package org.assignment.ItemModels;

public class ImportedItem extends Item{

    public ImportedItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTax() {
        double tax = 0.1 * price;
        double totalCost = price + tax;
        double surcharge;

        if (totalCost <= 100)
            surcharge = 5;
        else if (totalCost <= 200)
            surcharge = 10;
        else
            surcharge = 0.05 * totalCost;

        return tax + surcharge;
    }

}
