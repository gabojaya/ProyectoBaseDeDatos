<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empleados</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/UIO/tabla.css">
</head>
<body>
    <!-- Encabezado -->
    <header class="header">
        <div class="location-buttons">
            <button type="button" class="location-btn active"
				onclick="location.href='${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarInicioQuito'">
				Quito</button>
            <button type="button" class="location-btn" onclick="location.href='/GYE/inicio.jsp'">Guayaquil</button>
        </div>
    </header>

    <!-- Contenedor Principal -->
    <div class="main-container">
        <!-- Sidebar -->
        <aside class="sidebar">
			<nav>
				<a href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarInicioQuito">Inicio</a> <a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarReservaQuito">Reservas</a> <a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarServiciosQuito">Servicios</a> <a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarClientesQuito">Clientes</a> <a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarHistorialQuito">Historial</a> <a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarEmpleadosQuito" class="active">Empleados</a> <a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarDatosPrivadosQuito">Datos Privados</a>
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
