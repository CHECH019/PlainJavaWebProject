<%@page import="dto.TarjetaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de tarjetas</title>
    <link rel="stylesheet" href="../styles/tarjetas.css">
</head>
<body>
    <%
        ArrayList<TarjetaDTO> tarjetas = (ArrayList<TarjetaDTO>) request.getAttribute("tarjetas");
    %>
    <h1>Lista de tarjetas!</h1>
    <table>
        <tr>
            <td>ID</td>
            <td>CLIENTE ID</td>
            <td>NÚMERO DE TARJETA</td>
            <td>VENCIMIENTO</td>
            <td>CVV</td>
        </tr>
        <%
            for(int i = 0; i < tarjetas.size(); i++){
        %>
        <tr>
            <td><%=tarjetas.get(i).getId()%></td>
            <td><%=tarjetas.get(i).getClienteId()%></td>
            <td><%=tarjetas.get(i).getNumeroTarjeta()%></td>
            <td><%=tarjetas.get(i).getVencimiento()%></td>
            <td><%=tarjetas.get(i).getCvv()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>