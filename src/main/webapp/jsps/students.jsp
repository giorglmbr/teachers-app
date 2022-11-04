<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Students Found</title>
</head>
<body>
<div>
    <table>
        <thead>
            <tr>
                <th><h1 style="font-size:20px; color:grey;">ID&nbsp;</h1></th>
                <th><h1 style="font-size:20px; color:grey;">Firstname&nbsp;</h1></th>
                <th><h1 style="font-size:20px; color:grey;">Lastname&nbsp;</h1></th>
                <th><h1 style="font-size:20px; color:grey;">Delete&nbsp;</h1></th>
                <th><h1 style="font-size:20px; color:grey;">Update&nbsp;</h1></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}&nbsp;</td>
                    <td>${student.firstname}&nbsp;</td>
                    <td>${student.lastname}&nbsp;</td>
                    <td><a href="${pageContext.request.contextPath}/delete-student?id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}">Delete</a>&nbsp;</td>
                    <td><a href="${pageContext.request.contextPath}/update-student?id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}">Update</a>&nbsp;</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div> 
    <c:if test="${deleteAPIError}">
        <p>Something went wrong in delete</p>
    </c:if>
</div>
<div> 
    <c:if test="${sqlError}">
        <p>Error in SQL update</p>
    </c:if>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</html>