package com.studentapp;

import java.util.*;

public class Main4 {
    private static List<Student> studentList;
    private static Scanner scanner;
    private static Student student;

    public static void main(String[] args) {
        System.out.println("** Student Management System **");
        System.out.println("** Welcome **");
        scanner=new Scanner(System.in);
        studentList=new ArrayList<Student>();
        while(true) {
            System.out.println("Select an option..");
            System.out.println("1. Register a student");
            System.out.println("2. Find Student with student id");
            System.out.println("3. List all student information");
            System.out.println("4. List all student information in sorted order");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    registerNewStudent(scanner);
                    break;

                case 2:
                    findStudentWithId(scanner);
                    break;

                case 3:
                    listallStudentsInfo();
                    break;

                case 4:
                    listallStudentsInfoInSortOrder();
                    break;

                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid option between 1-5");


            }
        }

    }



    private static void listallStudentsInfo() {
        if(!studentList.isEmpty()) {
            for (Student stu : studentList) {
                stu.printStudentInfo();
            }
        }else{
            System.err.println("No student records found");
        }

    }

    private static void listallStudentsInfoInSortOrder() {
        if(!studentList.isEmpty()) {
            Comparator<Student> comparator = new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            };
            Collections.sort(studentList, comparator);
            for (Student stu : studentList) {
                stu.printStudentInfo();
            }
        }else{
            System.err.println("No student records found");
        }
    }

    private static void findStudentWithId(Scanner scanner) {
        System.out.println("Enter student id to search");
        String id= scanner.next();
        for(Student stu:studentList){
            if (stu.getStudentId().equalsIgnoreCase(id)){
                System.out.println("Student with "+id+" is present");
                stu.printStudentInfo();
            }else{
                System.err.println("Student with "+id+" is not present");
            }
        }

    }

    private static void registerNewStudent(Scanner scanner) {
        System.out.println("Enter name");
        String name =scanner.next();
        System.out.println("Enter age");
        int age =scanner.nextInt();
        System.out.println("Enter Student Id");
        String studentID=scanner.next();
        student=new Student(name,age ,studentID);
        while(true) {
            System.out.println("Enter course name.. type done if no more course enrollment is reuired");
            String courseName = scanner.next();
            if(courseName.equalsIgnoreCase("done")){
                break;
            }else {
                student.enrollCourse(courseName);
            }
        }
        studentList.add(student);
        student.printStudentInfo();

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
