package com.studentapp;

import java.util.*;

public class Main2 {
    static List<Student> studentList;
    public static void main(String[] args) {
        System.out.println("** Student Management System **");
        System.out.println("** Welcome **");

        studentList =new ArrayList<Student>();

        Student s1= new Student("Kajal",34,"S-1234");
        s1.enrollCourse("Python");
        s1.enrollCourse("java");
        s1.enrollCourse("Playwright");

        Student s2= new Student("Uday",21,"S-2345");
        s2.enrollCourse("Python");
        s2.enrollCourse("java");

        Student s3= new Student("Ritu",22,"S-45");
        s3.enrollCourse("Devops");
        s3.enrollCourse("java");

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        findStudentById("S-234343");
        sortByStudentName();

    }

    private static void sortByStudentName() {
        Comparator<Student> studentComparator=(o1,o2) ->o1.getName().compareTo(o2.getName());

        Collections.sort(studentList,studentComparator);
        System.out.println(studentList);
    }

    public static void findStudentById(String studentId){
        try {
            studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No student data found"));
        } catch (RuntimeException e) {
            System.err.println("Student with ID "+studentId+ " is not present");
        }
    }
}
