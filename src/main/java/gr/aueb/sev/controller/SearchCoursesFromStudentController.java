package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dao.StudentCourseDAOImpl;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.StudentCourseServiceImpl;


@WebServlet("/search-courses-from-student")
public class SearchCoursesFromStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO); //Wiring
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		
		try {
			List<Course> coursesFromStudent = studentCourseServ.getCoursesByStudentID(studentID);
			
			if (coursesFromStudent.size() == 0) {
				request.setAttribute("courseNotFound", true);
				request.getRequestDispatcher("/jsps/menu.jsp")
					.forward(request, response);
			}else {
				request.setAttribute("coursesFromStudent", coursesFromStudent);
				request.setAttribute("studentID", studentID);
				request.getRequestDispatcher("/jsps/courses-from-student.jsp")
					.forward(request, response);
			}
			
		}catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/menu.jsp")
				.forward(request, response);
		}
	}
}