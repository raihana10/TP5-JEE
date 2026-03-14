<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Ajouter un fournisseur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function validateForm() {
            let nom = document.forms["fournisseurForm"]["nom"].value.trim();
            let email = document.forms["fournisseurForm"]["email"].value.trim();
            let telephone = document.forms["fournisseurForm"]["telephone"].value.trim();

            if (nom === "" || email === "" || telephone === "") {
                alert("Tous les champs doivent être remplis !");
                return false;
            }

            // Validation simple de l'email
            let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(email)) {
                alert("Veuillez entrer un email valide !");
                return false;
            }

            // Validation du téléphone (chiffres uniquement, 10 chiffres)
            let phonePattern = /^\d{10}$/;
            if (!phonePattern.test(telephone)) {
                alert("Le téléphone doit contenir exactement 10 chiffres.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<div class="container mt-4">
    <h1>Ajouter un Fournisseur</h1>
    <form name="fournisseurForm" method="post" action="ajouterFournisseur" onsubmit="return validateForm()">
        <div class="mb-3">
            <label for="nom" class="form-label">Nom :</label>
            <input type="text" id="nom" name="nom" class="form-control" required />
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email :</label>
            <input type="email" id="email" name="email" class="form-control" required />
        </div>
        <div class="mb-3">
            <label for="telephone" class="form-label">Téléphone :</label>
            <input type="text" id="telephone" name="telephone" class="form-control" required />
        </div>
        <div class="mb-3">
            <label for="produitId" class="form-label">Produit associé :</label>
            <select id="produitId" name="produitId" class="form-select" required>
                <option value="">-- Choisir un produit --</option>
                <c:forEach var="p" items="${produits}">
                    <option value="${p.id}">${p.nom} (${p.prix} €)</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
        <a href="listerFournisseurs" class="btn btn-secondary">Annuler</a>
    </form>
</div>
</body>
</html>