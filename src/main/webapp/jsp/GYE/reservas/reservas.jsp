<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Realizar Reservas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/GYE/reservas/reservas.css">
</head>
<body>
    <!-- Encabezado con botones de ubicaciÃ³n -->
    <header class="header">
        <div class="location-buttons">
            <button type="button" class="location-btn"
				onclick="location.href='${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarInicioQuito'">
				Quito</button>
            <button type="button" class="location-btn active"
				onclick="location.href='${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarInicioGuayaquil'">
				Guayaquil</button>
        </div>
    </header>

    <!-- Contenedor principal -->
    <div class="main-container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <nav>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarInicioGuayaquil"
					class="active">Inicio</a> <a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarReservaGuayaquil">Reservas</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarServiciosGuayaquil">Servicios</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarClientesGuayaquil">Clientes</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarHistorialGuayaquil">Historial</a>
				<a
					href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarEmpleadosGuayaquil">Empleados</a>
			</nav>
        </aside>

        <!-- Contenido principal -->
        <main class="content">
            <section class="reservation-section">
                <h1>Realizar Reservas</h1>
                <form class="reservation-form">
                    <div class="form-group">
                        <label for="client">Cliente</label>
                        <input type="text" id="client" name="client" placeholder="Cliente">
                    </div>

                    <div class="form-group">
                        <label for="pet">Mascota</label>
                        <input type="text" id="client" name="client" placeholder="Mascota">
                    </div>

                    <div class="form-group">
                        <label for="employee">Empleado</label>
                        <select id="employee" name="employee">
                            <option value="">Seleccione un empleado</option>
                            <option value="servicio1">Empleado 1</option>
                            <option value="servicio2">Empleado 2</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="service">Servicio</label>
                        <select id="service" name="service">
                            <option value="">Seleccione un servicio</option>
                            <option value="servicio1">Servicio 1</option>
                            <option value="servicio2">Servicio 2</option>
                        </select>
                    </div>

                    <button type="submit" class="submit-btn">Reservar</button>
                </form>
            </section>
        </main>
    </div>
</body>
</html>
