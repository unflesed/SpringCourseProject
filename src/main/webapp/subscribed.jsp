<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warning!</title>
    <style><%@include file="/CSS/subscribed.css"%></style>
</head>
<body>
<h1>You've already subscribed on this journal! </h1>
<br/>
<button type="button"
        onclick='window.location.pathname="journal/all"'>back</button>
</body>
</html>
