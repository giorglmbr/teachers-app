package gr.aueb.sev.dao;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;

public interface IStudentCourseDAO {
	
	void insert(StudentCourse studentCourse) throws SQLException;
	
	StudentCourse delete(StudentCourse studentCourse) throws SQLException;
	
	List<Student> getStudentsByCourseID(int courseID) throws SQLException;
	
	List<Course> getCoursesByStudentID(int studentID) throws SQLException;

	
}
