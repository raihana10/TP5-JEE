package com.tp5jee.servlets;

import com.tp5jee.dao.FournisseurDAO;
import com.tp5jee.models.Fournisseur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listerFournisseurs")
public class ListerFournisseursServlet extends HttpServlet {
    private FournisseurDAO fournisseurDAO = new FournisseurDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Fournisseur> fournisseurs = fournisseurDAO.getAll();
        req.setAttribute("fournisseurs", fournisseurs);
        req.getRequestDispatcher("/WEB-INF/views/listerFournisseurs.jsp").forward(req, resp);
    }
}
