package com.tp5jee.servlets;

import com.tp5jee.dao.CommandeDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/supprimerCommande")
public class SupprimerCommandeServlet extends HttpServlet {

    private CommandeDAO commandeDAO = new CommandeDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        commandeDAO.delete(id);
        resp.sendRedirect("listerCommandes");
    }
}