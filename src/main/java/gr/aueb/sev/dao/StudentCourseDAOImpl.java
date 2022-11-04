package gr.aueb.sev.dao;

import static gr.aueb.sev.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.sev.dao.dbutil.DBUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;

public class StudentCourseDAOImpl implements IStudentCourseDAO{

	@Override
	public void insert(StudentCourse studentCourse) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		try {
			String sql = "INSERT INTO STUDENTS_COURSES (STUDENT_ID, COURSE_ID) VALUES (?, ?)";
			// + "'" + studentCourse.getStudentID() + "', " + "'" + studentCourse.getCourseID()() + "'"
			
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, studentCourse.getStudentID());
			pst.setInt(2, studentCourse.getCourseID());
			
			pst.executeUpdate(); // we could add a variable as this returns the count of updates!!! (count of rows affected)
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
		
	}

	@Override
	public StudentCourse delete(StudentCourse studentCourse) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		try {
			String sql = "DELETE FROM STUDENTS_COURSES WHERE STUDENT_ID=? AND COURSE_ID=?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, studentCourse.getStudentID());
			pst.setInt(2, studentCourse.getCourseID());
			
			int n = pst.executeUpdate();
			
			if (n==0) {
				return null;
			}else {
				return studentCourse;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
		
	}
	
	@Override
	public List<Student> getStudentsByCourseID(int courseID) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		List<Student> students = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			String sql = "SELECT STUDENTS.* FROM STUDENTS INNER JOIN STUDENTS_COURSES ON ID = STUDENT_ID WHERE COURSE_ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, courseID);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("ID"));
				student.setFirstname(rs.getString("FIRSTNAME"));
				student.setLastname(rs.getString("LASTNAME"));
				
				students.add(student);
				
			}
			return students;
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
	}

	@Override
	public List<Course> getCoursesByStudentID(int studentID) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		List<Course> courses = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COURSES.* FROM COURSES INNER JOIN STUDENTS_COURSES ON ID = COURSE_ID WHERE STUDENT_ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, studentID);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("ID"));
				course.setDescription(rs.getString("DESCRIPTION"));
				course.setTeacherID(rs.getInt("TEACHER_ID"));
				
				courses.add(course);
				
			}
			return courses;
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
	}
}