<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Student inserted successfully</title>
</head>
<body>
    <h2><h1 style="font-size:20px; color:grey;">Student inserted successfully</h1></h2>
    <div>
        <p>${insertedStudent.lastname}</p>
        <p>${insertedStudent.firstname}</p>
    </div>

    <div>
        <a href="${pageContext.request.contextPath}/jsps/menu.jsp">Return to menu</a>
    </div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</html>