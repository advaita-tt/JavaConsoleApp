package com.studentapp;

public class Main {
    public static void main(String[] args) {
        System.out.println("** Student Management System **");
        System.out.println("** Welcome **");

        Student s1= new Student("kajal",34,"S-1234");
        s1.enrollCourse("Python");
        s1.enrollCourse("java");
        s1.enrollCourse("Playwright");
        s1.printStudentInfo();

        Student s2= new Student("uday",21,"S-2345");
        s2.enrollCourse("Python");
        s2.enrollCourse("java");
        s2.printStudentInfo();

        Student s3= new Student("Ritu",22,"S-45");
        s3.enrollCourse("Devops");
        s3.enrollCourse("java");
        s3.printStudentInfo();


    }
}
