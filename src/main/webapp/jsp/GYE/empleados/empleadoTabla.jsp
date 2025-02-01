<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar empleado</title>
    <link rel="stylesheet" href="/GYE/tabla.css">
</head>
<body>
    <div class="content">
        <h1 class="welcome-section">Empleados</h1>
        <table class="services-table" id="main-table">
            <thead>
                <tr>
                    <th>Nro</th>
                    <th>Nombre</th>
                    <th>Cédula</th>
                    <th>Teléfono</th>
                    <th>Cargo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Juan Perez</td>
                    <td>1759874021</td>
                    <td>0998565425</td>
                    <td>Estilista</td>
                    <td><button class="action-btn modify-btn" onclick="openForm(this)">Modificar</button></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Mas Capito</td>
                    <td>1359874021</td>
                    <td>0978215425</td>
                    <td>Barbero</td>
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
                        <th>Nombre</th>
                        <th>Cédula</th>
                        <th>Teléfono</th>
                        <th>Cargo</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="number" id="input-nro"></td>
                        <td><input type="text" id="input-nombre"></td>
                        <td><input type="text" id="input-cedula"></td>
                        <td><input type="text" id="input-telefono"></td>
                        <td><input type="text" id="input-cargo"></td>
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
            document.getElementById("input-nombre").value = cells[1].textContent;
            document.getElementById("input-cedula").value = cells[2].textContent;
            document.getElementById("input-telefono").value = cells[3].textContent;
            document.getElementById("input-cargo").value = cells[4].textContent;
        }

        function saveChanges() {
            if (!currentRow) return;

            const nro = document.getElementById("input-nro").value;
            const nombre = document.getElementById("input-nombre").value;
            const cedula = document.getElementById("input-cedula").value;
            const telefono = document.getElementById("input-telefono").value;
            const cargo = document.getElementById("input-cargo").value;

            const cells = currentRow.querySelectorAll("td");
            cells[0].textContent = nro;
            cells[1].textContent = nombre;
            cells[2].textContent = cedula;
            cells[3].textContent = telefono;
            cells[4].textContent = cargo;

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
