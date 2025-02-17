<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Empleado</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/UIO/tabla.css">
</head>
<body>
    <div class="content">
        <h1 class="welcome-section">Agregar Empleado</h1>

        <form action="EmpleadoQuitoController?ruta=agregarEmpleado" method="POST" class="form-container">
            <label for="cedula">Cédula:</label>
            <input type="text" id="cedula" name="cedula" value="${clienteQuito.cedula}" required>

            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="${clienteQuito.nombre}" required>

            <label for="telefono">Teléfono:</label>
            <input type="text" id="telefono" name="telefono" value="${clienteQuito.telefono}" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${clienteQuito.email}" required>

            <label for="direccion">Dirección:</label>
            <input type="text" id="direccion" name="direccion" value="${clienteQuito.direccion}" required>

            <label for="cargo">Cargo:</label>
            <input type="text" id="cargo" name="cargo" value="${clienteQuito.cargo}" required>

            <label for="salario">Salario:</label>
            <input type="number" id="salario" name="salario" step="0.01" min="10" max="5000"
                   value="${clienteQuito.salario}" required>

            <label for="contrasena">Contraseña:</label>
            <input type="password" id="contrasena" name="contrasena" required>

            <label for="sucursal">Sucursal:</label>
            <select id="sucursal" name="sucursal" required>
                <option value="Quito" ${clienteQuito.sucursal == 'Quito' ? 'selected' : ''}>Quito</option>
                <option value="Guayaquil" ${clienteQuito.sucursal == 'Guayaquil' ? 'selected' : ''}>Guayaquil</option>
            </select>

            <button type="submit" class="action-btn modify-btn">Guardar Cambios</button>
            <a href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarEmpleadosQuito"
               class="action-btn delete-btn">Cancelar</a>
        </form>
    </div>
</body>
</html>
