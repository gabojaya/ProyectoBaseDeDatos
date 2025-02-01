<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar historial</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/UIO/tabla.css">
</head>
<body>
    <div class="content">
        <h1 class="welcome-section">Historial</h1>
        <table class="services-table" id="main-table">
            <thead>
                <tr>
                    <th>Nro</th>
                    <th>Fecha de la reserva</th>
                    <th>Cliente</th>
                    <th>Mascota</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>25/01/2025</td>
                    <td>Mateo Robles</td>
                    <td>Firulais</td>
                    <td>Finalizado</td>
                    <td><button class="action-btn modify-btn" onclick="openForm(this)">Modificar</button></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>15/01/2025</td>
                    <td>Henry Paz</td>
                    <td>Luzu</td>
                    <td>Finalizado</td>
                    <td><button class="action-btn modify-btn" onclick="openForm(this)">Modificar</button></td>
                </tr>
            </tbody>
        </table>

        <div class="form-container" id="form-container">
            <h2>Modificar Servicios</h2>
            <table class="services-table">
                <thead>
                    <tr>
                        <th>Nro</th>
                        <th>Fecha de la reserva</th>
                        <th>Cliente</th>
                        <th>Mascota</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="number" id="input-nro"></td>
                        <td><input type="text" id="input-fecha"></td>
                        <td><input type="text" id="input-cliente"></td>
                        <td><input type="text" id="input-mascota"></td>
                        <td><input type="text" id="input-estado"></td>
                    </tr>
                </tbody>
            </table>
            <button class="action-btn modify-btn" onclick="saveChanges()">Guardar Cambios</button>
            <button class="action-btn delete-btn" onclick="closeForm()">Cancelar</button>
        </div>
    </div>

    <script>
        let currentRow;

        function openForm(button) {
            const formContainer = document.getElementById("form-container");
            formContainer.style.display = "block";

            currentRow = button.closest("tr");
            const cells = currentRow.querySelectorAll("td");

            document.getElementById("input-nro").value = cells[0].textContent;
            document.getElementById("input-fecha").value = cells[1].textContent;
            document.getElementById("input-cliente").value = cells[2].textContent;
            document.getElementById("input-mascota").value = cells[3].textContent;
            document.getElementById("input-estado").value = cells[4].textContent;
        }

        function saveChanges() {
            if (!currentRow) return;

            const nro = document.getElementById("input-nro").value;
            const fecha = document.getElementById("input-fecha").value;
            const cliente = document.getElementById("input-cliente").value;
            const mascota = document.getElementById("input-mascota").value;
            const estado = document.getElementById("input-estado").value;

            const cells = currentRow.querySelectorAll("td");
            cells[0].textContent = nro;
            cells[1].textContent = fecha;
            cells[2].textContent = cliente;
            cells[3].textContent = mascota;
            cells[4].textContent = estado;

            closeForm();
        }

        function closeForm() {
            const formContainer = document.getElementById("form-container");
            formContainer.style.display = "none";
            currentRow = null;
        }
    </script>
</body>
</html>
