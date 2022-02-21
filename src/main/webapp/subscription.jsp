<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successful subscription!</title>
    <style><%@include file="/CSS/subscribed.css"%></style>
</head>
<body>
<h1>You have successfully subscribed to the journal!</h1>
<br/>
<button type="button"
        onclick='window.location.pathname="journal/all"'>Ok!</button>
</body>
</html>
