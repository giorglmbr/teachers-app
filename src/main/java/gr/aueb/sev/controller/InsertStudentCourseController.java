package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.ICourseDAO;
import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dao.StudentCourseDAOImpl;
import gr.aueb.sev.dao.CourseDAOImpl;
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.StudentCourseServiceImpl;
import gr.aueb.sev.service.CourseServiceImpl;

@WebServlet("/insert-studentcourse")
public class InsertStudentCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO); //Wiring

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int studentID = Integer.parseInt(request.getParameter("studentID").trim());
		int courseID = Integer.parseInt(request.getParameter("courseID").trim());
		
		StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
		studentCourseDTO.setStudentID(studentID);
		studentCourseDTO.setCourseID(courseID);
		
		try {
			studentCourseServ.insertStudentCourse(studentCourseDTO);
			request.setAttribute("insertedStudentCourse", studentCourseDTO);
			request.getRequestDispatcher("/jsps/studentcourseinserted.jsp")
				.forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/menu.jsp")
				.forward(request, response);
		}
	}
}