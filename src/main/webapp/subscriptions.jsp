<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subscriptions</title>
</head>
<body>
<h1>List of your subscriptions: </h1>

<c:forEach items="${journals}" var="journal" varStatus="status">
    <p><h2>Result #${status.index + 1}</h2> ${journal}</p>
</c:forEach>

<button type="button"
        onclick='window.location.pathname="journal/all"'>back</button>
</body>
</html>
