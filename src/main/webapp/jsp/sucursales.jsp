<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sucursales</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/sucursales.css">
</head>
<body>
    <h1>¡Bienvenido de nuevo!</h1>
    <div class="contenedor">
        <div>
            <!-- Redirige a quito.html -->
            <button type="button" onclick="location.href='${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarInicioQuito'">Quito</button>
        </div>
        <div>
            <!-- Redirige a guayaquil.html -->
            <button type="button" onclick="location.href='${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarInicioGuayaquil'">Guayaquil</button>
        </div>
    </div>
</body>
</html>
