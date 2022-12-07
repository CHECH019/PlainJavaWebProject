<%@page import="model.ClienteDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <%
        List<ClienteDTO> clientes = (List<ClienteDTO>) request.getAttribute("clientes");
    %>
    <div class="container mt-4">

        <div class="row">
            <div class="col-lg-3">
                <a href="#" class="btn btn-primary btn-sm mb3">Nuevo cliente</a>
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
            <%
            for(ClienteDTO c: clientes){
            %>
            <tr>
                <td><%=c.getId()%></td>
                <td><%=c.getNombre()%></td>
                <td><%=c.getApellido()%></td>
                <td><%=c.getCorreo()%></td>
                <td><%=c.getDireccion()%></td>
                <td><%=c.getGenero()%></td>
            </tr>
            <%
            }
            %>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
    crossorigin="anonymous"></script>
</body>
</html>