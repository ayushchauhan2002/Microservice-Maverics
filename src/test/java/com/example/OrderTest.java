package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private User user;
    private Book book1;
    private CartItem cartItem1;
    private Order order;

    @BeforeEach
    public void setUp() {
        // Create a User object
        user = new User("John Doe", "johndoe@example.com", "123 Elm Street");

        // Create a Book object
        book1 = new Book(1, "Java Programming", "John Doe", 29.99, "Programming");

        // Create a CartItem object
        cartItem1 = new CartItem(book1, 2); // 2 copies of "Java Programming"

        // Create an Order object
        order = new Order(user, Arrays.asList(cartItem1), cartItem1.calculatePrice()); // total cost is 2 * 29.99
    }


    @Test
    public void testSaveOrderToHistory() {
        // Ensure the user has no orders initially
        assertTrue(user.getOrderHistory().isEmpty(), "User should have no orders initially.");

        // Save the order to the user's history
        order.saveOrderToHistory();

        // Verify that the order was added to the user's order history
        assertEquals(1, user.getOrderHistory().size(), "User should have 1 order in history after saving.");
        assertTrue(user.getOrderHistory().contains(order), "User's order history should contain the saved order.");
    }
}
