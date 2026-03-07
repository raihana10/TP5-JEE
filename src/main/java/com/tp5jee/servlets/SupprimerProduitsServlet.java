package com.tp5jee.servlets;

import com.tp5jee.dao.ProduitDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DeleteProduit")

public class SupprimerProduitsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProduitDAO produitDAO = new ProduitDAO();
    // The doPost method will handle the deletion logic when the user submits the delete form
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int produitId = Integer.parseInt(request.getParameter("id"));
    // Delete the passenger from the database
        boolean success = produitDAO.deleteProduit(produitId);
        if (success) {
    // Pass the confirmation message to the request
            request.setAttribute("message", "Product deleted successfully");
            response.sendRedirect("lister?message=Product deleted successfully");
        } else {
    // Pass the failure message to the request
            request.setAttribute("message", "Failed to delete product");
        }
    }
}
