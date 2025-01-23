package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;
    private Order order1;
    private Order order2;

    @BeforeEach
    public void setUp() {
        // Create a User object
        user = new User("John Doe", "johndoe@example.com", "123 Elm Street");

        // Create some Order objects
        order1 = new Order();
        order2 = new Order();

        // Add orders to the user's order history
        user.addToOrderHistory(order1);
        user.addToOrderHistory(order2);
    }

    @Test
    public void testConstructor() {
        // Test if the User object is constructed correctly
        assertEquals("John Doe", user.getName(), "The name should be set correctly.");
        assertEquals("johndoe@example.com", user.getEmail(), "The email should be set correctly.");
        assertEquals("123 Elm Street", user.getAddress(), "The address should be set correctly.");
//        assertTrue(user.getOrderHistory().isEmpty(), "The order history should be empty initially.");
    }

    @Test
    public void testGettersAndSetters() {
        // Test the setters and getters
        user.setName("Jane Doe");
        user.setEmail("janedoe@example.com");
        user.setAddress("456 Oak Street");

        assertEquals("Jane Doe", user.getName(), "The name should be updated.");
        assertEquals("janedoe@example.com", user.getEmail(), "The email should be updated.");
        assertEquals("456 Oak Street", user.getAddress(), "The address should be updated.");
    }

    @Test
    public void testAddToOrderHistory() {
        // Test adding an order to the user's order history
        Order newOrder = new Order();
        user.addToOrderHistory(newOrder);

        // Verify that the order was added to the history
        assertEquals(3, user.getOrderHistory().size(), "Order history should contain 3 orders.");
        assertTrue(user.getOrderHistory().contains(newOrder), "Order history should contain the new order.");
    }

    @Test
    public void testToString() {
        // Test the toString method
        String expectedString = "User{name='John Doe', email='johndoe@example.com', address='123 Elm Street', orderHistory=2}";
        assertEquals(expectedString, user.toString(), "The toString method should return the correct string.");
    }
}
