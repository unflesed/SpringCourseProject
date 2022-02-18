<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <style><%@include file="/CSS/login.css"%></style>
</head>
<body>
<div class="block">
    <h1>Login to your account</h1>
    <form action="/login" method="post">
        <p>Login:</p>
        <input type="text" name="username"/>
        <p>Password:</p>
        <input type="password" name="password">
        <br/><br/>
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
