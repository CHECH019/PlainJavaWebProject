<%@page import="model.ClienteDTO"%>
<%@page import="model.ProductoDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" th:href="@{/css/styles.css}" href="../../static/css/styles.css"> -->
    <title>Lista de Productos</title>
</head>
<body>
    <div class="container mt-4">
        <div class="row mt-1">
            <div class="col-lg-2">
                <a href="/banco/clientes" class="btn btn-success btn-sm mb3">Volver al inicio</a>
            </div>
        </div>
        <br><br>
        <h2 >${cliente.id}</h2>
        <h2 class="d-inline">${cliente.nombre}</h2>
        <h2 class="d-inline">${cliente.apellido}</h2>
        <br><br>
        <div class="row mt-1">
            <div class="col-lg-3">
                <a href="/banco/productos/nuevo?id=${cliente.id}" class="btn btn-primary btn-sm mb3">Nuevo Producto</a>
            </div>
        </div>

        
        <table class="table">
            <h1 class="text-center">Productos</h1><br>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Producto</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${productos}" var="p">
                    <tr> 
                        <td>${p.id}</td>
                        <td>${p.nombre}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
    crossorigin="anonymous"></script>
</body>
</html>