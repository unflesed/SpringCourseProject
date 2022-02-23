<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Journals</title>
    <style><%@include file="/CSS/journals.css"%></style>
</head>
<body>

<div id ="header">
    <h1>List of available journals : </h1>
</div>
<!-- Main table -->
<div id ="table1">
    <table id="t1">
        <thead>
        <tr>
            <th>№</th>
            <th>Id</th>
            <th>Journal name</th>
            <th>Genre</th>
            <th>Periodicity</th>
            <th>Cost, $</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${journals}" var="journal" varStatus="status">
            <tr>
                <td class="td1">${status.index + 1}</td>
                <td class="td1">${journal.id}</td>
                <td class="td2">${journal.journalName}</td>
                <td class="td2">${journal.genre}</td>
                <td class="td2">${journal.periodicity}</td>
                <td class="td1">${journal.cost}</td>
                <td>
                    <a class="group2" href="/journal/subscribe/${journal.id}">Subscribe</a>
                </td>
                <td>
                    <a class="group2" href="/journal/unsubscribe/${journal.id}">Unsubscribe</a>
                </td>
                <td>
                    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                        <a class="group2" href="/journal/remove/${journal.id}">Remove</a>
                    </sec:authorize>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<!-- Menu -->
<nav class="menu">
    <ul>
        <li><a class="group1" href="/journal/subscriptions/">My subscriptions</a></li>
        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
            <li><a class="group1" href="#open1">Add new journal</a></li>
        </sec:authorize>
        <li><a class="group1" href="#open3">Find by genre</a></li>
        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
            <li><a class="group1" href="#open2">Update journal</a></li>
        </sec:authorize>
        <li><a class="group1" href="/profile/my">My profile</a></li>
        <li><a class="group1" href="/logout">Logout</a></li>
    </ul>
</nav>
<!-- Popup add journal -->
<div id="open1" class="popup">
    <div class="popup-dialog">
        <div class="popup-content">
            <div class="popup-header">
                <h3 class="popup-title">To add new journal fill in the form and press "Add" button</h3>
                <a href="#close" title="Close" class="close">×</a>
            </div>
            <div class="popup-body">
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
            </div>
        </div>
    </div>
</div>

<!-- Popup update journal -->
<div id="open2" class="popup">
    <div class="popup-dialog">
        <div class="popup-content">
            <div class="popup-header">
                <h3 class="popup-title">To update journal input it's Id, new params and press "Update" button</h3>
                <a href="#close" title="Close" class="close">×</a>
            </div>
            <div class="popup-body">
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
            </div>
        </div>
    </div>
</div>

<!-- Popup find journal by genre -->
<div id="open3" class="popup">
    <div class="popup-dialog">
        <div class="popup-content">
            <div class="popup-header">
                <h3 class="popup-title">Input genre to find all journals of appropriate genre and press "Search" button</h3>
                <a href="#close" title="Close" class="close">×</a>
            </div>
            <div class="popup-body">
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
            </div>
        </div>
    </div>
</div>
<!-- Popup find journal by genre -->
<div id="open4" class="popup">
    <div class="popup-dialog">
        <div class="popup-content">
            <div class="popup-header">
                <h3 class="popup-title">Input genre to find all journals of appropriate genre and press "Search" button</h3>
                <a href="#close" title="Close" class="close">×</a>
            </div>
            <div class="popup-body">
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
            </div>
        </div>
    </div>
</div>
</body>
</html>