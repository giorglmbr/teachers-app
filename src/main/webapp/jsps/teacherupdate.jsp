<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<t:simple_layout title="Update Teacher">
<jsp:attribute name="body_area">
    <div>
        <form action="${pageContext.request.contextPath}/update-teacher" method="post">
            <input type="hidden" name="id" value="${teacher.id}"><br>
            <input type="text" name="firstname" value="${teacher.firstname}"><br>
            <input type="text" name="lastname" value="${teacher.lastname}"><br><br>
            <button type="submit">Update Teacher</button>
        </form>
    </div>
</jsp:attribute>
</t:simple_layout>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>