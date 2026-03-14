package com.tp5jee.servlets;

import com.tp5jee.dao.FournisseurDAO;
import com.tp5jee.dao.ProduitDAO;
import com.tp5jee.models.Fournisseur;
import com.tp5jee.models.Produit;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/supprimerFournisseur")
public class SupprimerFournisseurServlet extends HttpServlet {

    private FournisseurDAO fournisseurDAO = new FournisseurDAO();
    private ProduitDAO produitDAO = new ProduitDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Fournisseur fournisseur = fournisseurDAO.getById(id);

        if (fournisseur != null) {
            // Rompre le lien bidirectionnel
            Produit produit = fournisseur.getProduit();
            if (produit != null) {
                produit.setFournisseur(null);
                // On met à jour le produit (sans cascade de suppression)
                // (Optionnel : produitDAO.update(produit) si besoin)
            }
            fournisseurDAO.delete(fournisseur);
        }

        resp.sendRedirect("listerFournisseurs");
    }
}