// Write a program that:
// Has variables: marks (int) and attendance (int)
// Uses logical operators to check: marks ≥ 50 AND attendance ≥ 75
// Uses ternary operator to assign grade (A/B/C/D/F)
// Prints eligibility and grade

public class GradeCalculator{
    public static void main(String[] args){

        int marks = 65;
        int attendance = 85;

        String eligibility = marks>=50 && attendance>=75 ? "is eligible to write exam." : "is not eligible to write the exam.";
        char grade = marks>=90 ? 'A':
                     marks>=80 ? 'B':
                     marks>=70 ? 'C':
                     marks>=60 ? 'D':
                     marks>=50 ? 'F':'E';
                     
        System.out.println("The student"+eligibility);
        System.out.println("Grade: "+ grade);
    }
}