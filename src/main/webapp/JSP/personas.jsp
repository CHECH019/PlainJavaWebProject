<%@page import="model.PersonaDTO"%>
<%@page import="Iterator.Iterator"%>
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
        Iterator<PersonaDTO> personas = (Iterator<PersonaDTO>) request.getAttribute("personas");
        PersonaDTO p;
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
            while(personas.hasNext()){
                p = personas.next();
        %>
        <tr>
            <td><%=p.getId()%></td>
            <td><%=p.getNombre()%></td>
            <td><%=p.getDni()%></td>
            <td><%=p.getCorreo()%></td>
            <td><%=p.getCel()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>