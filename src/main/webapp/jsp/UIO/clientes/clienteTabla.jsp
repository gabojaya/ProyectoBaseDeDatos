<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modificar Cliente</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/UIO/tabla.css">
</head>
<body>

    <!-- Contenido Principal -->
    <div class="content">
        <div class="welcome-section">
            <h1 class="welcome-section">Modificar Cliente</h1>

            <form action="QuitoViewController?ruta=modificarCliente" method="POST" class="form-container">
                <input type="hidden" name="cedula" value="${clienteQuito.cedula}">
                <input type="hidden" name="idCliente" value="${clienteQuito.idCliente}">

                <div>
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" value="${clienteQuito.nombre}" required>
                </div>

                <div>
                    <label for="telefono">Teléfono:</label>
                    <input type="text" id="telefono" name="telefono" value="${clienteQuito.telefono}" required>
                </div>

                <div >
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" value="${clienteQuito.email}" required>
                </div>

                <div>
                    <button type="submit" class=" buttons-container save-button">Guardar Cambios</button>
                    <a href="${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarClientesQuito" class="buttons-container cancel-button">Cancelar</a>
                </div>
            </form>
        </div>
    </div>

</body>
</html>
