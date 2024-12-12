package file_management;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import student_managment_system.Student;
import student_managment_system.StudentManagment;

/**
 * Klassen är till för att skapa filen, spara studentposter i filen och för att läsa från filen.
 *
 * Dessutom hanterar de fel som kan uppstå med filhantering.
 *
 @author Maryam Rasouli
 @version 1.0
 @since 2024-12-08
 @see student_managment_system.Main,Student,StudentManagment,student_managment_system.StudentMenu
 */

public class FileHandler {
//ToDo: Ha en parameterlös konstruktor då du behöver inga privata attribut i denna klassen. Den skapas som default av intelliJ.
    public FileHandler() {}

    /**
     * Skapar mappen "Files" med filen "students.txt" om den inte redan finns.
     */
    //ToDo: Skapa en klass för att skapa filen där studentposter sparas i
    public void createFile() {
     //ToDo: Använd try-catch-block för att fånga fel vid filhantering.
        try {
            File directory = new File("Files"); // ToDo: Skapa File-objekt och ange sökvägen namn till "Files".
            if (!directory.exists()) { //ToDo: Gör en if-sats och kontrollera om sökvägen inte extsterar.
                directory.mkdir(); // ToDo: Skapa mappen "Files" om den inte redan finns.
            }

            File file = new File(directory, "students.txt");// ToDo: Skapa File-objekt som hänvisar till  sökvägen  och skapa filen vid namn "students.txt".
            if (!file.exists()) { //ToDo: if-sats som kontrollerar om filen inte existerar.
                file.createNewFile(); //ToDo: Skapa då filen om den inte redan finns.
                System.out.println("File created: " + file.getAbsolutePath()); //ToDo: Skriv i output att filen skapas och hela sökvägen.
            }
        } catch (IOException e) { //ToDo: Fånga fel vid filhantering genom catch.
            System.out.println("An error occurred while creating the file: " + e.getMessage()); //ToDo: Skriv då ett meddelande om ett fel inträffade och visa då felmeddelande.
        }
    }

    /**
     * Sparar studentposter till filen students.txt.
     * @param file är filen (students.txt) där studentposter sparas i.
     * @param students är namnet på HashMap som tar emot elevens information.
     */
    public static void saveItToFile(String file, HashMap<String, Student> students) { //ToDo: Skapa en metod som sparar studentposter till student.txt genom att ta emot filen och elevens information.
        //ToDo: Skapa en try-catch block som skirver studentposter till filen och fångar fel vid sparandet av dem i filen.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Files/" + file))) { //ToDo: Skapa BufferedWriter-objektet för att kunna få texten i filen.
            for (Map.Entry<String, Student> entry : students.entrySet()) { //ToDo: Skapa en enhanced for-loop som  loopar igenom HashMapen/studenposter.
                writer.write(entry.getKey() + "," + entry.getValue().getName() + "," + entry.getValue().getGrade()); //ToDo: Skriv in key som är Id och value som är namnet och betyget i filen.
                writer.newLine();// ToDo: Lägg till radbrytning till filen.
            }
            System.out.println("Students saved to file.");//ToDo: Skriv i output att eleven har sparats  till filen
        } catch (IOException e) { //ToDo: Fånga fel vid filhantering och skriv sedan ett felmeddelande.
            System.out.println("An error occurred while saving to file: " + e.getMessage());
        }
    }

    /**
     * Läser studentposter från filen
     * @param file är filen (student.txt) där studentposter sparas i.
     * @param studentManagment är objektnamnet på klasses där studenthanteringen sker.
     */
    //ToDo: Skapa en klass som läser studentposter från filen
    public static void readFromFile(String file, StudentManagment studentManagment) {
        //ToDo: Skapa en BufferedReader-objekt som läser studentposter i filen.
        try (BufferedReader reader = new BufferedReader(new FileReader("Files/" + file))) {
            String line; //ToDo: Skapa variabeln line för kunna läsa rad från rad i filen.

            //ToDo: Skapa en while-loop för att köra den om raden inte innehåller null (alltså ska det finnas text i raden).
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");//ToDo: Används regex för att dela på strängen.
                if (parts.length == 3) { // ToDo: Skapa en if-sats som kontrollerar om texten är delad i tre delar för id, namn och betyg.
                    //ToDo: Då lägg varje del i en HashMap som finns i metoden putStudentInMap i StudentManagment klassen.
                    studentManagment.putStudentInMap(parts[0].trim(), parts[1].trim(), parts[2].trim());//ToDo: Skicka varje del av strängen som parameter till metoden och trimma bort de andra delarna.
                }
            }
            //ToDo: Skriv en text till användaren när laddas från filen.
            System.out.println("Students loaded from file.");
        } catch (IOException e) { //ToDo: Fånga fel som sker när studentposter läses från filen.
            System.out.println("An error occurred while reading from file: " + e.getMessage());
        }
    }
}
