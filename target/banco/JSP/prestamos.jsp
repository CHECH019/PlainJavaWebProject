<%@page import="dto.PrestamoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de prestamos</title>
    <link rel="stylesheet" href="../styles/prestamos.css">
</head>
<body>
    <%
        ArrayList<PrestamoDTO> prestamos = (ArrayList<PrestamoDTO>) request.getAttribute("prestamos");
    %>
    <h1>Lista de prestamos!</h1>
    <table>
        <tr>
            <td>ID</td>
            <td>CLIENTE ID</td>
            <td>VALOR</td>
            <td>CUOTAS</td>
            <td>INTERESES</td>
            <td>DESCRIPCIÓN</td>
        </tr>
        <%
            for(int i = 0; i < prestamos.size(); i++){
        %>
        <tr>
            <td><%=prestamos.get(i).getId()%></td>
            <td><%=prestamos.get(i).getClienteId()%></td>
            <td><%=prestamos.get(i).getValor()%></td>
            <td><%=prestamos.get(i).getCuotas()%></td>
            <td><%=prestamos.get(i).getIntereses()%></td>
            <td><%=prestamos.get(i).getDescripcion()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>