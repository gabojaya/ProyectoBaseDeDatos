<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empleados</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/GYE/tabla.css">
</head>
<body>
    <!-- Encabezado -->
    <header class="header">
        <div class="location-buttons">
            <button type="button" class="location-btn"
				onclick="location.href='${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarInicioQuito'">
				Quito</button>
            <button type="button" class="location-btn active"
				onclick="location.href='${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarInicioGuayaquil'">
				Guayaquil</button>
        </div>
    </header>

    <!-- Contenedor Principal -->
    <div class="main-container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <nav>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarInicioGuayaquil"
					class="active">Inicio</a> <a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarReservaGuayaquil">Reservas</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarServiciosGuayaquil">Servicios</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarClientesGuayaquil">Clientes</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarHistorialGuayaquil">Historial</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarEmpleadosGuayaquil">Empleados</a>
			</nav>
        </aside>

		<!-- Contenido Principal -->
		<main class="content">

			<div class="welcome-section">
				<div class="search-container">
					<input type="text" placeholder="Buscar empleado" class="search-bar">
					<button class="search-btn">🔍</button>
				</div>
				<div class="search-container">
					<button class="action-btn modify-btn"
						onclick="window.location.href = `EmpleadoGuayaquilController?ruta=solicitarAgregarEmpleado`">Agregar Empleado</button>
				</div>
				<table class="services-table">
					<thead>
						<tr>
							<th>Nro</th>
							<th>Nombre</th>
							<th>Cédula</th>
							<th>Teléfono</th>
							<th>Cargo</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="empleado" items="${empleadoGuayaquil}"
							varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${empleado.nombre}</td>
								<td>${empleado.cedula}</td>
								<td>${empleado.telefono}</td>
								<td>${empleado.cargo}</td>
								<td>
									<button class="action-btn modify-btn"
										onclick="window.location.href = `EmpleadoGuayaquilController?ruta=solicitarModificarEmpleado&idEmpleado=${empleado.idEmpleado}`">Modificar</button>
									<a
									href="EmpleadoGuayaquilController?ruta=eliminarEmpleado&idEmpleado=${empleado.idEmpleado}"
									class="action-btn delete-btn"
									onclick="return confirm('¿Estás seguro de que quieres eliminar este empleado?');">
										Eliminar </a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</main>
	</div>
</body>
</html>
