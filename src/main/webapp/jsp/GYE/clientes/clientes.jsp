<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cliente</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jsp/GYE/tabla.css">
</head>
<body>
	<!-- Encabezado -->
	<header class="header">
		<div class="location-buttons">
			<button type="button" class="location-btn "
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
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarInicioGuayaquil">Inicio</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarReservaGuayaquil">Reservas</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarServiciosGuayaquil">Servicios</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarClientesGuayaquil"
					class="active">Clientes</a> <a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarHistorialGuayaquil">Historial</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarEmpleadosGuayaquil">Empleados</a>
			</nav>
		</aside>

		<!-- Contenido Principal -->
		<main class="content">

			<div class="welcome-section">
				<div class="search-container">
					<input type="text" placeholder="Buscar Cliente" class="search-bar">
					<button class="search-btn">O</button>
				</div>
				<div class="search-container">
					<button class="action-btn modify-btn"
						onclick="window.location.href = `GuayaquilViewController?ruta=solicitarAgregarCliente`">Agregar Cliente</button>
				</div>
				<table class="services-table">
					<thead>
						<tr>
							<th>Nro</th>
							<th>Nombre</th>
							<th>Teléfono</th>
							<th>Correo</th>
							<th>Mascotas</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cliente" items="${clientesGuayaquil}"
							varStatus="status">
							<tr>
								<td>${cliente.idCliente}</td>
								<td>${cliente.nombre}</td>
								<td>${cliente.telefono}</td>
								<td>${cliente.email}</td>
								<td>
									<button class="action-btn pet-btn"
										onclick="window.location.href = 'GuayaquilViewController?ruta=verMascotas&idCliente=${cliente.idCliente}'">
										Ver</button>
								</td>
								<td>
									<button class="action-btn modify-btn"
										onclick="window.location.href = `GuayaquilViewController?ruta=solicitarModificarCliente&idCliente=${cliente.idCliente}`">Modificar</button>
									<a
									href="GuayaquilViewController?ruta=eliminarCliente&idCliente=${cliente.idCliente}"
									class="action-btn delete-btn"
									onclick="return confirm('¿Estás seguro de que quieres eliminar este cliente?');">
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