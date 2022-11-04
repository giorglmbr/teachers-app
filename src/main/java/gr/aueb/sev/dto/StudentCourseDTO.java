package gr.aueb.sev.dto;

public class StudentCourseDTO {
	private int studentID;
	private int courseID;
	
	public StudentCourseDTO() {}

	public StudentCourseDTO(int studentID, int courseID) {
		this.studentID = studentID;
		this.courseID = courseID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	
	

}