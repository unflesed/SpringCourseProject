<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Journals</title>
</head>
<body>

<h1>Journals : </h1>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Journal name</th>
        <th>Genre</th>
        <th>Periodicity</th>
        <th>Cost</th>
        <th>Subscription</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${journals}" var="journal" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${journal.id}</td>
            <td>${journal.journalName}</td>
            <td>${journal.genre}</td>
            <td>${journal.periodicity}</td>
            <td>${journal.cost}</td>
            <td>
                <form action="/journal/subscribe/${journal.id}" method="post">
                    <input type="submit" name="button" value="Subscribe"/>
                </form>
            </td>
            <td>
                <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                <a href="/journal/remove/${journal.id}">Remove</a>
                </sec:authorize>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<a href="/journal/subscriptions/">My subscriptions</a>
<br/>

<h2>To add new journal press "Add" button</h2>
<form method="POST" action="/journal/add">
    <table>
        <tr>
            <td><label for="journalName">Journal name</label></td>
            <td><input type="text" name="journalName" id="journalName"/></td>
        </tr>
        <tr>
            <td><label for="genre">Genre</label></td>
            <td><input type="text" name="genre" id="genre"/></td>
        </tr>
        <tr>
            <td><label for="periodicity">Periodicity</label></td>
            <td><input type="text" name="periodicity" id="periodicity"/></td>
        </tr>
        <tr>
            <td><label for="cost">Cost</label></td>
            <td><input type="number" name="cost" id="cost"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Add">
            </td>
        </tr>
    </table>
</form>

<br/><br/>
<h2>To update journal input it's Id, new params and press "Update" button</h2>
<form method="POST" action="/journal/update">
    <table>
        <tr>
            <td><label for="id">Id</label></td>
            <td><input type="number" name="id" id="id"/></td>
        </tr>
        <tr>
            <td><label for="journalName">Journal name</label></td>
            <td><input type="text" name="journalName" id="journalName"/></td>
        </tr>
        <tr>
            <td><label for="genre">Genre</label></td>
            <td><input type="text" name="genre" id="genre"/></td>
        </tr>
        <tr>
            <td><label for="periodicity">Periodicity</label></td>
            <td><input type="text" name="periodicity" id="periodicity"/></td>
        </tr>
        <tr>
            <td><label for="cost">Cost</label></td>
            <td><input type="number" name="cost" id="cost"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
</form>

<br/><br/>
<h2>Input genre to find all journals of appropriate genre and press "Search" button</h2>
<form method="POST" action="/journal/findByGenre">
    <table>
        <tr>
            <td><label for="genre">Genre</label></td>
            <td><input type="text" name="genre"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Search">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
