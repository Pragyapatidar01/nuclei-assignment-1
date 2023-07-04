package org.assignment;

import org.assignment.ItemModels.ImportedItem;
import org.assignment.ItemModels.Item;
import org.assignment.ItemModels.ManufacturedItem;
import org.assignment.ItemModels.RawItem;

public class ItemFactory {
    public static Item createItem(String type, String name, double price, int quantity) {
        switch (type.toLowerCase()) {
            case "raw":
                return new RawItem(name, price, quantity);
            case "manufactured":
                return new ManufacturedItem(name, price, quantity);
            case "imported":
                return new ImportedItem(name, price, quantity);
            default:
                throw new IllegalArgumentException("Invalid item type");
        }
    }
}
