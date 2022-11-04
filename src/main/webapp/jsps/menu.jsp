<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/menu.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Search</title>
</head>
<body>
    <div class="center">
    
        <div class="search-wrapper">
            <div class="bot-gap">
                <h1 style="font-size:20px; color:grey;" ><span class="title">Teachers Search</span></h1>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/search-teacher" method="get">
                    <input type="text" name="lastname" id="lastname" class="search rounded" placeholder="Insert teacher's lastname" autofocus>
                    <br>
                    <button type="submit" class="search-btn rounded color-btn">Search</button>
                </form>
            </div>
        </div>  
        
        <div class="insert-wrapper">
            <div class="bot-gap">
                <h1 style="font-size:20px; color:grey;"><span class="title"><span class="title">Teachers Insert</span></span></h1>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/insert-teacher" method="post">
                    <input type="text" name="lastname" id="lastname" class="insert rounded" placeholder="lastname"  required>
                    <br>
                    <input type="text" name="firstname" id="firstname" class="insert rounded" placeholder="firstname" required>
                    <br>
                    <button type="submit" class="insert-btn rounded color-btn">Insert</button>
                </form>
            </div>
         </div>     
         <br>
         
    	<div class="search-wrapper">
        	<div class="bot-gap">
                <h1 style="font-size:20px; color:grey;"><span class="title">Students Search</span></h1>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/search-student" method="get">
                    <input type="text" name="lastname" id="lastname" class="search rounded" placeholder="Insert student's lastname" >
                    <br>
                    <button type="submit" class="search-btn rounded color-btn">Search</button>
                </form>
            </div>  
     	</div>
               
        <div class="insert-wrapper">
            <div class="bot-gap">
                <h1 style="font-size:20px; color:grey;"><span class="title">Students Insert</span></h1>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/insert-student" method="post">
                    <input type="text" name="lastname" id="lastname" class="insert rounded" placeholder="lastname"  required>
                    <br>
                    <input type="text" name="firstname" id="firstname" class="insert rounded" placeholder="firstname" required>
                    <br>
                    <button type="submit" class="insert-btn rounded color-btn">Insert</button>
                </form>
            </div>
    	</div>
    	<br>
    	
    	<div class="search-wrapper">
        	<div class="bot-gap">
                <h1 style="font-size:20px; color:grey;"><span class="title">Courses Search</span></h1>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/search-course" method="get">
                    <input type="text" name="description" id="description" class="search rounded" placeholder="Insert course's description" autofocus>
                    <br>
                    <button type="submit" class="search-btn rounded color-btn">Search</button>
                </form>
            </div>  
     	</div>
               
        <div class="insert-wrapper">
            <div class="bot-gap">
                <h1 style="font-size:20px; color:grey;"><span class="title">Courses Insert</span></h1>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/insert-course" method="post">
                    <input type="text" name="description" id="description" class="insert rounded" placeholder="description"  required>
                    <br>
                    <input type="text" name="teacherID" id="teacherID" class="insert rounded" placeholder="teacher's id"  required>
                    <br>
                    <button type="submit" class="insert-btn rounded color-btn">Insert</button>
                </form>
            </div>
    	</div>
    	<br>	
    	
    	<div class="search-wrapper">
        	<div class="bot-gap">
                <h1 style="font-size:20px; color:grey;"><span class="title">Course to Student Search</span></h1>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/search-courses-from-student" method="get">
                    <input type="text" name="studentID" id="studentID" class="search rounded" placeholder="Insert student's ID" required>
                    <br>
                    <button type="submit" class="search-btn rounded color-btn">Search</button>
                </form>
            </div>  
     	</div>
               
        <div class="insert-wrapper">
            <div class="bot-gap">
                <h1 style="font-size:20px; color:grey;"><span class="title">Course to Student Insert</span></h1>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/insert-studentcourse" method="post">
                    <input type="text" name="studentID" id="studentID" class="insert rounded" placeholder="student's ID"  required>
                    <br>
                    <input type="text" name="courseID" id="courseID" class="insert rounded" placeholder="course's id"  required>
                    <br>
                    <button type="submit" class="insert-btn rounded color-btn">Insert</button>
                </form>
            </div>
    	</div>
    	<br>
    	
    	<div class="search-wrapper">
        	<div class="bot-gap">
                <h1 style="font-size:20px; color:grey;"><span class="title">Student to Course Search</span></h1>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/search-students-from-course" method="get">
                    <input type="text" name="courseID" id="courseID" class="search rounded" placeholder="Insert course's ID" autofocus>
                    <br>
                    <button type="submit" class="search-btn rounded color-btn">Search</button>
                </form>
            </div>  
     	</div>
               
        <div class="insert-wrapper">
            <div class="bot-gap">
                <h1 style="font-size:20px; color:grey;"><span class="title">Student to Course Insert</span></h1>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/insert-studentcourse" method="post">
                    <input type="text" name="courseID" id="courseID" class="insert rounded" placeholder="course's ID"  required>
                    <br>
                    <input type="text" name="studentID" id="studentID" class="insert rounded" placeholder="student's id"  required>
                    <br>
                    <button type="submit" class="insert-btn rounded color-btn">Insert</button>
                </form>
            </div>
    	</div>
    	
    </div>
    
    <div class="center"> 
        <c:if test="${sqlError}">
            <p>Error in Insert</p>
        </c:if>
    </div>
    <div class="center"> 
        <c:if test="${teacherNotFound}">
            <p>Teacher not found</p>
        </c:if>
    </div>
    <div class="center"> 
        <c:if test="${studentNotFound}">
            <p>Student not found</p>
        </c:if>
    </div>
    <div class="center"> 
        <c:if test="${courseNotFound}">
            <p>Course not found</p>
        </c:if>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</html>