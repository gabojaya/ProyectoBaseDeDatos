<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Tabla</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/UIO/tabla.css">
</head>
<body>
    <div class="content">
        <h1 class="welcome-section">Clientes
            
        </h1>
        <table class="services-table" id="main-table">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Ciudad</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Juan</td>
                    <td>25</td>
                    <td>Quito</td>
                    <td><button class="action-btn modify-btn" onclick="openForm(this)">Modificar</button></td>
                </tr>
                <tr>
                    <td>María</td>
                    <td>30</td>
                    <td>Guayaquil</td>
                    <td><button class="action-btn modify-btn" onclick="openForm(this)">Modificar</button></td>
                </tr>
            </tbody>
        </table>

        <div class="form-container" id="form-container">
            <h2>Modificar Registro</h2>
            <table class="services-table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Edad</th>
                        <th>Ciudad</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" id="input-nombre"></td>
                        <td><input type="number" id="input-edad"></td>
                        <td><input type="text" id="input-ciudad"></td>
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

            document.getElementById("input-nombre").value = cells[0].textContent;
            document.getElementById("input-edad").value = cells[1].textContent;
            document.getElementById("input-ciudad").value = cells[2].textContent;
        }

        function saveChanges() {
            if (!currentRow) return;

            const nombre = document.getElementById("input-nombre").value;
            const edad = document.getElementById("input-edad").value;
            const ciudad = document.getElementById("input-ciudad").value;

            const cells = currentRow.querySelectorAll("td");
            cells[0].textContent = nombre;
            cells[1].textContent = edad;
            cells[2].textContent = ciudad;

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
