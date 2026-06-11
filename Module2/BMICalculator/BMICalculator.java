// Write an interactive program that:
// Asks user for name, weight (kg), height (m)
// Calculates BMI = weight / (height × height)
// Displays result formatted to 2 decimal places
// Prints category: Underweight(<18.5) / Normal(18.5-24.9) / Overweight(≥25)

import java.util.Scanner;

class Person {
    private String name;
    private double weight;
    private double height;

    Person(String name, double weight, double height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    double calculateBMI() {
        return weight / (height * height);
    }

    String getCategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else {
            return "Overweight";
        }
    }

    void displayResult() {
        double bmi = calculateBMI();
        System.out.printf("The BMI of %s is %.2f%n", name, bmi);
        System.out.println("Category: " + getCategory());
    }
}

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        System.out.print("Enter weight (kg): ");
        double weight = sc.nextDouble();

        System.out.print("Enter height (m): ");
        double height = sc.nextDouble();

        Person p = new Person(name, weight, height);

        p.displayResult();

        sc.close();
    }
}