package com.tp5jee.servlets;

import com.tp5jee.dao.ClientDAO;
import com.tp5jee.models.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listerClients")
public class ListerClientsServlet extends HttpServlet {

    private ClientDAO clientDAO = new ClientDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Client> clients = clientDAO.getAll();
        req.setAttribute("clients", clients);
        req.getRequestDispatcher("listerClients.jsp").forward(req, resp);
    }
}