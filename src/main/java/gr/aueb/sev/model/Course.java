package gr.aueb.sev.model;

public class Course {
	private int id;
	private String description;
	private int teacherID;
	
	
	public Course() {}


	public Course(int id, String description, int teacherID) {
		super();
		this.id = id;
		this.description = description;
		this.teacherID = teacherID;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getTeacherID() {
		return teacherID;
	}


	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", description=" + description + ", teacherID=" + teacherID + "]";
	}
	
	
	
}
	
	