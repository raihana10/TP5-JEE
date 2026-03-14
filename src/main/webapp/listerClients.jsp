<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Liste des clients</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Liste des clients</h1>
    <a href="ajouterClient" class="btn btn-success mb-3">Ajouter un client</a>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Email</th>
            <th>Supprimer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${clients}">
            <tr>
                <td>${c.id}</td>
                <td>${c.nom}</td>
                <td>${c.email}</td>
                <td>
                    <form action="supprimerClient" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${c.id}">
                        <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Supprimer ce client ?')">Supprimer</button>
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