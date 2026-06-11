// A console-based Student Record Management System that lets you add, display, search, and analyze student records 

import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double[] marks = new double[5];
    private String grade;
    private double average;

    Student(String name, int rollNumber, double[] marks){
        this.name = name;
        this.rollNumber = rollNumber;
        for (int i = 0; i < 5; i++) {
            this.marks[i] = marks[i];
        }
        assignGrade();
    }

    private void calculateAverage (){
        double sum = 0.0;
        for (int i = 0; i<5; i++){
            sum+=marks[i];
        }
        average = (double)sum/5;
    }

    private void assignGrade(){
        calculateAverage();
        if (average >= 90) {
            grade = "A+";
        }else if (average >= 80) {
            grade = "A";
        }else if (average >= 70) {
            grade = "B";
        }else if (average >= 60) {
            grade = "C";
        }else if (average >= 50) {
            grade = "D";
        }else if (average >= 40) {
            grade = "E";
        }else{
            grade = "F";
        }
    }

    public void displayInfo() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.printf( "║ Roll No : %-30d║%n", rollNumber);
        System.out.printf( "║ Name    : %-30s║%n", name);
        System.out.print(  "║ Marks   : ");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-5.1f ", marks[i]);
        }
        System.out.printf("║%n");
        System.out.printf( "║ Average : %-30.2f║%n", average);
        System.out.printf( "║ Grade   : %-30s║%n", grade);
        System.out.println("╚═════════════════════════════════════════╝");
    }

    String getName(){
        return name;
    }

    String getGrade () {
        return grade;
    }

    int getRollNumber() {
        return rollNumber;
    }

    double getAverage(){
        return average;
    }
}

class StudentManager {
    
    private Student[] stud;
    private int count;
    private static final int MAX_COUNT = 75;  

    private static int totalCount = 0;
    public static int getTotalStudents() {
        return totalCount;
    }

    StudentManager() {
        stud = new Student[MAX_COUNT];
        count = 0;
    }

    void addStudent(Student s){
        if (count < MAX_COUNT){
            stud[count] = s;
            count++;
            totalCount++;
        }else{
            System.out.println("Student limit reached");
        }
    }

    public void displayAll(){
        if (count == 0 ){
            System.out.println("✗ No students found.\n");
        }else{
            for (int i = 0; i < count; i++){
                stud[i].displayInfo();
            }
        }
    }

    boolean isValidRollNumber(int rollNumber) {
        if (rollNumber <= 0 || rollNumber > 75) {
            System.out.println("✗ Roll number must be between 1 and 75.");
            return false;
        }

        for (int i = 0; i < count; i++) {
            if (stud[i] != null && stud[i].getRollNumber() == rollNumber) {
                System.out.println("✗ Roll number already exists!");
                return false;
            }
        }
        return true;
    }


    void searchStudent(String name) {
        boolean notExist = true;
        for (int i = 0; i < count; i++){
            if (stud[i].getName().equalsIgnoreCase(name)){
                stud[i].displayInfo();
                notExist = false;
            }
        }
        if (notExist){System.out.printf("✗ Student \"%s\" not found.\n\n", name);}
    }

    void displayStatistics() {
        if (count == 0) {
            System.out.println("No data available.");
            return;
        }    

        double max = stud[0].getAverage();
        double min = stud[0].getAverage();
        double avg = 0;

        int maxInd = 0, minInd = 0;
        int aa = 0, a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;

        for (int i = 0; i < count; i++) {
            double currentAvg = stud[i].getAverage();
            String grade = stud[i].getGrade();

            if (currentAvg > max) {
                max = currentAvg;
                maxInd = i;
            }
            if (currentAvg < min) {
                min = currentAvg;
                minInd = i;
            }

            avg += currentAvg;

            switch (grade) {
                case "A+": aa++; break;
                case "A":  a++;  break;
                case "B":  b++;  break;
                case "C":  c++;  break;
                case "D":  d++;  break;
                case "E":  e++;  break;
                default:   f++;
            }
        }

        avg /= count;

        System.out.println("╔═════════════════════════════════════════════════════╗");
        System.out.printf ("║ Highest : %-30s - %-8.2f ║\n",stud[maxInd].getName(), max);
        System.out.printf ("║ Lowest  : %-30s - %-8.2f ║\n",stud[minInd].getName(), min);
        System.out.printf ("║ Average : %-41.2f ║\n", avg);
        System.out.printf ("║ Grades  : A+:%-3d A:%-3d B:%-3d C:%-3d D:%-3d E:%-3d F:%-3d║\n",aa, a, b, c, d, e, f);
        System.out.println("╚═════════════════════════════════════════════════════╝");

    }

}


public class StudentRecordManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        
        int choice = 1;
        String name;
        int rollNumber;
        double[] marks = new double[5];

        do{

            System.out.println();
            System.out.println("\t╔═════════════════════════════════════╗");
            System.out.printf ("\t║     STUDENT MANAGEMENT SYSTEM (%d)   ║%n",StudentManager.getTotalStudents());
            System.out.println("\t╠═════════════════════════════════════╣");
            System.out.println("\t║  1. ➤ Add Student                   ║");
            System.out.println("\t║  2. ➤ Display All Students          ║");
            System.out.println("\t║  3. ➤ Search Student                ║");
            System.out.println("\t║  4. ➤ Class Statistics              ║");
            System.out.println("\t║  5. ➤ Exit                          ║");       
            System.out.println("\t╚═════════════════════════════════════╝");
            System.out.print("\n➤ Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("\n────────── ADD NEW STUDENT ──────────");

                    System.out.print("➤ Enter student name       : ");
                    name = sc.nextLine();
                    do {
                        System.out.print("➤ Enter roll number (1–75): ");
                        rollNumber = sc.nextInt();

                    } while (!manager.isValidRollNumber(rollNumber));

                    for (int i = 0; i < 5; i++){
                        System.out.printf("➤ Enter mark for subject %d : ", i+1);
                        marks[i] = sc.nextDouble();
                        if (marks[i] > 100 || marks[i] < 0){
                            System.out.println("✗ Invalid! Marks must be between 0 and 100.");
                            i--;
                        }
                    }

                    sc.nextLine();

                    Student s = new Student(name, rollNumber, marks);
                    manager.addStudent(s);

                    System.out.println("✓ Student added successfully!\n");

                    break;

                case 2:

                    System.out.println("\n────────── STUDENT LIST ──────────");

                    manager.displayAll();

                    break;

                case 3:

                    System.out.println("\n────────── SEARCH STUDENT ──────────");

                    System.out.print("➤ Enter name to search: ");
                    name = sc.nextLine();
                    manager.searchStudent(name);

                    break;

                case 4:
                    
                    System.out.println("\n────────── CLASS STATISTICS ──────────");

                    manager.displayStatistics();

                    break;

                case 5:

                    System.out.println("\n✓ Exiting system... Goodbye!\n");

                    break;

                default:
                    System.out.println("✗ Invalid choice! Please try again.\n");
            }
        } while (choice != 5);
        
        sc.close();
    }
}