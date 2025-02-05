<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Empleado</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/GYE/tabla.css">
</head>
<body>
    <div class="content">
        <h1 class="welcome-section">Agregar Empleado</h1>

        <form action="ServicioGuayaquilController?ruta=agregarServicio" method="POST" class="form-container">

            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="${clienteGuayaquil.nombre}" required>

            <label for="telefono">Descripción:</label>
            <input type="text" id="Descripcion" name="Descripcion" value="${clienteGuayaquil.telefono}" required>

            <label for="salario">Precio:</label>
            <input type="number" id="salario" name="salario" step="0.01" min="10" max="5000"
                   value="${clienteGuayaquil.salario}" required>

            <label for="sucursal">Sucursal:</label>
            <select id="sucursal" name="sucursal" required>
                <option value="Quito" ${clienteQuito.sucursal == 'Quito' ? 'selected' : ''}>Quito</option>
                <option value="Guayaquil" ${clienteGuayaquil.sucursal == 'Guayaquil' ? 'selected' : ''}>Guayaquil</option>
            </select>

            <button type="submit" class="action-btn modify-btn">Guardar Cambios</button>
            <a href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarServiciosGuayaquil"
               class="action-btn delete-btn">Cancelar</a>
        </form>
    </div>
</body>
</html>
