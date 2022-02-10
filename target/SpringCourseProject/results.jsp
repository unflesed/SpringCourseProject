<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search result</title>
</head>
<body>
<h1>List of journals : </h1>

<c:forEach items="${journals}" var="journal" varStatus="status">
    <p><h2>Result #${status.index + 1}</h2> ${journal}</p>
</c:forEach>

<button type="button"
        onclick='window.location="all"'>back</button>
</body>
</html>
