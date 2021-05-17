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

import Entities.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author thapa.rbn24
 */
public class Cart extends HttpServlet {

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
        
        //retrieve parameters from webpage
        String selectedBookID = (String)request.getParameter("selectedBookID");
        String deleteBookID = (String)request.getParameter("deleteBookID");
        
        //retrieve session for this client (or create a new one if none exists)
        HttpSession session = request.getSession();
        
        //Create a Cart (instance of BookList) if it doesn't exist
        BookList Cart = new BookList();
        if(session.getAttribute("Cart") != null)
            Cart = (BookList)session.getAttribute("Cart");          
        
        //retrieve Booklist from current session
        BookList Booklist = (BookList)session.getAttribute("Booklist");
        
        if(selectedBookID != null)
            Cart.addToList(Booklist.searchInList(selectedBookID)); //add to Cart
        if(deleteBookID != null)
            Cart.removeFromList(Cart.searchInList(deleteBookID)); //remove from Cart
        
        //Store Cart in current session
        session.setAttribute("Cart", Cart);
        session.setAttribute("cart", Cart.bookList);
        
        //Forward to webpage
        getServletContext().getRequestDispatcher("/DisplayCart.jsp").forward(request, response);
    
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
