<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Servicios</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jsp/GYE/tabla.css">
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
				<h1>Servicios</h1>
				<div class="search-container">
					<input type="text" placeholder="Buscar Servicio" class="search-bar">
					<button class="search-btn">ð</button>
				</div>
				<table class="services-table">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Descripcion</th>
							<th>Precio</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>EstÃ©tica</td>
							<td>Corte de cabello + baÃ±o</td>
							<td>$20</td>
							<td>
								<button class="action-btn modify-btn"
									onclick="location.href='servicioTabla.html'"">Modificar</button>
								<button class="action-btn delete-btn">Eliminar</button>
							</td>
						</tr>
						<tr>
							<td>---</td>
							<td>---</td>
							<td>---</td>
							<td>
								<button class="action-btn modify-btn">Modificar</button>
								<button class="action-btn delete-btn">Eliminar</button>
							</td>
						</tr>
						<tr>
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
