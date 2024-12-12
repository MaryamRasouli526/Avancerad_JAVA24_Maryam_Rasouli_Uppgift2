package student_managment_system;

/**
 * Klassen är till för att hantera namn och betyg för en student.
 *
 * KLassen hämtar namn och betyg och retunerar dem.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @since 2024-12-08
 * @see file_management.FileHandler,Main,StudentManagment,StudentMenu
 */

public class Student {
    //ToDo: Skapa två private egenskaper för namn och betyg.
    private String name;
    private String grade;

    //ToDo: Klassens konstruktor ska ta in namnet och betyget som är privata.
    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
    //ToDo: Skapa getters för att hämta namn och betyg
    /**
     * Hämtar namnet
     * @return name som är namnet på eleven
     */
    public String getName() {
        return name;
    }

    /**
     * Hämtar betyget
     * @return grade som är elevens betyg
     */
    public String getGrade() {
        return grade;
    }

}
