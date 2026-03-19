package com.studentapp;

import java.io.InputStream;
import java.util.*;

public class Main3 {
    static List<Student> studentList;
    public static void main(String[] args) {
        System.out.println("** Student Management System **");
        System.out.println("** Welcome **");
        System.out.println("Enter name");
        Scanner scanner=new Scanner(System.in);
        String name= scanner.next();
        System.out.println("name is : "+name);


        System.out.println("Enter age");
        int age= scanner.nextInt();
        System.out.println("age is : "+age);


    }


}
