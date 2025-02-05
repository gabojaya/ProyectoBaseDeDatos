<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PÃ¡gina de Inicio</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jsp/GYE/inicio.css">
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
				<h1>Â¡Bienvenido al sistema!</h1>
				<p>Actualmente se encuentra en la Sucursal de Guayaquil</p>
			</div>
		</main>
	</div>
</body>
</html>
