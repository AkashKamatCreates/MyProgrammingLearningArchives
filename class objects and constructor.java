package org.example;

public class Main {
    public static void main(String[] args) {

        student student1 = new student(1, "akash", 90);
        //below 3 lines are when no constructor in place.
//        student1.roll = 1;
//        student1.name= "akash";
//        student1.marks=90;
        System.out.println(student1);

    }
}

public class student {
    int roll;
    String name;
    int marks;

    student(int roll, String name, int marks){
        this.roll = roll;
        this.name = name;
        this.marks = marks;
}

