package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    private Cart cart;
    private CartItem item1;
    private CartItem item2;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        // Create test data
        book1 = new Book(1, "Java Programming", "John Doe", 29.99, "Programming");
        book2 = new Book(2, "Advanced Java", "Jane Doe", 39.99, "Programming");

        item1 = new CartItem(book1, 2); // 2 copies of "Java Programming"
        item2 = new CartItem(book2, 1); // 1 copy of "Advanced Java"

        cart = new Cart();
    }

    @Test
    public void testAddItem() {
        // Add items to the cart
        cart.addItem(item1);
        cart.addItem(item2);

        // Test if the cart contains the items
        assertEquals(2, cart.getItems().size(), "Cart should contain 2 items.");
        assertTrue(cart.getItems().contains(item1), "Cart should contain item1.");
        assertTrue(cart.getItems().contains(item2), "Cart should contain item2.");
    }

    @Test
    public void testRemoveItem() {
        // Add items to the cart
        cart.addItem(item1);
        cart.addItem(item2);

        // Remove item1 and check the cart
        cart.removeItem(item1);
        assertEquals(1, cart.getItems().size(), "Cart should contain 1 item after removal.");
        assertFalse(cart.getItems().contains(item1), "Cart should not contain item1 after removal.");
        assertTrue(cart.getItems().contains(item2), "Cart should still contain item2.");
    }

    @Test
    public void testCalculateTotalCost() {
        // Add items to the cart
        cart.addItem(item1);
        cart.addItem(item2);

        // Calculate total cost
        double expectedTotalCost = (book1.getPrice() * 2) + book2.getPrice();
        assertEquals(expectedTotalCost, cart.calculateTotalCost(), "Total cost should be calculated correctly.");
    }

    @Test
    public void testApplyDiscount() {
        // Add items to the cart
        cart.addItem(item1);
        cart.addItem(item2);

        // Calculate total cost before discount
        double originalTotalCost = cart.calculateTotalCost();

        // Apply a 10% discount
        cart.applyDiscount(10);

        // Calculate the expected total cost after discount
        double expectedTotalCostAfterDiscount = originalTotalCost - (originalTotalCost * 0.10);
        assertEquals(expectedTotalCostAfterDiscount, cart.calculateTotalCost(), "Total cost should be reduced by 10%.");
    }

    @Test
    public void testEmptyCart() {
        // Verify the cart is empty initially
        assertTrue(cart.getItems().isEmpty(), "Cart should be empty initially.");
    }
}
