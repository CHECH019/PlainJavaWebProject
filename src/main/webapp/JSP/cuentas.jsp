<%@page import="model.CuentaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de cuentas</title>
    <link rel="stylesheet" href="../styles/cuentas.css">
</head>
<body>
    <%
        ArrayList<CuentaDTO> cuentas = (ArrayList<CuentaDTO>) request.getAttribute("cuentas");
    %>
    <h1>Lista de cuentas!</h1>
    <table>
        <tr>
            <td>ID</td>
            <td>CLIENTE ID</td>
            <td>SALDO</td>
            <td>CLAVE</td>
        </tr>
        <%
            for(int i = 0; i < cuentas.size(); i++){
        %>
        <tr>
            <td><%=cuentas.get(i).getId()%></td>
            <td><%=cuentas.get(i).getClienteId()%></td>
            <td><%=cuentas.get(i).getSaldo()%></td>
            <td><%=cuentas.get(i).getClave()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>