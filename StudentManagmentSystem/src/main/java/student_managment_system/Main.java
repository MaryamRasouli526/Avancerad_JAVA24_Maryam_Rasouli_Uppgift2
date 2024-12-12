package student_managment_system;

import file_management.FileHandler;

/**
 * Klassen är till för instansiera klassen för filhanteringen och anropa skapandet av filen.
 *
 * Ytterligare är den till för att instansiera menyn och anropa körandet av menyn.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @since 2024-12-08
 * @see FileHandler,Student,StudentMenu,StudentManagment
 */

public class Main {
    public static void main(String[] args) {
        //ToDo: Instansiera klassen FileHandler som hanterar filen.
        FileHandler fileHandler = new FileHandler();
        //ToDo: Anropa metoden som skapar filen i FileHandler klassen.
        fileHandler.createFile();


        //ToDo: Välkomna användaren av systemet.
        System.out.println("Welcome to the Student Management System!");

        //ToDo: Skapa instansieringen av klassen där menyn finns för systemet.
        StudentMenu menu = new StudentMenu();
        //ToDo: Anropa metoden som kör menyn i StudentMenu klassen.
        menu.runMenu();

    }
}
