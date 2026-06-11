// Create a Student class with:
// Attributes: name (String), marks (int array of 3 subjects)
// Methods:
// calculateAverage() → returns average of 3 marks
// getGrade() → returns grade as String (A/B/C/D/F)
// display() → prints name, marks, average, grade
// In main: create 2 students and display their details

import java.util.Arrays;

class Student {

    String name;
    int[] marks = new int[3];

    float calculateAverage() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += marks[i];
        }
        return sum / 3.0f;
    }

    String getGrade() {
        double avg = calculateAverage();
        return avg >= 90 ? "A" : avg >= 80 ? "B" : avg >= 70 ? "C" : avg >= 60 ? "D" : "F";
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Marks: " + Arrays.toString(marks));
        System.out.println("Average: " + calculateAverage());
        System.out.println("Grade: " + getGrade());
        System.out.println();
    }

}

public class StudentTracker {
    public static void main(String[] args) {

        Student s1, s2;
        s1 = new Student();
        s2 = new Student();

        s1.name = "Ajay";
        s1.marks = new int[] { 80, 60, 100 };
        s2.name = "Vijay";
        s2.marks = new int[] { 79, 96, 54 };

        s1.display();
        s2.display();
    }
}
