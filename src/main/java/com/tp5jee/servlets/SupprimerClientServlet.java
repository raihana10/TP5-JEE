package com.tp5jee.servlets;

import com.tp5jee.dao.ClientDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/supprimerClient")
public class SupprimerClientServlet extends HttpServlet {

    private ClientDAO clientDAO = new ClientDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        clientDAO.delete(id);
        resp.sendRedirect("listerClients");
    }
}