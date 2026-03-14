<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Modifier un fournisseur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Modifier le fournisseur</h1>
    <form method="post" action="modifierFournisseur">
        <input type="hidden" name="id" value="${fournisseur.id}">
        <div class="mb-3">
            <label class="form-label">Nom :</label>
            <input type="text" name="nom" class="form-control" value="${fournisseur.nom}" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Email :</label>
            <input type="email" name="email" class="form-control" value="${fournisseur.email}" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Téléphone :</label>
            <input type="text" name="telephone" class="form-control" value="${fournisseur.telephone}" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Produit associé :</label>
            <select name="produitId" class="form-select" required>
                <c:forEach var="p" items="${produits}">
                    <option value="${p.id}" ${p.id == fournisseur.produit.id ? 'selected' : ''}>
                            ${p.nom}
                    </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Enregistrer</button>
        <a href="listerFournisseurs" class="btn btn-secondary">Annuler</a>
    </form>
</div>
</body>
</html>