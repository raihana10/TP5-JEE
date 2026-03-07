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
    <title>Ajouter un produit</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Ajouter un nouveau produit</h1>

    <form method="post" action="ajouter" class="card p-4 shadow">
        <div class="mb-3">
            <label for="nom" class="form-label fw-bold">Nom :</label>
            <input type="text" class="form-control" id="nom" name="nom" required placeholder="Entrez le nom du produit" />
        </div>

        <div class="mb-3">
            <label for="prix" class="form-label fw-bold">Prix :</label>
            <input type="number" class="form-control" id="prix" name="prix" step="0.01" required placeholder="Entrez le prix" />
        </div>

        <div class="mb-3">
            <label for="category" class="form-label fw-bold">Catégorie :</label>
            <select name="category" class="form-select" id="category" required>
                <option value="">-- Choisir une catégorie --</option>
                <c:forEach var="cat" items="${categories}">
                    <option value="${cat}">${cat}</option>
                </c:forEach>
            </select>
        </div>

        <div class="d-flex gap-2">
            <button type="submit" class="btn btn-success">Ajouter le produit</button>
            <a href="lister" class="btn btn-secondary">Retour à la liste</a>
        </div>
    </form>
</div>

<!-- Optional: Add Bootstrap JS for better form validation styling -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>