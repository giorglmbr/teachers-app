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
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.exceptions.StudentCourseNotFoundException;


@WebServlet("/delete-studentcourse")
public class DeleteStudentCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO); //Wiring
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		
		int studentID = Integer.parseInt(request.getParameter("studentID").trim());
		int courseID = Integer.parseInt(request.getParameter("courseID").trim());
		
		// Validation
		
		StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
		studentCourseDTO.setStudentID(studentID);
		studentCourseDTO.setCourseID(courseID);
		
		try {
			
			studentCourseServ.deleteStudentCourse(studentCourseDTO);
			
			request.setAttribute("studentcourse", studentCourseDTO);
			request.getRequestDispatcher("/jsps/studentcoursedeleted.jsp")
				.forward(request, response);
			
		}catch (SQLException e) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/studentscourses.jsp")
				.forward(request, response);
		} catch (StudentCourseNotFoundException e){
			request.setAttribute("studentcourseNotFound", true);
			request.getRequestDispatcher("/jsps/studentscourses.jsp")
				.forward(request, response);
		}
	}
	

}