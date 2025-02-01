<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cliente</title>
    <link rel="stylesheet" href="/GYE/tabla.css">
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
                <a href="/GYE/inicio.html">Inicio</a>
                <a href="/GYE/reservas/reservas.html">Reservas</a>
                <a href="/GYE/servicios/servicios.html">Servicios</a>
                <a href="/GYE/clientes/clientes.html" class="active">Clientes</a>
                <a href="/GYE/historial/historial.html">Historial</a>
                <a href="/GYE/empleados/empleados.html">Empleados</a>
            </nav>
        </aside>

        <!-- Contenido Principal -->
        <main class="content">
            <div class="welcome-section">
                <div class="search-container">
                    <input type="text" placeholder="Buscar Cliente" class="search-bar">
                    <button class="search-btn">🔍</button>
                </div>
                <table class="services-table">
                    <thead>
                        <tr>
                            <th>Nro</th>
                            <th>Nombre</th>
                            <th>Telefono</th>
                            <th>Correo</th>
                            <th>Mascotas</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Mateo Robles</td>
                            <td>0999875642</td>
                            <td>mat@gmail.com</td>
                            <td>
                                <button class="action-btn view-btn">Ver</button>
                            </td>
                            <td>
                                <button class="action-btn modify-btn" onclick="location.href='clienteTabla.html'"">Modificar</button>
                                <button class="action-btn delete-btn">Eliminar</button>
                            </td>
                        </tr>
                        <tr>
                            <td>---</td>
                            <td>---</td>
                            <td>---</td>
                            <td>---</td>
                            <td>
                                <button class="action-btn view-btn">Ver</button>
                            </td>
                            <td>
                                <button class="action-btn modify-btn">Modificar</button>
                                <button class="action-btn delete-btn">Eliminar</button>
                            </td>
                        </tr>
                        <tr>
                            <td>---</td>
                            <td>---</td>
                            <td>---</td>
                            <td>---</td>
                            <td>
                                <button class="action-btn view-btn">Ver</button>
                            </td>
                            <td>
                                <button class="action-btn modify-btn">Modificar</button>
                                <button class="action-btn delete-btn">Eliminar</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</body>
</html>
