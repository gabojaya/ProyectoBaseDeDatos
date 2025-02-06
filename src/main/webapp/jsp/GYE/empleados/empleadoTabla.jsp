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
	href="${pageContext.request.contextPath}/jsp/GYE/tabla.css">
</head>
<body>
	<div class="content">
		<h1 class="welcome-section">Modificar Empleado</h1>

		<form action="EmpleadoGuayaquilController?ruta=modificarEmpleado" method="POST"
			class="form-container">
			<input type="hidden" name="cedula" value="${empleadoGuayaquil.cedula}">
			<input type="hidden" name="idEmpleado"
				value="${empleadoGuayaquil.idEmpleado}"> 
			
			<label for="nombre">Nombre:</label>
			<input type="text" id="nombre" name="nombre"
				value="${empleadoGuayaquil.nombre}" required> 
			
			<label for="telefono">Teléfono:</label> 
			<input type="text" id="telefono" name="telefono"
				value="${empleadoGuayaquil.telefono}" required> 
			
			<label for="email">Email:</label> 
			<input type="email" id="email" name="email" 
				value="${empleadoPrivadoGuayaquil.email}" required> 
			
			<label for="direccion">Dirección:</label> 
			<input type="text" id="direccion" name="direccion"
				value="${empleadoPrivadoGuayaquil.direccion}" required> 
			
			<label for="cargo">Cargo:</label> 
			<input type="text" id="cargo" name="cargo"
				value="${empleadoGuayaquil.cargo}" required>
			
			<label for="salario">Salario:</label> 
			<input type="number" id="salario" name="salario"
				value="${empleadoPrivadoGuayaquil.salario}" required> 
			
			<label for="contrasena">Contraseña:</label> 
			<input type="password" id="contrasena" name="contrasena"
				value="${empleadoPrivadoGuayaquil.contrasena}" required> 

			<button type="submit" class="action-btn modify-btn">Guardar
				Cambios</button>
			<a
				href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarEmpleadosGuayaquil"
				class="action-btn delete-btn">Cancelar</a>
		</form>
	</div>
</body>
</html>
