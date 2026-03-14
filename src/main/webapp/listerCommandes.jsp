<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Liste des commandes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function confirmDelete(form) {
            if (confirm("Voulez-vous vraiment supprimer cette commande ?")) {
                form.submit();
            }
        }
    </script>
</head>
<body>
<div class="container mt-4">
    <h1>Liste des commandes</h1>
    <a href="ajouterCommande" class="btn btn-success mb-3">Nouvelle commande</a>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Client</th>
            <th>Produits</th>
            <th>Supprimer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cmd" items="${commandes}">
            <tr>
                <td>${cmd.id}</td>
                <td><fmt:formatDate value="${cmd.date}" pattern="dd/MM/yyyy HH:mm"/></td>
                <td>${cmd.client.nom}</td>
                <td>
                    <ul>
                        <c:forEach var="p" items="${cmd.produits}">
                            <li>${p.nom} (${p.prix} DH)</li>
                        </c:forEach>
                    </ul>
                </td>
                <td>
                    <form action="supprimerCommande" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${cmd.id}">
                        <button type="button" class="btn btn-danger btn-sm" onclick="confirmDelete(this.form)">Supprimer</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary">Accueil</a>
</div>
</body>
</html>