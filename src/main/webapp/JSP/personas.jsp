<%@page import="model.PersonaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de personas</title>
    <link rel="stylesheet" href="../styles/personas.css">
</head>
<body>
    <%
        ArrayList<PersonaDTO> personas = (ArrayList<PersonaDTO>) request.getAttribute("personas");
    %>
    <h1>Lista de personas!</h1>
    <table>
        <tr>
            <td>ID</td>
            <td>NOMBRE</td>
            <td>DNI</td>
            <td>CORREO</td>
            <td>CEL</td>
        </tr>
        <%
            for(int i = 0; i < personas.size(); i++){
        %>
        <tr>
            <td><%=personas.get(i).getId()%></td>
            <td><%=personas.get(i).getNombre()%></td>
            <td><%=personas.get(i).getDni()%></td>
            <td><%=personas.get(i).getCorreo()%></td>
            <td><%=personas.get(i).getCel()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>