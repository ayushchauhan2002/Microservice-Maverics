package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartItemTest {

    private Book book;
    private CartItem cartItem;

    @BeforeEach
    public void setUp() {
        // Create a Book object to be used in CartItem tests
        book = new Book(1, "Java Programming", "John Doe", 29.99, "Programming");
        // Create a CartItem object with the book and quantity 2
        cartItem = new CartItem(book, 2);
    }

    @Test
    public void testConstructor() {
        // Test that the CartItem object is correctly constructed
        assertEquals(book, cartItem.getBook(), "The book in the CartItem should be the one passed in the constructor.");
        assertEquals(2, cartItem.getQuantity(), "The quantity in the CartItem should be 2.");
    }

    @Test
    public void testSettersAndGetters() {
        // Test setter methods
        Book newBook = new Book(2, "Advanced Java", "Jane Doe", 39.99, "Programming");
        cartItem.setBook(newBook);
        cartItem.setQuantity(3);

        // Verify the changes using getter methods
        assertEquals(newBook, cartItem.getBook(), "The book should be updated.");
        assertEquals(3, cartItem.getQuantity(), "The quantity should be updated to 3.");
    }

    @Test
    public void testCalculatePrice() {
        // Test the calculatePrice method
        double expectedPrice = book.getPrice() * 2;  // 2 books, each costing 29.99
        assertEquals(expectedPrice, cartItem.calculatePrice(), "The calculated price should be correct.");
    }

    @Test
    public void testToString() {
        // Test the toString method
        String expectedString = "CartItem{book=Java Programming, quantity=2, price=" + cartItem.calculatePrice() + "}";
        assertEquals(expectedString, cartItem.toString(), "The toString method should return the expected string.");
    }

    @Test
    public void testUpdateQuantity() {
        // Test updating the quantity and recalculating price
        cartItem.setQuantity(5);
        double updatedPrice = book.getPrice() * 5;  // 5 books, each costing 29.99
        assertEquals(updatedPrice, cartItem.calculatePrice(), "The price should be updated when quantity is changed.");
    }
}
