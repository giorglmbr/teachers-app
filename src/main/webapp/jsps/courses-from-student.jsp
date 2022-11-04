<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Courses From Student Found</title>
</head>
<body>
<div>
    <table>
        <thead>
            <tr>
               <th><h1 style="font-size:20px; color:grey;">StudentID&nbsp;</h1></th>
                <th><h1 style="font-size:20px; color:grey;">CourseID&nbsp;</h1></th>
                <th><h1 style="font-size:20px; color:grey;">Delete&nbsp;</h1></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="coursesFromStudent" items="${coursesFromStudent}">
                <tr>
                    <td>${student.id}&nbsp;</td>
                    <td>${course.id}&nbsp;</td>
                    <td><a href="${pageContext.request.contextPath}/delete-studentcourse?studentID=${student.id}&courseID=${course.id}">Delete</a>&nbsp;</td>
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