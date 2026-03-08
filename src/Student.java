import java.util.HashMap;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private String DOB;
    private HashMap<Integer, Course> courses = new HashMap<>();

    public Student(int id, String name, String DOB) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Name updated");
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
        System.out.println("DOB updated");
    }

    //Prints all student courses
    public void viewEnrolledCourses(){
        for(Course c: courses.values()){
            System.out.println("Enrolled in: " + c.getTitle());
        }
    }

    //Enrolled a student in a course and returns true if the enrollment worked
    public boolean enrollInCourse(Course course){

        if(courses.containsKey(course.getCourseId())){
            System.out.println("Already enrolled in " + course.getCourseId());
            return false;
        }

        courses.put(course.getCourseId(), course);
        System.out.println("Enrolled in " + course.getCourseId());
        return true;

    }


    //Removes a course from a student's list and returns true if the removal was successfull
    public boolean deleteCourseById(Integer id){
        if(courses.containsKey(id)){
            courses.remove(id);
            System.out.println("Course with id: " + id + " has been deleted");
            return true;
        }
        return false;
    }



}
