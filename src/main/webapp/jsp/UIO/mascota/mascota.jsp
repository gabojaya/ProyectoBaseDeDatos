<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ver mascota</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/UIO/tabla.css">
</head>
<body>
    <div class="content">
        <h1 class="welcome-section">Mascotas</h1>
        <table class="services-table" id="main-table">
            <thead>
                <tr>
                    <th>idMascota</th>
                    <th>Nombre</th>
                    <th>Especie</th>
                    <th>Raza</th>
                    <th>Edad</th>
                    <th>Cliente</th>
                    <th>Sucursal</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Luzu</td>
                    <td>PERRO</td>
                    <td>Blanco</td>
                    <td>15</td>
                    <td>Henry</td>
                    <td>Quito</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Señor gato</td>
                    <td>Gato</td>
                    <td>Naranja</td>
                    <td>5</td>
                    <td>Henry</td>
                    <td>Quito</td>
                </tr>
            </tbody>
        </table>
</body>
</html>
