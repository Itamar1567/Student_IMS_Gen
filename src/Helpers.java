import java.util.HashMap;
import java.util.Scanner;

public class Helpers {

    //Iterates over all students and their values and displays them on screen
    public static void showALlStudents(HashMap<Integer, Student> students){
        for(Student s : students.values()){
            System.out.println("----------------------------------");
            System.out.println("ID: " + s.getId());
            System.out.println("Name: " + s.getName());
            System.out.println("DOB: " + s.getDOB());
            System.out.println("Courses: ");
            s.viewEnrolledCourses();
            System.out.println("----------------------------------");
        }
    }

    //Iterates over all courses and their values and displays them on screen
    public static void showAllCourses(HashMap<Integer, Course> courses){
        for(Course c : courses.values()){
            System.out.println("----------------------------------");
            System.out.println("Id: " + c.getCourseId());
            System.out.println("Title: " + c.getTitle());
            c.viewEnrolledStudents();
            System.out.println("----------------------------------");

        }
    }

    //Function to remove a student from a course keyed by ids of both course and student
    public static void withdraw(Scanner scanner, HashMap<Integer, Student> students, HashMap<Integer, Course> courses) {
        try {

            int studentId = IO.promptUserForNumericalInput("Enter student id: ", scanner);
            while (!students.containsKey(studentId)) {
                System.out.println("Course with id " + studentId + " is not registered");
                studentId = IO.promptUserForNumericalInput("Enter id or -1 to exit: ", scanner);
                if(studentId == -1) { return; }
            }

            Student student = students.get(studentId);

            int courseId = IO.promptUserForNumericalInput("Enter course id: ", scanner);
            while (!courses.containsKey(courseId)) {
                System.out.println("Course with id " + courseId + " is not registered");
                courseId = IO.promptUserForNumericalInput("Enter id or -1 to exit: ", scanner);
                if(courseId == -1) { return; }
            }

            Course course = courses.get(courseId);

            student.deleteCourseById(courseId);
            course.removeStudent(student);

            System.out.println("Successfully withdrawn student from course");
        } catch(Exception e){
            System.out.println("Encountered an issue, returning to menu");
        }
    }

    //Adds a course to the student's course list and a student to the course's student list
    public static void enroll(Scanner scanner, HashMap<Integer, Student> students, HashMap<Integer, Course> courses){
        int studentId = IO.promptUserForNumericalInput("Enter student id: ", scanner);
        while(!students.containsKey(studentId)){
            System.out.println("Course with id " + studentId + " is not registered");
            studentId = IO.promptUserForNumericalInput("Enter id or -1 to exit: ", scanner);
            if(studentId == -1) { return; }
        }

        Student student = students.get(studentId);

        int courseId = IO.promptUserForNumericalInput("Enter course id: ", scanner);
        while(!courses.containsKey(courseId)){
            System.out.println("Course with id " + courseId + " is not registered");
            courseId = IO.promptUserForNumericalInput("Enter id or -1 to exit: ", scanner);
            if(courseId == -1) { return; }
        }

        Course course = courses.get(courseId);

        course.enrollStudent(student);
        student.enrollInCourse(course);

        System.out.println("Succesfully enrolled student " + student.getId() + " into course " + " with id " + course.getCourseId());
    }

    // Retrieves the details of a course keyed by Id
    public static void findCourseById(Scanner scanner, HashMap<Integer, Course> courses) {
        int id = IO.promptUserForNumericalInput("Enter a course Id: ", scanner);
        while(!courses.containsKey(id)){
            System.out.println("Course with id " + id + " is not registered");
            id = IO.promptUserForNumericalInput("Enter id or -1 to exit: ", scanner);
            if(id == -1) { return; }
        }

        Course course = courses.get(id);

        System.out.println("-----------------------------------");
        System.out .println("Id: " + course.getCourseId());
        System.out.println("Title: " + course.getTitle());
        course.viewEnrolledStudents();
        System.out.println("----------------------------------");

    }

