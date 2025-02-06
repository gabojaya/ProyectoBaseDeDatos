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
	href="${pageContext.request.contextPath}/jsp/UIO/tabla.css">
</head>
<body>
	<!-- Encabezado -->
	<header class="header">
		<div class="location-buttons">
			<button type="button" class="location-btn active"
				onclick="location.href='${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarInicioQuito'">
				Quito</button>
			<button type="button" class="location-btn"
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
					href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarDatosPrivadosQuito"
					class="active">Datos Privados</a>
				
			</nav>
		</aside>

		<!-- Contenido Principal -->
		<main class="content">
			<div class="welcome-section">
				<div class="search-container">
					<input type="text" placeholder="Buscar Cliente" class="search-bar">
					<button class="search-btn">ð</button>
				</div>
				<table class="services-table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Dirección</th>
							<th>Email</th>
							<th>Salario</th>
							<th>Contraseña</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dato" items="${datosPrivados}">
							<tr>
								<td>${dato.idEmpleado}</td>
								<td>${dato.direccion}</td>
								<td>${dato.email}</td>
								<td>${dato.salario}</td>
								<td>${dato.contrasena}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</main>
	</div>
</body>
</html>
