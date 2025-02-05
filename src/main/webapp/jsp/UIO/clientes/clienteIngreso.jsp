<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Agregar Cliente</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jsp/UIO/tabla.css">
</head>
<body>
	<div class="content">
		<h1 class="welcome-section">Agregar Cliente</h1>

		<form action="QuitoViewController?ruta=agregarCliente" method="POST"
			class="form-container">
			<!-- Campo Cedula editable -->
			<label for="cedula">Cédula:</label> <input type="text" id="cedula"
				name="cedula" value="${clienteQuito.cedula}" required> <input
				type="hidden" name="idCliente" value="${clienteQuito.idCliente}">

			<label for="nombre">Nombre:</label> <input type="text" id="nombre"
				name="nombre" value="${clienteQuito.nombre}" required> <label
				for="telefono">Teléfono:</label> <input type="text" id="telefono"
				name="telefono" value="${clienteQuito.telefono}" required> <label
				for="email">Email:</label> <input type="email" id="email"
				name="email" value="${clienteQuito.email}" required> <label
				for="sucursal">Sucursal:</label> <select id="sucursal"
				name="sucursal" required>
				<option value="Quito"
					>Quito</option>
				<option value="Guayaquil"
					>Guayaquil</option>
			</select>

			<button type="submit" class="action-btn modify-btn">Guardar
				Cambios</button>
			<a
				href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarClientesQuito"
				class="action-btn delete-btn">Cancelar</a>
		</form>
	</div>
</body>
</html>
