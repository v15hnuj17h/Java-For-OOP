package studentapp.manager;

import studentapp.model.Student;
import studentapp.exceptions.InvalidRollNumberException;


public class StudentManager {
    
    private Student[] stud;
    private int count;
    private static final int MAX_COUNT = 75;  

    private static int totalCount = 0;
    public static int getTotalStudents() {
        return totalCount;
    }

    public StudentManager() {
        stud = new Student[MAX_COUNT];
        count = 0;
    }

    public void addStudent(Student s){
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

    public void validateRollNumber(int rollNumber)
            throws InvalidRollNumberException {

        if (rollNumber <= 0 || rollNumber > 75) {
            throw new InvalidRollNumberException(
                "Roll number must be between 1 and 75. Got: " + rollNumber);
        }

        for (int i = 0; i < count; i++) {
            if (stud[i] != null && stud[i].getRollNumber() == rollNumber) {
                throw new InvalidRollNumberException(
                    "Roll number " + rollNumber + " already exists!");
            }
        }
    }

    public void searchStudent(String name) {
        boolean notExist = true;
        for (int i = 0; i < count; i++){
            if (stud[i].getName().equalsIgnoreCase(name)){
                stud[i].displayInfo();
                notExist = false;
            }
        }
        if (notExist){System.out.printf("✗ Student \"%s\" not found.\n\n", name);}
    }

    public void displayStatistics() {
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