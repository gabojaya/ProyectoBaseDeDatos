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
		<h1 class="welcome-section">Modificar Cliente</h1>

		<form action="GuayaquilViewController?ruta=modificarCliente" method="POST"
			class="form-container">
			<input type="hidden" name="cedula" value="${clienteQuito.cedula}">
			<input type="hidden" name="idCliente"
				value="${clienteQuito.idCliente}"> <label for="nombre">Nombre:</label>
			<input type="text" id="nombre" name="nombre"
				value="${clienteQuito.nombre}" required> <label
				for="telefono">Teléfono:</label> <input type="text" id="telefono"
				name="telefono" value="${clienteQuito.telefono}" required> <label
				for="email">Email:</label> <input type="email" id="email"
				name="email" value="${clienteQuito.email}" required>

			<button type="submit" class="action-btn modify-btn">Guardar
				Cambios</button>
			<a
				href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarClientesGuayaquil"
				class="action-btn delete-btn">Cancelar</a>
		</form>
	</div>
</body>
</html>
