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
				onclick="location.href='/UIO/inicio.html'">Quito</button>
			<button type="button" class="location-btn"
				onclick="location.href='/GYE/inicio.html'">Guayaquil</button>
			>
		</div>
	</header>

	<!-- Contenedor Principal -->
	<div class="main-container">
		<!-- Sidebar -->
		<aside class="sidebar">
			<nav>
				<a href="/UIO/inicio.html">Inicio</a> <a
					href="/UIO/reservas/reservas.html">Reservas</a> <a
					href="/UIO/servicios/servicios.html">Servicios</a> <a
					href="/UIO/clientes/clientes.html" class="active">Clientes</a> <a
					href="/UIO/historial/historial.html">Historial</a> <a
					href="/UIO/empleados/empleados.html">Empleados</a> <a
					href="/UIO/privado/privado.html">Datos Privados</a>
			</nav>
		</aside>

		<!-- Contenido Principal -->
		<main class="content">


			<div class="welcome-section">
				<div class="search-container">
					<input type="text" placeholder="Buscar Cliente" class="search-bar">
					<button class="search-btn">O</button>
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
						<c:forEach var="cliente" items="${clientesQuito}"
							varStatus="status">
							<tr>
								<td>${cliente.idCliente}</td>
								<td>${cliente.nombre}</td>		
								<td>${cliente.telefono}</td>
								<td>${cliente.email}</td>
								<td>
									<button class="action-btn view-btn">Ver</button>
								</td>
								<td>
									<button class="action-btn modify-btn"
										onclick="location.href='clienteTabla.html'">Modificar</button>
									<button class="action-btn delete-btn">Eliminar</button>
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
