import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, Course> courses = new HashMap<>();
        HashMap<Integer, Student> students = new HashMap<>();

        while(true){

            try{
                Thread.sleep(1500);
            }catch (InterruptedException e){
                System.out.println("Encountered an issue");
                e.printStackTrace();
            }

            IO.PrintStartOptions();
            int choice = IO.promptUserForNumericalInput("Enter: ", scanner);
            switch (choice) {
                case 1:
                    IO.PrintCourseOptions();
                    switch (IO.promptUserForNumericalInput("Enter: ", scanner)) {
                        case 1:
                            Helpers.createCourseHelper(scanner, courses);
                            break;
                            case 2:
                                Helpers.deleteById(scanner, courses, "course");
                                break;
                        case 3:
                            Helpers.updateCourseById(scanner, courses);
                            break;
                            case 4:
                                Helpers.findCourseById(scanner, courses);
                                break;
                                case 5:
                                    break;
                        default:
                            System.out.println("Invalid choice");

                    }
                    break;
                    case 2:
                        IO.PrintStudentOptions();
                        switch (IO.promptUserForNumericalInput("Enter: ", scanner)) {
                            case 1:
                                Helpers.createStudentHelper(scanner, students);
                                break;
                                case 2:
                                    Helpers.deleteById(scanner, students, "student");
                                    break;
                                    case 3:
                                        Helpers.updateStudentById(scanner, students);
                                        break;
                            case 4:
                                Helpers.findStudentByID(scanner, students);
                                break;
                                case 5:
                                    break;
                            default:
                                System.out.println("Invalid choice");

                        }
                        break;
                        case 3:
                            Helpers.enroll(scanner, students, courses);
                            break;
                            case 4:
                                Helpers.withdraw(scanner, students, courses);
                                break;
                                case 5:
                                    Helpers.showALlStudents(students);
                                    break;
                                    case 6:
                                        Helpers.showAllCourses(courses);
                                        break;
                                        case 7:
                                            System.out.println("Thank you for using the program, Goodbye!");
                                            return;




            }
        }

    }

}