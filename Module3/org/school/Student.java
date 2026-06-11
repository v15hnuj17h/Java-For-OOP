package org.school;

public class Student{

    private String name;
    private int roll;

    public Student (String name,int roll) {
        this.name = name;
        this.roll = roll;
    }

    public void displayInfo(){
        System.out.println("Name: "+ name);
        System.out.println("Roll Number: "+ roll);
    }
}