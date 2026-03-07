package com.tp5jee.servlets;

import com.tp5jee.models.Category;
import com.tp5jee.models.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.tp5jee.dao.ProduitDAO;

import java.io.IOException;

@WebServlet("/UpdateProduit")
public class ModifierProduitsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Produit produit = ProduitDAO.getProduitById(id);
        request.setAttribute("produit", produit);
        request.setAttribute("categories", Category.values());
        request.getRequestDispatcher("modifierProduits.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    // 1. Read parameters from the form
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        double prix = Double.parseDouble(request.getParameter("prix"));
        String categoryStr = request.getParameter("category");
    // 2. Convert string to enum
        Category category = Category.valueOf(categoryStr); // converts "ELECTRONICS" → Category.ELECTRONICS
    // 3. Create and fill the Produit object
        Produit produit = new Produit();
        produit.setId(id);
        produit.setNom(nom);
        produit.setPrix(prix);
        produit.setCategory(category); // now uses enum
    // 4. Call DAO to update the product
        ProduitDAO produitDAO = new ProduitDAO();
        produitDAO.updateProduit(produit);
    // 5. Redirect to product list (PRG pattern)
        response.sendRedirect("lister");
    }
}
