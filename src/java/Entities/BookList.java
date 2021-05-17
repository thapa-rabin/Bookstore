/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.*;
import java.sql.*;
/**
 *
 * @author thapa.rbn24
 */
public class BookList {
    //list to store books
    public ArrayList<Book> bookList; //consider making bookList private
    public static ArrayList<String> conditions = new ArrayList<String>(
        Arrays.asList("New",
                      "Like New",
                      "Good",
                      "Fair",
                      "Poor")
    );
    
    public BookList() {
        this.bookList = new ArrayList<>();
    }
    
    //set book list
    public void setList(ArrayList<Book> b) {
        this.bookList = b;
    }

    //get book list
    public ArrayList<Book> getList() {
        return bookList;
    }
    
    //finds book in list or returns null
    public Book searchInList(String book_id) {
        for(Book b : this.bookList) {
            if(b.getBookID().equals(book_id))
                return b;
        }
        return null;
    }
    
    //adding books
    public void addToList(Book book) {
        this.bookList.add(book);
    }
    
    //removing books
    public void removeFromList(Book book) {
        this.bookList.remove(book);
    }
    
    //returns the total price of books in the list
    public double getTotalPrice() {
        double total = 0;
        for(Book b : this.bookList) {
            total += b.getPrice();
        }
        return total;
    }
    
    // Get the existing courses from the database and add them to the list
    public void loadBooks() {
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        try {
            // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Bookstore", "app", "app");
        }
        catch (SQLException ex) {
            System.out.println("Connection failed!");
        }
        catch (Exception ex) {
            System.out.println("No driver!");
        }
        
        try {
            // Create and execute query statement for all in Courses table,
            // storing links to matching records in ResultSet object results.
            statement = connection.createStatement();
            results = statement.executeQuery("select * from BOOKLIST");
            
            // Loop to next record in results, while there is a next record.
            while (results.next()) {
                
                // Get each field of current record (as appropriate type)
                String name = results.getString("name");
                String isbn = results.getString("isbn");
                String author = results.getString("author");
                String condition = results.getString("condition");
                Double price = results.getDouble("price");
                
                // Construct a new course object from that data, and add to list
                Book b = new Book(name, isbn, author, condition, price); 
                bookList.add(b);
            }
        }        
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
    }
   
    // Save new book to database
    public static void saveBook(String name, String isbn, 
            String author, String condition, double price) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Bookstore", "app", "app");
        }
        catch (SQLException ex) {
            System.out.println("Connection failed!");
        }
        catch (Exception ex) {
            System.out.println("No driver!");
        }
        
        try {
            /*
            String insert = "insert into Courses "+
                       "(courseprefix, coursenumber, coursename, minhours, maxhours, project)"+
                       "values ('"+prefix+"','"+number+"','"+name+"','"+
                                   min+"','"+max+"','"+project+"')";
            */
            String template = "insert into BOOKLIST "
                    + "(name, isbn, author, condition, price)"
                    + "values (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(template);
            statement.setString(1, name);
            statement.setString(2, isbn);
            statement.setString(3, author);
            statement.setString(4, condition);
            statement.setDouble(5, price);

            int changed = statement.executeUpdate();
            System.out.println(changed+" records added");
        }      
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
        
    }    
    
    
}
