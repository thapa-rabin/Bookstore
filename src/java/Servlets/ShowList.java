/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.*;
/**
 *
 * @author thapa.rbn24
 */
public class ShowList extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Create an instance of entity list
        BookList Booklist = new BookList();
        /*
        //Construct entity items (books)
        Book book1 = new Book("The Catcher in the Rye",
                              "9780316450867",
                              "J. D. Salinger",
                              "N002001001",
                               5.09);
        Book book2 = new Book("Guns, Germs, and Steel",
                              "9788970127248",
                              "Jared Diamond",
                              "Fair",
                               18.95);
        Book book3 = new Book("The Stranger",
                              "9780141182506",
                              "Albert Camus",
                              "New",
                               9.99);
        Book book4 = new Book("Sapiens: A Brief History of Humankind",
                              "9780062316097",
                              "Y. N. Harari",
                              "Poor",
                               19.99);
        Book book5 = new Book("12 Rules for Life",
                              "9780735276796",
                              "Jordan Peterson",
                              "Like New",
                               14.99);
        
        //Add books to Booklist
        Booklist.addToList(book1);
        Booklist.addToList(book2);
        Booklist.addToList(book3);
        Booklist.addToList(book4);
        Booklist.addToList(book5);
        */
        //Retrieve session for this client (or create a new one if none exists)
        HttpSession session = request.getSession();
        
        //load books from database
        Booklist.loadBooks();
        
        //Store Booklist and booklist in current session
        session.setAttribute("booklist", Booklist.bookList);
        session.setAttribute("Booklist", Booklist);
        
        //Forward to webpage
        getServletContext().getRequestDispatcher("/DisplayBooks.jsp").forward(request, response);
    
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}