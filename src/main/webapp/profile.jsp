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
    <title>Title</title>
</head>
<body>
<h2>My profile:</h2>
<br/>
<label>First name</label>${profile.firstName}
<br/>
<label>Last name</label>${profile.lastName}
<br/>
<label>Phone</label>${profile.phone}
<br/>
<label>Email</label>${profile.email}
<br/><br/>
<h2>To update or save profile input new params and press "Update" button</h2>
<form method="POST" action="/profile/update">
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