    // Retrieves the details of a student keyed by Id
    public static void findStudentByID(Scanner scanner, HashMap<Integer, Student> students){
        int id = IO.promptUserForNumericalInput("Enter a student Id: ", scanner);
        while(!students.containsKey(id)){
            System.out.println("Student with id " + id + " is not registered");
            id = IO.promptUserForNumericalInput("Enter id or -1 to exit: ", scanner);
            if(id == -1) { return; }
        }

        Student student = students.get(id);

        System.out.println("-----------------------------------");
        System.out.println("Id: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("DOB: " + student.getDOB());
        student.viewEnrolledCourses();
        System.out.println("----------------------------------");
    }

    // Gives the ability to change the title of a course keyed by id
    public static void updateCourseById(Scanner scanner, HashMap<Integer, Course> courses){
        int id = IO.promptUserForNumericalInput("Please enter a course id to update: ", scanner);
        while(!courses.containsKey(id)){
            System.out.println("Course with id " + id + " is not registered");
            id = IO.promptUserForNumericalInput("Enter id or -1 to exit: ", scanner);
            if(id == -1) { return; }

        }

        Course course = courses.get(id);

        while(true){
            IO.PrintUpdateCourseOptions();
            switch (IO.promptUserForNumericalInput("Enter: ", scanner)) {
                case 1:
                    course.setTitle(IO.promptUserForStringInput("Enter title: ", scanner));
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    //Gives the ability to change the DOB and name of a student keyed by id
    public static void updateStudentById(Scanner scanner, HashMap<Integer, Student> students) {
        int id = IO.promptUserForNumericalInput("Please enter a student id to update: ", scanner);
        while(!students.containsKey(id)){
            System.out.println("Student with id " + id + " is not registered");
            id = IO.promptUserForNumericalInput("Enter id or -1 to exit: ", scanner);
            if(id == -1) { return; }
        }

        Student student = students.get(id);

        while(true){
            IO.PrintUpdateStudentOptions();
            switch (IO.promptUserForNumericalInput("Enter: ", scanner)) {
                case 1:
                    student.setName(IO.promptUserForStringInput("Enter name: ", scanner));
                    break;
                case 2:
                    student.setDOB(IO.promptUserForStringInput("Enter DOB (mm/dd/yyyy): ", scanner));
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    //Deletes from either the course list or the students list by providing a corresponding id and a map i.e courses or students
    //Uses a generic type T to allow for both HashMaps
    public static <T> void deleteById(Scanner scanner, HashMap<Integer, T> map, String type) {
        try {


            int id = IO.promptUserForNumericalInput("Please enter a " + type + " id to delete: ", scanner);
            while (!map.containsKey(id)) {
                System.out.println(type + " with id " + id + " is not registered");
                id = IO.promptUserForNumericalInput("Enter id or -1 to exit: ", scanner);
                if(id == -1) { return; }
            }

            map.remove(id);
            System.out.println(type + " with id " + id + " has been deleted");
        }catch (Exception e){
            System.out.println("Encountered an issue returning to menu");
        }
    }


    //Creates a course and adds it to the courses list
    public static void createCourseHelper(Scanner scanner, HashMap<Integer, Course> courses) {

        System.out.println("Create a course and add it to the list");
        int id = IO.promptUserForNumericalInput("Please enter a unique course id: ", scanner);
        while(courses.containsKey(id)){
            System.out.println("Course with id " + id + " already exists");
            id = IO.promptUserForNumericalInput("Enter id: ", scanner);
        }

        String title = IO.promptUserForStringInput("Please enter a course title: ", scanner);

        Course course = new Course(id, title);

        courses.put(id, course);

        System.out.println("Course with id " + id + " has been created");

    }

    //Creates a student and adds them to the students list
    public static void createStudentHelper(Scanner scanner, HashMap<Integer, Student> students) {

        System.out.println("Create a Student and add to them to the list");
        int id = IO.promptUserForNumericalInput("Please enter a unique student id: ", scanner);
        while(students.containsKey(id)){
            System.out.println("Student with id" + id + " already exists");
            id = IO.promptUserForNumericalInput("Enter id: ", scanner);
        }

        String studentName = IO.promptUserForStringInput("Please enter student name: ", scanner);
        String DateOfBirth = IO.promptUserForStringInput("Date of Birth (mm/dd/yyyy): ", scanner);

        Student student = new Student(id, studentName, DateOfBirth);

        students.put(id, student);

        System.out.println("Student with id " + id + " has been created");

    }
}
