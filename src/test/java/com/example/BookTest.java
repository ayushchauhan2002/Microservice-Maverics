package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;

    @BeforeEach
    public void setUp() {
        // Initialize the book object before each test
        book = new Book(1, "Java Programming", "John Doe", 29.99, "Programming");
    }

    @Test
    public void testBookConstructor() {
        // Test that the Book object was created properly using the constructor
        assertEquals(1, book.getBookId());
        assertEquals("Java Programming", book.getTitle());
        assertEquals("John Doe", book.getAuthor());
        assertEquals(29.99, book.getPrice());
        assertEquals("Programming", book.getCategory());
    }

    @Test
    public void testSettersAndGetters() {
        // Test that the setter methods work properly
        book.setBookId(2);
        book.setTitle("Advanced Java");
        book.setAuthor("Jane Doe");
        book.setPrice(39.99);
        book.setCategory("Technology");

        assertEquals(2, book.getBookId());
        assertEquals("Advanced Java", book.getTitle());
        assertEquals("Jane Doe", book.getAuthor());
        assertEquals(39.99, book.getPrice());
        assertEquals("Technology", book.getCategory());
    }

    @Test
    public void testToString() {
        // Test that the toString method returns the correct string representation
        String expected = "Book{bookId=1, title='Java Programming', author='John Doe', price=29.99, category='Programming'}";
        assertEquals(expected, book.toString());
    }

    @Test
    public void testDefaultValues() {
        // Test default constructor scenario if it exists
        Book book2 = new Book(0, "", "", 0.0, "");
        assertEquals(0, book2.getBookId());
        assertEquals("", book2.getTitle());
        assertEquals("", book2.getAuthor());
        assertEquals(0.0, book2.getPrice());
        assertEquals("", book2.getCategory());
    }
}
