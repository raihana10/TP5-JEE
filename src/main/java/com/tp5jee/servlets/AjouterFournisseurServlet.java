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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ajouterFournisseur")
public class AjouterFournisseurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProduitDAO produitDAO = new ProduitDAO();

        // Récupérer TOUS les produits
        List<Produit> tousLesProduits = produitDAO.getProduits();

        // Filtrer pour ne garder que ceux sans fournisseur
        List<Produit> produitsSansFournisseur = new ArrayList<>();
        for (Produit p : tousLesProduits) {
            if (p.getFournisseur() == null) {
                produitsSansFournisseur.add(p);
            }
        }

        // Passer la liste filtrée à la JSP
        req.setAttribute("produits", produitsSansFournisseur);

        // Aussi, passer le nombre total pour information (optionnel)
        req.setAttribute("totalProduits", tousLesProduits.size());
        req.setAttribute("produitsFiltres", produitsSansFournisseur.size());

        req.getRequestDispatcher("ajouterFournisseur.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            IOException {
        String nom = req.getParameter("nom");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        int produitId = Integer.parseInt(req.getParameter("produitId"));
        ProduitDAO produitDAO = new ProduitDAO();
        Produit produit = produitDAO.getProduitById(produitId);
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom(nom);
        fournisseur.setEmail(email);
        fournisseur.setTelephone(telephone);
        fournisseur.setProduit(produit);
        // Mettre à jour le produit avec le fournisseur pour le OneToOne
        produit.setFournisseur(fournisseur);
        FournisseurDAO dao = new FournisseurDAO();
        dao.saveOrUpdate(fournisseur);
        resp.sendRedirect("listerFournisseurs");
    }
}
