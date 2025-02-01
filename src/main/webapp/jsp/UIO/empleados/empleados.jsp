<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empleados</title>
    <link rel="stylesheet" href="/GYE/tabla.css">
</head>
<body>
    <!-- Encabezado -->
    <header class="header">
        <div class="location-buttons">
            <button type="button" class="location-btn active" onclick="location.href='/UIO/inicio.html'">Quito</button>
            <button type="button" class="location-btn" onclick="location.href='/GYE/inicio.html'">Guayaquil</button>
        </div>
    </header>

    <!-- Contenedor Principal -->
    <div class="main-container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <nav>
                <a href="/UIO/inicio.html">Inicio</a>
                <a href="/UIO/reservas/reservas.html">Reservas</a>
                <a href="/UIO/Servicios/servicios.html">Servicios</a>
                <a href="/UIO/clientes/clientes.html">Clientes</a>
                <a href="/UIO/historial/historial.html">Historial</a>
                <a href="/UIO/empleados/empleados.html" class="active">Empleados</a>
                <a href="/UIO/privado/privado.html">Datos Privados</a>
            </nav>
        </aside>

        <!-- Contenido Principal -->
        <main class="content">
            <div class="welcome-section">
                <div class="search-container">
                    <input type="text" placeholder="Buscar empleado" class="search-bar">
                    <button class="search-btn">🔍</button>
                </div>
                <table class="services-table">
                    <thead>
                        <tr>
                            <th>Nro</th>
                            <th>Nombre</th>
                            <th>Cédula</th>
                            <th>Teléfono</th>                            </th>
                            <th>Cargo</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>1759874021</td>
                            <td>0998565425</td>
                            <td>Estilista</td>
                            <td>
                                <button class="action-btn modify-btn" onclick="location.href='empleadoTabla.html'"">Modificar</button>
                                <button class="action-btn delete-btn">Eliminar</button>
                            </td>
                        </tr>
                        <tr>
                            <td>---</td>
                            <td>---</td>
                            <td>---</td>
                            <td>---</td>
                            <td>---</td>
                            <td>
                                <button class="action-btn modify-btn" onclick="location.href='empleadoTabla.html'"">Modificar</button>
                                <button class="action-btn delete-btn">Eliminar</button>
                            </td>
                        </tr>
                        <tr>
                            <td>---</td>
                            <td>---</td>
                            <td>---</td>
                            <td>---</td>
                            <td>---</td>
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
