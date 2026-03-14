package com.tp5jee.servlets;

import com.tp5jee.dao.ClientDAO;
import com.tp5jee.models.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajouterClient")
public class AjouterClientServlet extends HttpServlet {

    private ClientDAO clientDAO = new ClientDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("ajouterClient.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String nom = req.getParameter("nom");
        String email = req.getParameter("email");

        Client client = new Client(nom, email);
        clientDAO.saveOrUpdate(client);

        resp.sendRedirect("listerClients");
    }
}