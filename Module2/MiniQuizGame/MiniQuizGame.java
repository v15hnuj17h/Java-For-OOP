// Write a program that:
// Asks the user 3 simple math questions (hardcoded)
// Takes their answers as input
// Checks each answer and gives +10 for correct
// At the end prints their score and a grade

import java.util.Scanner;

class Mark {
    private int mark;
    private char grade;

    Mark(int mark) {
        this.mark = mark;
        calculateGrade();
    }

    private void calculateGrade() {
        if (mark == 30) {
            grade = 'A';
        } else if (mark == 20) {
            grade = 'B';
        } else if (mark == 10) {
            grade = 'C';
        } else {
            grade = 'D';
        }
    }

    void displayResult() {
        System.out.printf("Marks: %d\tGrade: %c%n", mark, grade);
    }
}

public class MiniQuizGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mark = 0;

        System.out.print("1) Which number is the only even prime number? ");
        int ans1 = sc.nextInt();
        if (ans1 == 2) {
            mark += 10;
        }

        System.out.print("2) What is the probability of getting head in an unbiased coin? ");
        double ans2 = sc.nextDouble();
        if (ans2 == 0.5) {
            mark += 10;
        }

        sc.nextLine();

        System.out.print("3) Name the branch of mathematics developed by Isaac Newton? ");
        String ans3 = sc.nextLine().toLowerCase();
        if (ans3.equals("calculus")) { 
            mark += 10;
        }

        Mark m = new Mark(mark);
        m.displayResult();

        sc.close();
    }
}