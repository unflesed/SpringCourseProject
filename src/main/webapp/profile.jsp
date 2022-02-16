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
<br/>
<button type="button"
        onclick='window.location.pathname="journal/all"'>back</button>
</body>
</html>
