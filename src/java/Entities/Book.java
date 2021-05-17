/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author thapa.rbn24
 */
public class Book {
    
    private String name; 
    private String bookID; //unique identifier - ISBN
    private String author;
    private String condition;
    private double price;
    
    //default constructor
    public Book() {
        this.name = "NA";
        this.bookID = "0";
        this.author = "NA";
        this.condition = "NA";
        this.price = 0;
    }
    
    //parameterized constructor
    public Book(String name, String bookID, String author,  String condition, double price) {
        this.name = name;
        this.bookID = bookID;
        this.author = author;
        this.condition = condition;
        this.price = price;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double p) {
        this.price = p;
    }
}
