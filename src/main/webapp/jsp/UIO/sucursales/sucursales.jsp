<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sucursales</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jsp/UIO/tabla.css">
</head>
<body>
	<!-- Encabezado -->
	<header class="header">
		<div class="location-buttons">
			<button type="button" class="location-btn active"
				onclick="location.href='${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarInicioQuito'">
				Quito</button>
			<button type="button" class="location-btn "
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
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarInicioQuito">Inicio</a>
				<a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarReservaQuito">Reservas</a>
				<a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarServiciosQuito">Servicios</a> 
				<a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarClientesQuito">Clientes</a>
				<a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarHistorialQuito">Historial</a>
				<a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarEmpleadosQuito">Empleados</a>
				<a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarDatosPrivadosQuito">Datos
					Privados</a>
				<a
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarTablaSucursales" class="active">Sucursales</a>
			</nav>
		</aside>

		<!-- Contenido Principal -->
		<main class="content">
			<div class="welcome-section">
				<h1>Servicios</h1>
				<div class="search-container">
					<input type="text" placeholder="Buscar Servicio" class="search-bar">
					<button class="search-btn">ð</button>
				</div>
				<div class="search-container">
					<button class="action-btn modify-btn"
						onclick="window.location.href = `ServicioQuitoController?ruta=solicitarTablaSucursales`">Agregar Servicios</button>
				</div>
				<table class="services-table">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Descripción</th>
							<th>Precio</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="servicio" items="${serviciosQuito}">
							<tr>
								<td>${servicio.nombre}</td>
								<td>${servicio.descripcion}</td>
								<td>${servicio.precio}</td>
								<td>
									<button class="action-btn modify-btn"
										onclick="window.location.href = `ServicioQuitoController?ruta=solicitarModificarServicio&idServicio=${servicio.idServicio}`">Modificar</button>
									<a
									href="ServicioQuitoController?ruta=eliminarServicio&idServicio=${servicio.idServicio}"
									class="action-btn delete-btn"
									onclick="return confirm('¿Estás seguro de que quieres eliminar este servicio?');">
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
