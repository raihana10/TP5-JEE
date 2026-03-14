package com.tp5jee.servlets;

import com.tp5jee.dao.ClientDAO;
import com.tp5jee.dao.CommandeDAO;
import com.tp5jee.dao.ProduitDAO;
import com.tp5jee.models.Client;
import com.tp5jee.models.Commande;
import com.tp5jee.models.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/ajouterCommande")
public class AjouterCommandeServlet extends HttpServlet {

    private ProduitDAO produitDAO = new ProduitDAO();
    private CommandeDAO commandeDAO = new CommandeDAO();
    private ClientDAO clientDAO = new ClientDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Liste des produits (inchangé)
        req.setAttribute("produits", produitDAO.getProduits());
        // Liste des clients pour le select
        req.setAttribute("clients", clientDAO.getAll());
        req.getRequestDispatcher("ajouterCommande.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        // Récupérer les IDs des produits sélectionnés
        String[] produitsIds = req.getParameterValues("produits");
        List<Produit> produitsSelectionnes = new ArrayList<>();

        if (produitsIds != null) {
            for (String idStr : produitsIds) {
                int id = Integer.parseInt(idStr);
                Produit p = produitDAO.getProduitById(id);
                if (p != null) {
                    produitsSelectionnes.add(p);
                }
            }
        }

        // Récupérer l'ID du client
        int clientId = Integer.parseInt(req.getParameter("clientId"));
        Client client = clientDAO.getById(clientId);

        // Créer la commande
        Commande commande = new Commande();
        commande.setDate(new Date());
        commande.setProduits(produitsSelectionnes);
        commande.setClient(client);   // ← association du client

        // Sauvegarder
        commandeDAO.saveOrUpdate(commande);

        resp.sendRedirect("listerCommandes");
    }
}