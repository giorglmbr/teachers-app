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
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.StudentCourseServiceImpl;


@WebServlet("/search-students-from-course")
public class SearchStudentsFromCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO); //Wiring
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int courseID = Integer.parseInt(request.getParameter("courseID"));
		
		try {
			List<Student> studentsFromCourse = studentCourseServ.getStudentsByCourseID(courseID);
			
			if (studentsFromCourse.size() == 0) {
				request.setAttribute("studentNotFound", true);
				request.getRequestDispatcher("/jsps/menu.jsp")
					.forward(request, response);
			}else {
				request.setAttribute("studentsFromCourse", studentsFromCourse);
				request.getRequestDispatcher("/jsps/students-from-course.jsp")
					.forward(request, response);
			}
			
		}catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/menu.jsp")
				.forward(request, response);
		}
	}
}