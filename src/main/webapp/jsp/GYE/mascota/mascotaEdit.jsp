<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Agregar Mascota</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jsp/GYE/tabla.css">
</head>
<body>
	<div class="content">
		<h1 class="welcome-section">Agregar Mascota</h1>

		<form action="MascotaGuayaquilController?ruta=modificarMascota" method="POST"
			class="form-container">
			<!-- Campo ID de la Mascota (si es necesario) -->
			<input type="hidden" name="idMascota" value="${mascota.idMascota}">
			<input type="hidden" name="idCliente" value="${mascota.idCliente}"> <label
				for="nombre">Nombre:</label> <input type="text" id="nombre"
				name="nombre" value="${mascota.nombre}" required> <label
				for="especie">Especie:</label> <input type="text" id="especie"
				name="especie" value="${mascota.especie}" required> <label
				for="raza">Raza:</label> <input type="text" id="raza" name="raza"
				value="${mascota.raza}" required> <label for="edad">Edad:</label>
			<input type="number" id="edad" name="edad" value="${mascota.edad}"
				required> 
				<input type="hidden" name="idSucursal"
				value="${mascota.idSucursal}">

			<button type="submit" class="action-btn modify-btn">Guardar
				Mascota</button>
			<a
				href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=verMascotas&idCliente=${mascota.idCliente}"
				class="action-btn delete-btn">Cancelar</a>
		</form>
	</div>
</body>
</html>
