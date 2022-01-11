package edu.ucsb.cs56.pconrad.menuitem;

public class MenuItem {

    private String name;
    private int priceInCents;
    private String category;

    /**
     * Custom exception thrown when getPrice is called with a width
     * that is too narrow for the formatted price.
     */

    public static class TooNarrowException extends RuntimeException {
    }

    public MenuItem(String name, int priceInCents, String category) {
        this.name = name;
        this.priceInCents = priceInCents;
        this.category = category;
    }

    /**
     * Returns the category of the menu item
     */

    public String getCategory() {
        return this.category;
    }

    /**
     * Returns the category of the menu item.
     */

    public String getName() {
        return this.name;
    }

    /**
     * Returns the price, formatted as a string with a $.
     * For example "$0.99", "$10.99", or "$3.50"
     * @return a toString version of the priceInCents.
     */

    public String getPrice() {
        int cents = this.priceInCents;
        if (cents == 0) {
            return "$0.00";
        } else if (cents < 10) {
            return "$0.0" + Integer.toString(cents);
        } else if (cents < 100) {
            return "$0." + Integer.toString(cents);
        } else if (cents % 100 == 0) {
            return "$" + Integer.toString(cents / 100) + ".00";
        } else {
            return "$" + Integer.toString(cents / 100) + "." + Integer.toString(cents % 100);
        }
    }

    /**
     * Returns the price, formatted as a string with a $,
     * right justified in a field with the specified width.
     * For example "$0.99", "$10.99", or "$3.50".
     * <p>
     * If the width is too small, throws TooNarrowException
     *
     * @param width width of returned string
     */

    public String getPrice(int width) {
        String result;
        int cents = this.priceInCents;
        if (cents == 0) {
            result = "$0.00";
        } else if (cents < 10) {
            result = "$0.0" + Integer.toString(cents);
        } else if (cents < 100) {
            result = "$0." + Integer.toString(cents);
        } else if (cents % 100 == 0) {
            result = "$" + Integer.toString(cents / 100) + ".00";
        } else {
            result = "$" + Integer.toString(cents / 100) + "." + Integer.toString(cents % 100);
        }
        if (result.length() > width) {  throw new TooNarrowException(); }
        return result;
    }

    /**
     * get the price in cents only
     * @return an int, the priceInCents private variable.
     */

    public int getPriceInCents() {
        return this.priceInCents; // stub!
    }

    /**
     * return a string in csv format, in the order name,price,cateogry.
     * For example <code>Small Poke Bowl,1049,Poke Bowls</code>
     *
     * @return string in csv format
     */

    @Override
    public String toString() {
        return this.name + "," + Integer.toString(this.priceInCents) + "," + this.category;
    }

}
