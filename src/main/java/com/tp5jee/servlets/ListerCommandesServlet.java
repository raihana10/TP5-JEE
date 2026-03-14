package com.tp5jee.servlets;

import com.tp5jee.dao.CommandeDAO;
import com.tp5jee.models.Commande;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listerCommandes")
public class ListerCommandesServlet extends HttpServlet {

    private CommandeDAO commandeDAO = new CommandeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Commande> commandes = commandeDAO.findAll();
        req.setAttribute("commandes", commandes);
        req.getRequestDispatcher("listerCommandes.jsp").forward(req, resp);
    }
}