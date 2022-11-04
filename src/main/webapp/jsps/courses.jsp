<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Courses Found</title>
</head>
<body>
<div>
    <table>
        <thead>
            <tr>
               <th><h1 style="font-size:20px; color:grey;">ID&nbsp;</h1></th>
                <th><h1 style="font-size:20px; color:grey;">Description&nbsp;</h1></th>
                <th><h1 style="font-size:20px; color:grey;">TeacherID&nbsp;</h1></th>
                <th><h1 style="font-size:20px; color:grey;">Delete&nbsp;</h1></th>
                <th><h1 style="font-size:20px; color:grey;">Update&nbsp;</h1></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.id}&nbsp;</td>
                    <td>${course.description}&nbsp;</td>
                    <td>${course.teacherID}&nbsp;</td>
                    <td><a href="${pageContext.request.contextPath}/delete-course?id=${course.id}&description=${course.description}&teacherID=${course.teacherID}">Delete</a>&nbsp;</td>
                    <td><a href="${pageContext.request.contextPath}/update-course?id=${course.id}&description=${course.description}&teacherID=${course.teacherID}">Update</a>&nbsp;</td>
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