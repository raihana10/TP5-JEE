package com.tp5jee.servlets;

import com.tp5jee.dao.FournisseurDAO;
import com.tp5jee.dao.ProduitDAO;
import com.tp5jee.models.Fournisseur;
import com.tp5jee.models.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/modifierFournisseur")
public class ModifierFournisseurServlet extends HttpServlet {

    private FournisseurDAO fournisseurDAO = new FournisseurDAO();
    private ProduitDAO produitDAO = new ProduitDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Fournisseur fournisseur = fournisseurDAO.getById(id);
        List<Produit> produits = produitDAO.getProduits();

        req.setAttribute("fournisseur", fournisseur);
        req.setAttribute("produits", produits);
        req.getRequestDispatcher("/WEB-INF/views/modifierFournisseur.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        int produitId = Integer.parseInt(req.getParameter("produitId"));

        Fournisseur fournisseur = fournisseurDAO.getById(id);
        Produit nouveauProduit = produitDAO.getProduitById(produitId);

        // Mettre à jour les champs
        fournisseur.setNom(nom);
        fournisseur.setEmail(email);
        fournisseur.setTelephone(telephone);

        // Gérer le changement de produit
        Produit ancienProduit = fournisseur.getProduit();
        if (ancienProduit != null && !ancienProduit.equals(nouveauProduit)) {
            ancienProduit.setFournisseur(null);  // rompre l'ancien lien
        }
        fournisseur.setProduit(nouveauProduit);
        nouveauProduit.setFournisseur(fournisseur);

        fournisseurDAO.saveOrUpdate(fournisseur);

        resp.sendRedirect("listerFournisseurs");
    }
}