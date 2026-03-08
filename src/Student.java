import java.util.HashMap;
import java.util.List;

public class Student extends Person {

    private float grade;

	private HashMap<Integer, Course> courses = new HashMap<>();

	public Student(int id, String name, String DOB) {
		super(id, name, DOB, "Student");
        grade = 0;
	}

	@Override
	public void setType(String type) {
		type = type.toUpperCase();
	}

    public void setGrade(float newGrade){
        this.grade = newGrade;
    }

    public float getGrade() {
        return grade;
    }

	//Prints all student courses
	public void viewEnrolledCourses() {
		for (Course c : courses.values()) {
			System.out.println("Enrolled in: " + c.getTitle());
		}
	}

	//Enrolled a student in a course and returns true if the enrollment worked
	public boolean enrollInCourse(Course course) {
		if (courses.containsKey(course.getCourseId())) {
			System.out.println("Already enrolled in " + course.getCourseId());
			return false;
		}

		courses.put(course.getCourseId(), course);
		System.out.println("Enrolled in " + course.getCourseId());
		return true;
	}

	//Removes a course from a student's list and returns true if the removal was successfull
	public boolean deleteCourseById(Integer id) {
		if (courses.containsKey(id)) {
			courses.remove(id);
			System.out.println("Course with id: " + id + " has been deleted");
			return true;
		}
		return false;
	}
}
