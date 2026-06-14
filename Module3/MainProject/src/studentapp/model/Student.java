package studentapp.model;

import studentapp.exceptions.InvalidMarksException;

public class Student {
    private String name;
    private int rollNumber;
    private double[] marks = new double[5];
    private String grade;
    private double average;

    public Student(String name, int rollNumber, double[] marks) throws InvalidMarksException {
        this.name = name;
        this.rollNumber = rollNumber;
        for (int i = 0; i < 5; i++) {
            if (marks[i]<0 || marks[i]>100){
                throw new InvalidMarksException("Mark for subject-"+ (i+1) +" is invalid: "+ marks[i] + " (must be 0-100)");
            }
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

    public String getName(){
        return name;
    }

    public String getGrade () {
        return grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getAverage(){
        return average;
    }
}