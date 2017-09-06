<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<a href="/SpringCRUDApp/tasker">Home</a><br>

<form:form action="/SpringCRUDApp/tasker/registerProcess" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>User name</td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td>Email Id</td>
            <td><form:input type="email" path="emailId"/></td>
        </tr>
        <tr>
            <td>Mobile No</td>
            <td><form:input path="mobileNo"/></td>
        </tr>
        <tr>
            <td colspan=2><input type="submit" value="Register"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>