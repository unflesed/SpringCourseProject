<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.02.2022
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <style><%@include file="/CSS/profile.css"%></style>
</head>
<body>
<h1>My profile</h1>
<br/>
<div class="block">
    <label>First name:</label>
    <div class="firstName"><strong>${profile.firstName}</strong></div>
    <br/>
    <label>Last name:</label>
    <div class="lastName"><strong>${profile.lastName}</strong></div>
    <br/>
    <label>Phone:</label>
    <div class="phone"><strong>${profile.phone}</strong></div>
    <br/>
    <label>Email:</label>
    <div class="email"><strong>${profile.email}</strong></div>
</div>

<br/><br/>
<div class="h">
    <h3>To update or save profile input new params </h3>
    <h3>and press "Update/Save" button</h3>
</div>

<form class="form" method="POST" action="/profile/update">
    <table>
        <tr>
            <td><label for="firstName">First name</label></td>
            <td><input type="text" name="firstName" id="firstName"/></td>
        </tr>
        <tr>
            <td><label for="lastName">Last name</label></td>
            <td><input type="text" name="lastName" id="lastName"/></td>
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
                <input type="submit" value="Update/Save">
            </td>
        </tr>
    </table>
</form>

<br/>
<br/>
<button type="button"
        onclick='window.location.pathname="journal/all"'>back</button>
</body>
</html>

