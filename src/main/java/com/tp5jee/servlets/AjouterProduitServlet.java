package com.tp5jee.servlets;

import com.tp5jee.dao.ProduitDAO;
import com.tp5jee.models.Category;
import com.tp5jee.models.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ajouter")
public class AjouterProduitServlet extends HttpServlet {
    private ProduitDAO produitDAO = new ProduitDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // On envoie les catégories à la JSP
        request.setAttribute("categories", Category.values());
        // Afficher le formulaire d’ajout
        request.getRequestDispatcher("/ajouterProduit.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        double prix = Double.parseDouble(request.getParameter("prix"));
        Category category = Category.valueOf(request.getParameter("category"));
        if (nom != null && !nom.isBlank() && prix > 0) {
            Produit p = new Produit(nom, prix, category);
            produitDAO.addProduit(p);
        }
// Redirection après POST (PRG pattern)
        response.sendRedirect("lister");
    }
}
