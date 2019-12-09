////////////////////////////////////////////////////////////////////
// Marco Positello 1167693
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import it.unipd.tos.model.ItemType;

public class MenuItem {
    private ItemType item;
    private String name;
    private double price;

    public MenuItem(ItemType item, String name, double price) {
        super();
        this.item = item;
        this.name = name;
        this.price = price;
    }

    public ItemType getItemType() {
        return item;
    }

    public double getPrice() {
        return price;
    }
}
