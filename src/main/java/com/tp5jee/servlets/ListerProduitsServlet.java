package com.tp5jee.servlets;

import com.tp5jee.dao.ProduitDAO;
import com.tp5jee.models.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/lister")
public class ListerProduitsServlet extends HttpServlet {
    private ProduitDAO produitDAO = new ProduitDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produit> pList = produitDAO.getProduits();
        request.setAttribute("produits", pList);
        request.getRequestDispatcher("/listerProduits.jsp")
                .forward(request, response);
    }
}
