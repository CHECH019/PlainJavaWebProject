<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de clientes</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./styles/clientes.css">
</head>
<body>
    
    <div class="container mt-4">
        <br>
        <form action="/banco/clientes/buscar">
            <label for="">Buscar por id</label><br>
            <input type="text" name="id" id="" placeholder="id" required>
            <input type="submit" value="Buscar Cliente">
            <input type="submit" value="Ver productos del Cliente" formaction="/banco/productos/buscar">
        </form>
        <br>    
        <form action="/banco/clientes/buscar">
            <label for="">Buscar por nombre y apellido</label><br>
            <input type="text" name="name" id="" placeholder="nombre" required>
            <input type="text" name="lastName" id="" placeholder="apellido" required>
            <input type="submit" value="Buscar Cliente">
            <input type="submit" value="Ver productos del Cliente" formaction="/banco/productos/buscar">
        </form>
        <br>
        <div class="row">
            <div class="col-lg-3">
                <a href="/banco/clientes/nuevo" class="btn btn-primary btn-sm mb3">Nuevo cliente</a>
            </div>
        </div>
        <table class="table">
            <h1 class="text-center">Lista de clientes!</h1>
            <tr>
                <td>ID</td>
                <td>NOMBRE</td>
                <td>APELLIDO</td>
                <td>CORREO</td>
                <td>DIRECCION</td>
                <td>GENERO</td>
            </tr>
            
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td>${cliente.id}</td>
                    <td>${cliente.nombre}</td>
                    <td>${cliente.apellido}</td>
                    <td>${cliente.correo}</td>
                    <td>${cliente.direccion}</td>
                    <td>${cliente.genero}</td>
                    <td>
                        <a href="/banco/productos/buscar?id=${cliente.id}" class="btn btn-success">Ver Productos</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
    crossorigin="anonymous"></script>
</body>
</html>