package org.assignment;
import org.assignment.ItemModels.Item;
import org.assignment.ItemModels.ItemOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void printAggregatedItemDetails(final List<ItemOutput> itemOutputsList)
    {
        System.out.println("This is the list of all the items: ");
        itemOutputsList.forEach(itemOutputs -> {
            System.out.println("Item Name: " + itemOutputs.getName());
            System.out.println("Item Price: " + itemOutputs.getPrice());
            System.out.println("Sales Tax Liability per Item: " + itemOutputs.getSalesTax());
            System.out.println("Final Price per Item: " + itemOutputs.getPricePerItem());
            System.out.println("Total Final Price for the quantity requested: " + itemOutputs.getTotalPrice());
            System.out.println("-----------------------------------------");
        });
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final List<ItemOutput> itemOutputsList = new ArrayList<>();
        do {
            System.out.print("Enter item name: ");
            final String name = scanner.nextLine();

            System.out.print("Enter item price: ");
            final String priceStr = scanner.nextLine();

            System.out.print("Enter item quantity: ");
            final String quantityStr = scanner.nextLine();

            System.out.print("Enter item type (raw/manufactured/imported): ");
            final String type = scanner.nextLine();

            // validating the name field
            if(name == null || name.isEmpty()){
                System.out.println("name cannot be null or empty");
                return;
            }

            double price = 0;
            int quantity = 0;

            // validating if price and quantity are of the required type and not null
            // giving user appropriate message but not exiting the program
            try {
                price = Double.parseDouble(priceStr);
                quantity = Integer.parseInt(quantityStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price or quantity format");
            } catch (NullPointerException e){
                System.out.println("price or quantity is null or empty");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            try {
                Item item = ItemFactory.createItem(type, name, price, quantity);

                // we want to print the item info collectively after all inputs
                final ItemOutput itemOutput = item.addItemDetails();
                itemOutputsList.add(itemOutput);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Do you want to enter details of any other item? (y/n): ");
        } while (scanner.nextLine().equalsIgnoreCase(Y));

        printAggregatedItemDetails(itemOutputsList);
        scanner.close();

    }
    private static final String Y = "y";
}