package student_managment_system;

import java.util.HashMap;
import java.util.Map;

/**
 * Klassen är till för att hantera information om eleverna.
 *
 * Klassen använder Singleton-mönstret för att skapa en instans av denna klass.
 *
 * Klassen tillhandahåller metoder för att hämta instansen, lägga elev-informationen i en HashMap, hämta eleven genom id och visa alla elever.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @since 2024-12-08
 * @see file_management.FileHandler,Main,Student,StudentManagment
 */

public class StudentManagment {
    //ToDo: Skapa en privat och statisk attribut av klassen med namnet instance för singleton-mönstret.
    private static StudentManagment instance;
    private HashMap<String, Student> students; // ToDo: Skapa en HashMap som har String som key men Klassen Student (med namn och betyg) som value.

    private StudentManagment() {
        //ToDo: Instansiera HashMapen i konstruktorn.
        students = new HashMap<>();
    }

    /**
     * Hämtar instans och ser till att bara en instans av klassen skapas.
     * @return instance vilket är instansen av denna klass.
     */
    //ToDo: Skapa en klass som hämtar instansen.
    public static StudentManagment getInstance() {
        if(instance == null) { // ToDo: Se till att bara en instans skapas.
            instance = new StudentManagment();
        }
        return instance;
    }

    /**
     * Lägger informationen om en elev i HashMapen students
     * @param id är id för eleven
     * @param name är elevens namn
     * @param grade är elevens betyg
     */
    //ToDo: Skapa en klass som lägger elevens id,namn och betyg i en HashMap
    public void putStudentInMap(String id, String name, String grade) {
        Student student = new Student(name, grade); //ToDo: Skapa ett Student-objekt och skicka namn och betyg som parameter.
        students.put(id, student); //ToDo: lägg id och namn och betyg i map. Namn och betyg ska utgöra värdet.
    }

    /**
     * Hämta eleven genom id
     * @param id är värdet
     * @return students.get(id) vilket retunerar värdet som är namn och betyg.
     */
    //ToDo: Skapa en metod som genom id som är nyckel retunerar värdet vilket är namn och betyg. För att hitta en elev genom id.
    public Student getStudentById(String id) {
        return students.get(id); // Hämtar studenten baserat på ID
    }

    /**
     * Visar alla studenter i systemet.
     */
    // ToDo: Skapa en metod som visar alla studenter i systemet.
    public void showAllStudents() {
        if (!students.isEmpty()) { // ToDo: Skapa en if-sats som kontrollerar om HashMapen som innehåller information om eleven är inte tom.
            for (Map.Entry<String, Student> entry : students.entrySet()) { //ToDo: Då skapa en enhanced for-loop som itererar över key och value som betår av id och namn och betyg.
                System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Grade: " + entry.getValue().getGrade());
            }
        } else { // ToDo: Gör ett else-block om det inte finns elever i map. Visa detta för användaren
            System.out.println("There are no students in the system.");
        }
    }

    /**
     * Hämta eleverna i students HashMapen.
     * @return students
     */
    //ToDo: Skapa en HashMap som hämtar eleverna i HashMapen.
    public HashMap<String, Student> getStudents() {
        return students;
    }
}
