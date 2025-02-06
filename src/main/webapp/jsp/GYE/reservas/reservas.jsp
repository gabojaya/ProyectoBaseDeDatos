<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Realizar Reservas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/GYE/reservas/reservas.css">
    <script>
        // Función para cargar las mascotas según el cliente seleccionado
        function cargarMascotas(clienteId) {
            const xhr = new XMLHttpRequest();
            xhr.open("GET", "MascotaGuayaquilController?ruta=getMascotasPorCliente&idCliente=" + clienteId, true);
            xhr.onload = function() {
                if (xhr.status === 200) {
                    const mascotas = JSON.parse(xhr.responseText);
                    const mascotaSelect = document.getElementById("mascota");
                    mascotaSelect.innerHTML = "<option value=''>Seleccione una mascota</option>";
                    mascotas.forEach(function(mascota) {
                        const option = document.createElement("option");
                        option.value = mascota.idMascota;
                        option.textContent = mascota.nombre;
                        mascotaSelect.appendChild(option);
                    });
                }
            };
            xhr.send();
        }
    </script>
</head>
<body>
    <header class="header">
        <div class="location-buttons">
            <button type="button" class="location-btn active" onclick="location.href='${pageContext.request.contextPath}/QuitoViewController?ruta=solicitarInicioQuito'">Quito</button>
            <button type="button" class="location-btn" onclick="location.href='${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarInicioGuayaquil'">Guayaquil</button>
        </div>
    </header>

    <div class="main-container">
        <aside class="sidebar">
            <nav>
                <a href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarInicioGuayaquil">Inicio</a>
                <a href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarReservaGuayaquil" class="active">Reservas</a>
                <a href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarServiciosGuayaquil">Servicios</a>
                <a href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarClientesGuayaquil">Clientes</a>
                <a href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarHistorialGuayaquil">Historial</a>
                <a href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarEmpleadosGuayaquil">Empleados</a>
                <a href="${pageContext.request.contextPath}/GuayaquilViewController?ruta=solicitarDatosPrivadosGuayaquil">Datos Privados</a>
            </nav>
        </aside>

        <main class="content">
            <section class="reservation-section">
                <h1>Realizar Reservas</h1>
                <form class="reservation-form" action="ReservaGuayaquilController?ruta=guardarReserva" method="POST">
                    <div class="form-group">
                        <label for="client">Cliente</label>
                        <select id="client" name="client" onchange="cargarMascotas(this.value)">
                            <option value="">Seleccione un cliente</option>
                            <c:forEach var="cliente" items="${clientesGuayaquil}">
                                <option value="${cliente.idCliente}">${cliente.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="mascota">Mascota</label>
                        <select id="mascota" name="mascota">
                            <option value="">Seleccione una mascota</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="employee">Empleado</label>
                        <select id="employee" name="employee">
                            <option value="">Seleccione un empleado</option>
                            <c:forEach var="empleado" items="${empleadosGuayaquil}">
                                <option value="${empleado.idEmpleado}">${empleado.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="service">Servicio</label>
                        <select id="service" name="service">
                            <option value="">Seleccione un servicio</option>
                            <c:forEach var="servicio" items="${serviciosGuayaquil}">
                                <option value="${servicio.idServicio}">${servicio.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <button type="submit" class="submit-btn">Reservar</button>
                </form>
            </section>
        </main>
    </div>
</body>
</html>
