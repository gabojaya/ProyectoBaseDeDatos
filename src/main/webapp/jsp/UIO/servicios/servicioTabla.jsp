<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modificar Cliente</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jsp/UIO/tabla.css">
</head>
<body>
	<div class="content">
		<h1 class="welcome-section">Modificar Servicio</h1>

		<form action="ServicioQuitoController?ruta=modificarServicio"
			method="POST" class="form-container">
			<input type="hidden" name="idServicio"
				value="${servicioQuito.idServicio}"> <label for="nombre">Nombre:</label>
			<input type="text" id="nombre" name="nombre"
				value="${servicioQuito.nombre}" required> <label
				for="telefono">Teléfono:</label> <input type="text" id="descripcion"
				name="descripcion" value="${servicioQuito.descripcion}" required>
			<label for="salario">Precio:</label> <input type="number"
				id="salario" name="salario" step="0.01" min="10" max="5000"
				value="${servicioQuito.precio}" required>

			<button type="submit" class="action-btn modify-btn">Guardar
				Cambios</button>
			<a
				href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarServiciosQuito"
				class="action-btn delete-btn">Cancelar</a>
		</form>
	</div>
</body>
</html>
