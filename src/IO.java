import java.util.Scanner;

public class IO {

	/*

    This class is used to validate user input and prompt them


     */
	public static void lineBreak() {
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public static void PrintUpdateStudentOptions() {
		System.out.println("1. Change name");
		System.out.println("2. Change DOB");
		System.out.println("3. Finish");
	}

	public static void PrintUpdateCourseOptions() {
		System.out.println("1. Change title");
		System.out.println("2. Finish");
	}

	public static void PrintTeacherOptions() {
		System.out.println("1. Add a teacher");
		System.out.println("2. Delete a teacher");
		System.out.println("3. Show all teachers");
		System.out.println("4. Exit");
	}

	public static void PrintStudentOptions() {
		System.out.println("1. Add a new student");
		System.out.println("2. Delete a student by id");
		System.out.println("3. Update a student by id");
		System.out.println("4. Find student by id\n");
		System.out.println("5. Exit");
	}

	public static void PrintCourseOptions() {
		System.out.println("1. Add a new course");
		System.out.println("2. Delete a course by id");
		System.out.println("3. Update a course by id");
		System.out.println("4. Find course by id\n");
		System.out.println("5. Exit");
	}

	public static void PrintStartOptions() {
		System.out.println("Welcome to the Student IMS");
		System.out.println("What would you like to do today?");
		System.out.println("Choose an option by entering a number \n");
		System.out.println("0. Teacher Options");
		System.out.println("1. Course Options");
		System.out.println("2. Student Options\n");
		System.out.println("3. Enroll student in a course");
		System.out.println("4. Withdraw student from a course\n");
		System.out.println("5. Show all students");
		System.out.println("6. Show all courses");
		System.out.println("7. Exit\n");
	}

	// Promptes the user with a custom string and returns their input
	public static String promptUserForStringInput(String s, Scanner scanner) {
		System.out.print(s);
		return scanner.nextLine();
	}

	//Validates if a value is numeric does not allow the user to continue before choosing a number
	public static int promptUserForNumericalInput(String s, Scanner scanner) {
		System.out.print(s);
		String input = scanner.nextLine().trim();
		while (!isInteger(input)) {
			System.out.println("Please enter a numeric value: ");
			input = scanner.nextLine();
		}

		return Integer.parseInt(input);
	}

	//Checks if a provided string is an integer
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
