<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ver mascota</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jsp/UIO/tabla.css">
</head>
<body>
	<div class="content">
		<h1 class="welcome-section">Mascotas</h1>
		<div class="search-container">
			<button class="action-btn modify-btn"
				onclick="window.location.href = `QuitoViewController?ruta=solicitarClientesQuito`">Volver
				a Clientes</button>
		</div>
		<div class="search-container">
			<button class="action-btn modify-btn"
				onclick="window.location.href = `MascotaController?ruta=solicitarAgregarMascota&idCliente=${idCliente}`">Agregar
				Mascota</button>
		</div>
		<table class="services-table" id="main-table">
			<input type="hidden" name="idCliente" value="${idCliente}">
			<thead>
				<tr>
					<th>idMascota</th>
					<th>Nombre</th>
					<th>Especie</th>
					<th>Raza</th>
					<th>Edad</th>
					<th>Cliente</th>
					<th>Sucursal</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="mascota" items="${mascotasQuito}">
					<tr>
						<td>${mascota.idMascota}</td>
						<td>${mascota.nombre}</td>
						<td>${mascota.especie}</td>
						<td>${mascota.raza}</td>
						<td>${mascota.edad}</td>
						<td>${mascota.idCliente}</td>
						<td>${mascota.idSucursal}</td>
						<td>
							<button class="action-btn modify-btn"
								onclick="window.location.href = `MascotaController?ruta=solicitarModificarMascota&idMascota=${mascota.idMascota}`">Modificar</button>
							<a
							href="MascotaController?ruta=eliminarMascota&idMascota=${mascota.idMascota}&idCliente=${mascota.idCliente}"
							class="action-btn delete-btn"
							onclick="return confirm('¿Estás seguro de que quieres eliminar esta mascota?');">
								Eliminar </a>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>
