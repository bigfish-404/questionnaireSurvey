<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>年末アンケート</title>
</head>
<body>
<h1>「年末のアンケ」</h1>
<form method="post" action="index">
    <label>会社：</label>
    <input type="text" name="company" required><br>

    <label>名前：</label>
    <input type="text" name="name" required><br>
    </select><br>
    <input type="submit" value="Login">
</form>
<script>
    const nameInput = document.querySelector('#id');
    const companyInput = document.querySelector('#company');
    const submitBtn = document.querySelector('#submit');

    nameInput.addEventListener('input', validateInputs);
    companyInput.addEventListener('input', validateInputs);

    function validateInputs() {
        submitBtn.disabled = nameInput.value.trim().length === 0 || companyInput.value.trim().length === 0;
    }
</script>
</body>
</html>