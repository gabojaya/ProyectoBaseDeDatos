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
            <button type="button" class="location-btn" onclick="location.href='/UIO/inicio.html'">Quito</button>
            <button type="button" class="location-btn active" onclick="location.href='/GYE/inicio.html'">Guayaquil</button>
        </div>
    </header>

    <!-- Contenedor Principal -->
    <div class="main-container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <nav>
                <a href="/GYE/inicio.html" class="active">Inicio</a>
                <a href="/GYE/reservas/reservas.html">Reservas</a>
                <a href="/GYE/servicios/servicios.html">Servicios</a>
                <a href="/GYE/clientes/clientes.html">Clientes</a>
                <a href="/GYE/historial/historial.html">Historial</a>
                <a href="/GYE/empleados/empleados.html">Empleados</a>
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
