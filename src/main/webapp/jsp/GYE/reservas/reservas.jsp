<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Realizar Reservas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/GYE/reservas/reservas.css">
</head>
<body>
    <!-- Encabezado con botones de ubicación -->
    <header class="header">
        <div class="location-buttons">
            <button type="button" class="location-btn" onclick="location.href='/UIO/inicio.html'">Quito</button>
            <button type="button" class="location-btn active" onclick="location.href='/GYE/inicio.html'">Guayaquil</button>
        </div>
    </header>

    <!-- Contenedor principal -->
    <div class="main-container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <nav>
                <a href="${pageContext.request.contextPath}/jsp/GYE/inicio.html">Inicio</a>
                <a href="${pageContext.request.contextPath}/jsp/GYE/reservas/reservas.html" class="active">Reservas</a>
                <a href="${pageContext.request.contextPath}/jsp/GYE/Servicios/servicios.html">Servicios</a>
                <a href="${pageContext.request.contextPath}/jsp/GYE/clientes/clientes.html">Clientes</a>
                <a href="${pageContext.request.contextPath}/jsp/GYE/historial/historial.html">Historial</a>
                <a href="${pageContext.request.contextPath}/jsp/GYE/empleados/empleados.html">Empleados</a>
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
