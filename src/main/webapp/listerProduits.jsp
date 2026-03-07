<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/7/2026
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Liste des produits</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            rel="stylesheet">
</head>
<body>
<div class="container mt-4">
<h1 class="mb-4">Liste des produits</h1>
    <table class="table table-bordered table-striped table-hover">
        <thead class="table-dark">
        <tr>
            <th>Id</th>
            <th>Nom</th>
            <th>Prix</th>
            <th>Categorie</th>
            <th>Supprimer</th>
            <th>Modifier</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${produits}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.nom}</td>
                    <td>${p.prix}</td>
                    <td>${p.category}</td>
                    <td>
                        <form action="DeleteProduit" method="POST" class="d-inline;">
                            <input type="hidden" name="id" value="${p.id}">
                            <button class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this product?')">
                                Delete
                            </button>
                        </form>
                    </td>
                    <td>
                        <a href="UpdateProduit?id=${p.id}" class="btn btn-warning btn-sm">
                            Edit
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<br>
<a href="ajouter" class="btn btn-success">Ajouter un produit</a>
</body>
</html>
