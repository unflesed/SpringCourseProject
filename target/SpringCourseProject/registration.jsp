<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09.02.2022
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h2>To register enter all info and press "Register" button</h2>
<form method="POST" action="/registration/add">
    <table>
        <tr>
            <td><label for="login">Login</label></td>
            <td><input type="text" name="login" id="login"/></td>
        </tr>
        <tr>
            <td><label for="password">Password</label></td>
            <td><input type="password" name="password" id="password"/></td>
        </tr>
        <tr>
            <td><label for="First Name">First Name</label></td>
            <td><input type="text" name="First Name" id="First Name"/></td>
        </tr>
        <tr>
            <td><label for="Last Name">Last Name</label></td>
            <td><input type="text" name="Last Name" id="Last Name"/></td>
        </tr>
        <tr>
            <td><label for="phone">Phone</label></td>
            <td><input type="text" name="phone" id="phone"/></td>
        </tr>
        <tr>
            <td><label for="email">Email</label></td>
            <td><input type="text" name="email" id="email"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Register">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
