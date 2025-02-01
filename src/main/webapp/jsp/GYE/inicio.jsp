<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de Inicio</title>
    <link rel="stylesheet" href="inicio.css">
</head>
<body>
    <!-- Encabezado -->
    <header class="header">
        <div class="location-buttons">
            <button type="button" class="location-btn" onclick="location.href='/UIO/inicio.jsp'">Quito</button>
            <button type="button" class="location-btn active" onclick="location.href='/GYE/inicio.jsp'">Guayaquil</button>
        </div>
    </header>

    <!-- Contenedor Principal -->
    <div class="main-container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <nav>
                <a href="/GYE/inicio.jsp" class="active">Inicio</a>
                <a href="/GYE/reservas/reservas.jsp">Reservas</a>
                <a href="/GYE/servicios/servicios.jsp">Servicios</a>
                <a href="/GYE/clientes/clientes.jsp">Clientes</a>
                <a href="/GYE/historial/historial.jsp">Historial</a>
                <a href="/GYE/empleados/empleados.jsp">Empleados</a>
            </nav>
        </aside>

        <!-- Contenido Principal -->
        <main class="content">
            <div class="welcome-section">
                <h1>¡Bienvenido al sistema!</h1>
                <p>Actualmente se encuentra en la Sucursal de Guayaquil</p>
            </div>
        </main>
    </div>
</body>
</html>
