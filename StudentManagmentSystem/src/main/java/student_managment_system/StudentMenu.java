package student_managment_system;

import java.util.Scanner;
import file_management.FileHandler;

/**
 * Klasssen är mestadels till för att köra menyn, visa menyn och göra olika valalternativ i menyn.
 *
 * Dessutom är klassen till för användaren att skriva in information om eleven, spara informationen, läsa informationen och söka efter eleven.
 *
 * Slutligen kan man med klassen gå ut från programmet.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @since 2024-12-08
 * @see FileHandler,Main,Student,StudentManagment
 */

public class StudentMenu {
    //ToDo: Skapa en attribut för att köra programmet.
    private boolean ongoing;
    //ToDo: Skapa en Scanner-objekt för användarinmatning.
    private Scanner scanner;
    //ToDo: Skapa objektnamnet av StudentManagment
    private StudentManagment studentManagment;
    //ToDo: Skapa en variabel för filen.
    private String file;

    public StudentMenu() {
        //ToDo: Tilldela attributen värden.
        ongoing = true; //ToDo: Lägg ongoing attributet för att köra programmet som sant.
        scanner = new Scanner(System.in);
        studentManagment = StudentManagment.getInstance(); //ToDo: Eftersom hanteringssystemet följer singleton-mönstret ska StudentManagment klassen hämta instansen.
        file = "students.txt";//ToDo: Tilldela file variabeln till students.txt för att det är den filen studentposterna ska vara i.
    }

    /**
     * Metoden kör menyn
     */
    //ToDo: Skapa en metod som kör menyn genom en loop
    public void runMenu() {
        while (ongoing) {
            showMenu();//ToDo: Anropa till en metod som visar menyn medan menyn körs
        }
        scanner.close();//ToDo: När ongoing blir false, alltså när menyn avslutas, ska scanner stängas för ingen mer inmatning ska ske.
    }

    /**
     * Visar menyn med alternativen
     */
    //ToDo: Skapa en meny som visar alternativen for studenthanteringssystemet.
    public void showMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add new student");
        System.out.println("2. Save students to file (For next session)");
        System.out.println("3. Load students from file");
        System.out.println("4. Search for student by ID");
        System.out.println("5. Show all students (Remember to load all students from previous session!)");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        int choice; //ToDo: Spara in användarens val
        try {
            //ToDo: Använd try-catch-block för att fånga att inget tal är över 6 och inga strängar skrivs in
            choice = Integer.parseInt(scanner.nextLine()); //ToDo: Använd Integer.parseInt() för att göra om det till en int så att om användaren skriver en sträng kommer det inte gå.
            doMenuChoice(choice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 6."); //ToDo: Om det blir fel så säg till använder vad den ska skriva in.
        }
    }

    /**
     * Anropar till olika metoder beroende på valalternativ.
     * @param choice är valalternativet från användaren.
     */
    public void doMenuChoice(int choice) {
        //ToDo: Skapa en switch-case för olika valalternativ.
        switch (choice) {
            case 1 -> enterStudentInformation();//ToDo: Val 1 anropa till en metod för att skriva in information om eleven.
            case 2 -> saveItToFile();//ToDo: Val 2 anropa till en metod för att spara studentposter till filen.
            case 3 -> readFromFile();//ToDo: Val 3 anropa till en metod för att ladda studentposter från filen.
            case 4 -> searchForStudent();//ToDo: Val 4 anropa till en metod för att söka en elev genom id.
            case 5 -> displayAllStudents();//ToDo: Val 5 anropa till en metod för att visa alla studenter.
            case 6 -> exitProgram();//ToDo: Val 6 för att lämna programmet.
            default -> System.out.println("Invalid choice. Please try again."); //ToDo: Säger till användaren som klickar på ett annat alternativ än det som presenteras.
        }
    }

    /**
     * En metod för att skriva in elevens information.
     */
    //ToDo:Skapa en metod för att skriva in elevens information.
    private void enterStudentInformation() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        //ToDo: Anropa metoden för att lägga in elevens information i HashMapen och skriv till användaren att det har gjorts.
        studentManagment.putStudentInMap(id, name, grade);
        System.out.println("Student added.");
    }

    /**
     * Spara studentposter till filen
     */
    //ToDo: Skapa en metod för att anropa till metoden saveItToFile i FileHandler. Där sparas de i filen.
    private void saveItToFile() {
        FileHandler.saveItToFile(file, studentManagment.getStudents()); //ToDo: Skicka filen och HashMapen till metoden.
    }

    /**
     * Ladda/Läsa studentposter från filen.
     */
    private void readFromFile() {
        System.out.println("Warning: Current data will be replaced by data from file.");
        studentManagment.getStudents().clear();// ToDo: Hämtar studentposter och töm den.
        FileHandler.readFromFile(file, studentManagment);// ToDo: Skapa en anrop för att läsa studentposter från filen.
    }

    /**
     * Söker efter elever genom id
     */
    //ToDo: Skapa en metod som söker efter elever genom id.
    private void searchForStudent() {
        //ToDo: Ta in id som användaren skriver in.
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        //ToDo: Anropa en metod i StudentManagment klassen för att hämta eleven genom id.
        Student student = studentManagment.getStudentById(id);
        if (student != null) { // ToDo: Skapa en if-sats för att kontrollera att eleven hittades med id.
            System.out.println("Student found. Name: " + student.getName() + ", Grade: " + student.getGrade());
        } else {
            System.out.println("No student found with the given ID."); //ToDo: Gör ett else-block som säger till användaren om eleven inte hittades genom id:et.
        }
    }

    /**
     * Visar alla studenter genom metodanropet för en metod som visar alla elever i StudentManagment klassen.
     */
    //ToDo: Skapa en metod som anropar till metoden i StudentManagment klassen som visar alla elever.
    private void displayAllStudents() {
        studentManagment.showAllStudents();
    }

    /**
     * Avslutar programmet
     */
    //ToDo: Skapa en metod som avslutar programmet genom att göra loopen falsk och ge ett tack-meddelande för användaren.
    private void exitProgram() {
        ongoing = false;
        System.out.println("Thank you for using the Student Management System!");
    }
}
