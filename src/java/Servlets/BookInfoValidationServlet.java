/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
public class BookInfoValidationServlet extends HttpServlet {

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

        HttpSession session = request.getSession();
        String nextPage = "/DisplayBooks.jsp";
        
        //read all form parameters
        String name = request.getParameter("name");
        String isbn = request.getParameter("isbn"); // for now isbn is bookID
        String author = request.getParameter("author");
        String condition = request.getParameter("condition");
        String price = request.getParameter("price");
        
        //create a new BookInfoErrorList object
        //that we might need to pass to JSP
        BookInfoErrorList errors = new BookInfoErrorList();
        
        //call all validation methods passing respective parameters
        //and errors (object) to each
        //any error detected will be stored in errors object
        boolean isNameValid = BookInfoValidation.validateName(name, errors);
        boolean isIsbnValid = BookInfoValidation.validateIsbn(isbn, errors);
        boolean isAuthorValid = BookInfoValidation.validateAuthor(author, errors);
        boolean isConditionValid = BookInfoValidation.validateCondition(condition, errors);
        boolean isPriceValid = BookInfoValidation.validatePrice(price, errors);
       
        // If no errors were found, create the new book.
        // Otherwise, redirect back to the input page.
        if (isNameValid && isIsbnValid && isAuthorValid && isConditionValid && isPriceValid) {
            BookList Booklist = (BookList)session.getAttribute("Booklist");
            if (Booklist == null) {
                Booklist = new BookList();
            }
            Book newBook = new Book(name, isbn, author, condition, Double.parseDouble(price));
            Booklist.addToList(newBook);
            //save new book in database
            Booklist.saveBook(name, isbn, author, condition, Double.parseDouble(price));

            //Booklist.loadBooks();
            session.setAttribute("Booklist", Booklist);
            
        }
        else {            
            nextPage = "/AddBooks.jsp";
            
            //add the validation object to the session for use by the JSP
            request.setAttribute("errors", errors);
        }
        
        //redirect to webpage
        getServletContext().getRequestDispatcher(nextPage).forward(request, response);
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
