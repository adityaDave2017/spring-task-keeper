<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Your Tasks</title>
</head>
<body>

<a href="/SpringCRUDApp/tasker/bye">Logout</a><br><br>

<h2>Your tasks</h2><br>

<%
    Enumeration<String> s = session.getAttributeNames();
    while (s.hasMoreElements()) {
        String str = s.nextElement();
        System.out.print(str + "$$$" + session.getAttribute(str));
    }
%>

<table>
    <c:choose>
        <c:when test="${tasks.isEmpty()}">
            <tr>
                <td>No tasks entered yet!</td>
            </tr>
        </c:when>
        <c:otherwise>
            <tr>
                <td>Is Done?</td>
                <td>Task Description</td>
            </tr>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <c:choose>
                        <c:when test="${task.isDone()}">
                            <td><input type="checkbox" checked disabled/></td>
                        </c:when>
                        <c:otherwise>
                            <td><input type="checkbox" disabled/></td>
                        </c:otherwise>
                    </c:choose>
                    <td>${task.taskDesc}</td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</table>

<br><br>

<h4>Add Task</h4>
<br>
<form action="/SpringCRUDApp/tasker/addTask" method="post">
    Task Description: <input type="text" name="taskDesc"/> <input type="submit" value="Add"/>
</form>

</body>
</html>