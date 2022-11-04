<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Course</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/update-course" method="post">
            <input type="hidden" name="id" value="${course.id}"><br>
            <input type="text" name="description" value="${course.description}"><br>
            <input type="text" name="teacherID" value="${course.teacherID}"><br><br>
            <button type="submit">Update Course</button>
        </form>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</html>