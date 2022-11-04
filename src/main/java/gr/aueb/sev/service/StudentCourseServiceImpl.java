package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;
import gr.aueb.sev.service.exceptions.StudentCourseNotFoundException;

public class StudentCourseServiceImpl implements IStudentCourseService{
	private final IStudentCourseDAO studentCourseDAO;
	
	public StudentCourseServiceImpl(IStudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO = studentCourseDAO;
	}

	@Override
	public void insertStudentCourse(StudentCourseDTO studentCourseDTO) throws SQLException {
		StudentCourse studentCourse = extract(studentCourseDTO);
		try {
			studentCourseDAO.insert(studentCourse);
		} catch (SQLException e) {
			throw e;
		}
		
	}

	@Override
	public void deleteStudentCourse(StudentCourseDTO studentCourseDTO) throws SQLException, StudentCourseNotFoundException {
		StudentCourse studentCourseToDelete = extract(studentCourseDTO);
		try {
			if (studentCourseDAO.delete(studentCourseToDelete)==null) {
				throw new StudentCourseNotFoundException(studentCourseToDelete);
			}
		} catch (SQLException e) {
			throw e;
		} catch (StudentCourseNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Student> getStudentsByCourseID(int courseID) throws SQLException {
		try {
			return studentCourseDAO.getStudentsByCourseID(courseID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Course> getCoursesByStudentID(int studentID) throws SQLException {
		try {
			return studentCourseDAO.getCoursesByStudentID(studentID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private StudentCourse extract(StudentCourseDTO studentCourseDTO) {
		StudentCourse studentCourse =  new StudentCourse();
		studentCourse.setStudentID(studentCourseDTO.getStudentID());
		studentCourse.setCourseID(studentCourseDTO.getCourseID());
		return studentCourse;
	}
}