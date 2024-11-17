import java.util.Scanner;

public class Menu {
    public int DisplayMainMenu() {
        int userInput = 0;
        Scanner scanner = new Scanner(System.in);

        while (userInput < 1 || userInput > 6 ) {

            System.out.println("Welcome to the Grade Book!");
            System.out.println();
            System.out.println("1. View all students in a course");
            System.out.println("2. Change a student's grade");
            System.out.println("3. Move a student to a different class");
            System.out.println("4. Add a student to a class");
            System.out.println("5. Remove a student from a class");
            System.out.println("6. Quit the program");
            System.out.println("Please choose an option 1-6:");
            System.out.println();

            userInput = scanner.nextInt();
        }
        return userInput;
    }
}