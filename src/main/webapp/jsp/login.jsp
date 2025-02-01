<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
    <div class="login">
        <h1>Inicio de Sesión Empleados</h1>
        <form method="post">
            <div class = "username">
                <label>Nombre de usuario</label>
                <input type="text" name="username" placeholder="Correo Electronico" required>
            </div>
            <div class = "password">
                <label>Contraseña</label>
                <input type="password" name="password" placeholder="Contraseña" required>
            </div>
            <button type="submit">Iniciar sesión</button>
        </form>
    </div>
</body>
</html>