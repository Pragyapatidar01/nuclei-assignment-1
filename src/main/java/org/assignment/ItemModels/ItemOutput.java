package org.assignment.ItemModels;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemOutput {
    final String name;
    final double price;
    final double salesTax;
    final double pricePerItem;
    final double totalPrice;
}
