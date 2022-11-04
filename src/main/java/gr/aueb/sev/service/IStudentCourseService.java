package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;
import gr.aueb.sev.service.exceptions.StudentCourseNotFoundException;

public interface IStudentCourseService {
	
	/**
	 * Inserts a {@link StudentCourse} based on the data carried by the P{@link StudentCourseDTO}
	 * @param studentcourseDTO
	 * 			DTO object that contains the data.
	 * @throws SQLException
	 *	 		if any error happens during SQL insert 
	 */
	void insertStudentCourse(StudentCourseDTO studentcourseDTO) throws SQLException;
	
	/**
	 * Deletes {@link StudentCourse} based on the data carried by the P{@link StudentCourseDTO}
	 * @param studentcourseDTO
	 * 			DTO object that contains the data.
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 * @throws StudentCourseNotFoundException
	 * 			if the studentCourse is not found
	 */
	void deleteStudentCourse(StudentCourseDTO studentcourseDTO) throws SQLException, StudentCourseNotFoundException;
		
	/**
	 * Gets a list of {@link List} of {@link Course} based on their courseID
	 * @param courseID
	 * 			an integer of object that contains the courseID of the courses we are looking for or part of it
	 * @return
	 * 			{@link List} of {@link Course} found based on courseID
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 */
	List<Student> getStudentsByCourseID(int courseID) throws SQLException;
	
	/**
	 * Gets a list of {@link List} of {@link Student} based on their studentID
	 * @param studentID
	 * 			an integer of object that contains the studentID of the students we are looking for or part of it
	 * @return
	 * 			{@link List} of {@link Student} found based on studentID
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 */
	List<Course> getCoursesByStudentID(int studentID) throws SQLException;
}