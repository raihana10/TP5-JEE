<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/7/2026
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="com.tp5jee.dao.ProduitDAO" %>
<%@ page import="com.tp5jee.models.Produit" %>
<html>
<head>
    <title>Modifier un produit</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Modifier un produit</h1>

    <form action="UpdateProduit" method="POST" class="card p-4 shadow">
        <input type="hidden" name="id" value="${produit.id}">

        <div class="mb-3">
            <label for="nom" class="form-label fw-bold">Nom :</label>
            <input type="text" class="form-control" id="nom" name="nom"
                   value="${produit.nom}" required placeholder="Entrez le nom du produit">
        </div>

        <div class="mb-3">
            <label for="prix" class="form-label fw-bold">Prix :</label>
            <input type="number" step="0.01" class="form-control" id="prix" name="prix"
                   value="${produit.prix}" required placeholder="Entrez le prix">
        </div>

        <div class="mb-3">
            <label for="category" class="form-label fw-bold">Catégorie :</label>
            <select name="category" id="category" class="form-select" required>
                <option value="">-- Choisir une catégorie --</option>
                <c:forEach var="c" items="${categories}">
                    <option value="${c}" ${c == produit.category ? 'selected' : ''}>
                            ${c}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="d-flex gap-2">
            <button type="submit" class="btn btn-primary"
                    onclick="return confirm('Are you sure you want to update this product?')">
                Mettre à jour
            </button>
            <a href="lister" class="btn btn-secondary">Annuler</a>
        </div>
    </form>
</div>

<!-- Optional: Add Bootstrap JS for better form validation styling -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>