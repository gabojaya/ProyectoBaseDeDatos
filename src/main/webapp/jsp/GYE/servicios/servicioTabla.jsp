<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar servicio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/GYE/tabla.css">
</head>
<body>
    <div class="content">
        <h1 class="welcome-section">Servicios</h1>
        <table class="services-table" id="main-table">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Precio</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Juan</td>
                    <td>Corte de cabello + baÃ±o</td>
                    <td>$20</td>
                    <td><button class="action-btn modify-btn" onclick="openForm(this)">Modificar</button></td>
                </tr>
                <tr>
                    <td>MarÃ­a</td>
                    <td>BaÃ±o</td>
                    <td>$30</td>
                    <td><button class="action-btn modify-btn" onclick="openForm(this)">Modificar</button></td>
                </tr>
            </tbody>
        </table>

        <div class="form-container" id="form-container">
            <h2>Modificar Servicios</h2>
            <table class="services-table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" id="input-nombre"></td>
                        <td><input type="text" id="input-descripcion"></td>
                        <td><input type="numer" id="input-precio"></td>
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
            document.getElementById("input-descripcion").value = cells[1].textContent;
            document.getElementById("input-precio").value = cells[2].textContent;
        }

        function saveChanges() {
            if (!currentRow) return;

            const nombre = document.getElementById("input-nombre").value;
            const descripcion = document.getElementById("input-descripcion").value;
            const precio = document.getElementById("input-precio").value;

            const cells = currentRow.querySelectorAll("td");
            cells[0].textContent = nombre;
            cells[1].textContent = descripcion;
            cells[2].textContent = precio;

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
