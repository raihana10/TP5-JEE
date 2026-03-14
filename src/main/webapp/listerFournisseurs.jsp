<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Liste des fournisseurs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function confirmDelete(form) {
            if (confirm("Voulez-vous vraiment supprimer ce fournisseur ?")) {
                form.submit();
            }
        }
    </script>
</head>
<body>
<div class="container mt-4">
    <h1>Liste des fournisseurs</h1>
    <a href="ajouterFournisseur" class="btn btn-success mb-3">Ajouter un fournisseur</a>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Email</th>
            <th>Téléphone</th>
            <th>Produit associé</th>
            <th>Supprimer</th>
            <th>Modifier</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="f" items="${fournisseurs}">
            <tr>
                <td>${f.id}</td>
                <td>${f.nom}</td>
                <td>${f.email}</td>
                <td>${f.telephone}</td>
                <td>${f.produit.nom}</td>
                <td>
                    <form action="supprimerFournisseur" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${f.id}">
                        <button type="button" class="btn btn-danger btn-sm" onclick="confirmDelete(this.form)">Supprimer</button>
                    </form>
                </td>
                <td>
                    <a href="modifierFournisseur?id=${f.id}" class="btn btn-warning btn-sm">Modifier</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp" class="btn btn-primary">Accueil</a>
</div>
</body>
</html>