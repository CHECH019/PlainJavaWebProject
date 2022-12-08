<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Cliente</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
                <h1 class="text-center">Crear Cliente</h1>
                <div class="card-body"></div>
                <form action="clientes" method="POST">
                    <div class="form-group">
                        <label for="">Nombre</label>
                        <input type="text" name="nombre" class="form-control">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="">Apellido</label>
                        <input type="text" name="apellido" class="form-control">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="">Correo</label>
                        <input type="text" name="correo" class="form-control">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="">Genero</label>
                        <input type="text" name="genero" class="form-control">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="">Dirección</label>
                        <input type="text" name="direccion" class="form-control">
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