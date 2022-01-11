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
     * For example "$0.99", "$10.99", or "$3.50".
     */

    public String getPrice() {
        String centsString = Integer.toString(this.priceInCents);
        String dollarPart;
        String centPart;
        if (this.priceInCents == 0) {
            return "$0.00";
        } else if (this.priceInCents < 10) {
            return "$0.0" + centsString;
        } else if (this.priceInCents < 100) {
            return "$0." + centsString;
        }
        dollarPart = centsString.substring(0, centsString.length() - 2);
        centPart = centsString.substring(centsString.length() - 2);
        return "$" + dollarPart + "." + centPart;
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
        String centsString = Integer.toString(this.priceInCents);
        String dollarPart;
        String centPart;
        String result;

        if (this.priceInCents == 0) {
            result = "$0.00";
        } else if (this.priceInCents < 10) {
            result = "$0.0" + centsString;
        } else if (this.priceInCents < 100) {
            result = "$0." + centsString;
        } else {
            dollarPart = centsString.substring(0, centsString.length() - 2);
            centPart = centsString.substring(centsString.length() - 2);
            result = "$" + dollarPart + "." + centPart;
        }

        if (result.length() > width) { throw new TooNarrowException(); }
        if (result.length() < width) {
            while (result.length() != width) {
                result = " " + result;
            }
        }
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
