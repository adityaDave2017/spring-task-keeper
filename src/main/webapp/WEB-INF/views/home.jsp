<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Task Checker</title>
</head>
<body>

<h3>Welcome to task keeper :)</h3>
<form:form action="/SpringCRUDApp/tasker/login" method="post">
    <table>
        <tr>
            <td><form:label path="username"/>User name:</td>
            <td><form:input type="text" path="username"/></td>
        </tr>
        <tr>
            <td><form:label path="password"/>Password:</td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Log In"></td>
        </tr>
    </table>
</form:form>

<h4>Not registered yet? ... <a href="/SpringCRUDApp/tasker/register">Register Here!</a></h4>

</body>
</html>