import java.util.HashMap;
import java.util.List;

public class Course {

	private int courseId;
	private String title;
	private HashMap<Integer, Student> studentsEnrolled = new HashMap<>();

	public Course(int courseId, String title) {
		this.courseId = courseId;
		this.title = title;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		System.out.println("Title updated");
	}

	//Prints all the enrolled students and their names
	public void viewEnrolledStudents() {
		for (Student s : studentsEnrolled.values()) {
			System.out.println("Enrolled: " + s.getName());
		}
	}

	// Adds a student to the course's students list returns true if successfully added
	public boolean enrollStudent(Student student) {
		if (studentsEnrolled.containsKey(student.getId())) {
			System.out.println("Student with id " + student.getId() + " is already enrolled");
			return false;
		}

		studentsEnrolled.put(student.getId(), student);
		return true;
	}

	//Removes a student from the course's students list returns true if the student was successfully removed
	public boolean removeStudent(Student student) {
		if (!studentsEnrolled.containsKey(student.getId())) {
			System.out.println("Student with id " + student.getId() + " is not enrolled");
			return false;
		}

		studentsEnrolled.remove(student.getId());
		return true;
	}

	public void viewCourse() {
		System.out.println("Course id: " + courseId);
		System.out.println("Course title: " + title);
		for (Student student : studentsEnrolled.values()) {
			System.out.println("Enrolled: " + student.getName());
		}
	}
}
