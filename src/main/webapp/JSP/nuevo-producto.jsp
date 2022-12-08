<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Añadir producto</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
                <h2>${cliente.id}</h2>
                <h2>${cliente.nombre}</h2>
                <h2>${cliente.apellido}</h2>
                <div class="card-body"></div>
                <form action="/banco/productos/save" method="POST">
                    <div class="form-group">
                        <label for="">Producto</label>
                        <select name="product_id" id="">
                            <option value="0">seleccione</option>
                            <c:forEach items="${productos}" var="p">
                                <option value="${p.id}" >${p.nombre}</option>
                            </c:forEach>
                        </select>
                        <input type="text" name="client_id" id="" value="${cliente.id}" hidden>
                    </div>
                    <br>
                    <div class="box-footer">
                        <button class="btn btn-success">Save</button>
                    </div>
                    <br>
                </form>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
    crossorigin="anonymous"></script>
    </html>
</body>