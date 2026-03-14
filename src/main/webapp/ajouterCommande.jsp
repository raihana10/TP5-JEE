<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Ajouter une commande</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .product-checkbox-group {
            max-height: 400px;
            overflow-y: auto;
            border: 1px solid #dee2e6;
            padding: 15px;
            border-radius: 5px;
            background-color: #f8f9fa;
        }
        .product-item {
            padding: 5px;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <h1>Nouvelle commande</h1>
    <form method="post" action="${pageContext.request.contextPath}/ajouterCommande" id="commandeForm">

        <!-- Sélection du client -->
        <div class="mb-3">
            <label for="clientId" class="form-label fw-bold">Client :</label>
            <select name="clientId" id="clientId" class="form-select" required>
                <option value="">-- Choisir un client --</option>
                <c:forEach var="c" items="${clients}">
                    <option value="${c.id}">${c.nom} (${c.email})</option>
                </c:forEach>
            </select>
        </div>

        <!-- Sélection des produits améliorée -->
        <div class="mb-3">
            <label class="form-label fw-bold">Sélectionnez les produits :</label>
            <div class="mb-2">
                <button type="button" class="btn btn-sm btn-outline-primary" id="selectAllBtn">Tout sélectionner</button>
                <button type="button" class="btn btn-sm btn-outline-secondary" id="deselectAllBtn">Tout désélectionner</button>
            </div>
            <div class="product-checkbox-group row">
                <c:forEach var="p" items="${produits}" varStatus="status">
                    <div class="col-md-4 col-sm-6 product-item">
                        <div class="form-check">
                            <input class="form-check-input product-checkbox" type="checkbox" name="produits" value="${p.id}" id="prod_${p.id}">
                            <label class="form-check-label" for="prod_${p.id}">
                                    ${p.nom} <span class="badge bg-info">${p.prix} DH</span>
                                <br><small class="text-muted">${p.category}</small>
                            </label>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="form-text">Cochez les produits à inclure dans la commande.</div>
        </div>

        <button type="submit" class="btn btn-primary">Créer la commande</button>
        <a href="listerCommandes" class="btn btn-secondary">Annuler</a>
    </form>
</div>

<script>
    // Script pour tout sélectionner / désélectionner
    document.addEventListener('DOMContentLoaded', function() {
        const checkboxes = document.querySelectorAll('.product-checkbox');
        const selectAllBtn = document.getElementById('selectAllBtn');
        const deselectAllBtn = document.getElementById('deselectAllBtn');

        selectAllBtn.addEventListener('click', function() {
            checkboxes.forEach(cb => cb.checked = true);
        });

        deselectAllBtn.addEventListener('click', function() {
            checkboxes.forEach(cb => cb.checked = false);
        });
    });
</script>
</body>
</html>