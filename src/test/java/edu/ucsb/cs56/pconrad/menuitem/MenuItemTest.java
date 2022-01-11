package edu.ucsb.cs56.pconrad.menuitem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

    private MenuItem smallPokeBowl;

    @Test
    public void test_getCategory() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("Poke Bowls", smallPokeBowl.getCategory());
    }
    
    @Test
    public void test_getName() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("Small Poke Bowl", smallPokeBowl.getName());
    }

    @Test
    public void test_getPrice_zero() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 0, "Poke Bowls");
        assertEquals("$0.00", smallPokeBowl.getPrice());
    }

    @Test
    public void test_getPrice_cents() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 9, "Poke Bowls");
        assertEquals("$0.09", smallPokeBowl.getPrice());
    }

    @Test
    public void test_getPrice_boundary() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 10, "Poke Bowls");
        assertEquals("$0.10", smallPokeBowl.getPrice());
    }

    @Test
    public void test_getPrice_cents2() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 49, "Poke Bowls");
        assertEquals("$0.49", smallPokeBowl.getPrice());
    }

    @Test
    public void test_getPrice_boundary2() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 100, "Poke Bowls");
        assertEquals("$1.00", smallPokeBowl.getPrice());
    }

    @Test
    public void test_getPrice_normal() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("$10.49", smallPokeBowl.getPrice());
    }

    @Test
    public void test_getPrice_10() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("$10.49", smallPokeBowl.getPrice(10));
    }

    @Test
    public void test_getPrice_11_small() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 9, "Poke Bowls");
        assertEquals("$0.09", smallPokeBowl.getPrice(11));
    }

    @Test
    public void test_getPrice_11_boundary() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 10, "Poke Bowls");
        assertEquals("$0.10", smallPokeBowl.getPrice(11));
    }

    @Test
    public void test_getPrice_12() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 49, "Poke Bowls");
        assertEquals("$0.49", smallPokeBowl.getPrice(12));
    }

    @Test
    public void test_getPrice_13() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 100, "Poke Bowls");
        assertEquals("$1.00", smallPokeBowl.getPrice(13));
    }

    @Test
    public void test_getPrice_14() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 0, "Poke Bowls");
        assertEquals("$0.00", smallPokeBowl.getPrice(14));
    }

    @Test
    public void test_getPrice_7() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("$10.49", smallPokeBowl.getPrice(7));
    }

    @Test
    public void test_getPrice_6() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("$10.49", smallPokeBowl.getPrice(6));
    }

    @Test
    public void test_getPrice_5() {
        assertThrows(MenuItem.TooNarrowException.class, () -> {
            smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
            smallPokeBowl.getPrice(5);
        });
    }

    @Test
    public void test_getPrice_0() {
        assertThrows(MenuItem.TooNarrowException.class, () -> {
            smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
            smallPokeBowl.getPrice(0);
        });
    }

    @Test
    public void test_getPriceInCents() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals(1049, smallPokeBowl.getPriceInCents());
    }

    @Test
    public void test_toString() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("Small Poke Bowl,1049,Poke Bowls", smallPokeBowl.toString());
    }

}
