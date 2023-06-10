<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form method="post" action="index">
    <label>name:</label>
    <input type="text" name="nameID" required><br>

    <label>Model:</label>
    <select name="modelValue">
        <option value="1">Model 1</option>
        <option value="2">Model 2</option>
    </select><br>
    <input type="submit" value="Login">
</form>
<script>
    const nameInput = document.querySelector('#id');
    const submitBtn = document.querySelector('#submit');

    nameInput.addEventListener('input', () => {
        submitBtn.disabled = nameInput.value.trim().length === 0;
    });
</script>
</body>
</html>