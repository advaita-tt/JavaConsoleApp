package com.studentapp;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Student {
    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                '}';
    }

    public Student(String name, int age, String studentId) {
        if(validateAge(age) && validateName(name) && validateStudentId(studentId)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<String>(); //initialization of courses
        }
    }

    private boolean validateStudentId(String studentId) {
        String studentRegex="S-\\d+$";
        Pattern studentPattern=Pattern.compile(studentRegex);
        Matcher matcher=studentPattern.matcher(studentId);
        if(matcher.matches()){
            return true;
        }else{
            System.err.println("Invalid ID");
            return false;
        }


    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void enrollCourse(String course){
        if(validateCourseName(course)){
            if(!courses.contains(course)) {
                courses.add(course);
                System.out.println("Student is enrolled to " + course + " successfully");
            }else{
                System.err.println("Student is already enrolled to the course: "+course);
            }
        }
    }


    public boolean validateCourseName(String courseName){
        boolean isValid=false;

        if(courseName.equalsIgnoreCase("Java") ||
                courseName.equalsIgnoreCase("Devops") ||
                courseName.equalsIgnoreCase("Python")){
            isValid =true;

        }else{
            System.err.println("Invalid course name :"+courseName);
        }
        return isValid;

    }
    public void printStudentInfo(){
        System.out.println("============ Student Data ==============");
        System.out.println("Student name: "+ name);
        System.out.println("Student age: "+ age);
        System.out.println("Student id: "+ studentId);
        System.out.println("Student courses: "+ courses);
    }

    public boolean validateAge(int age){
        if(age>=19 && age<=40){
            return true;
        }else{
            System.err.println("wrong age");
            return false;
        }
    }

    public boolean validateName(String name){
        String nameRegex="^[a-zA-Z\\s]+$";
        Pattern namePattern= Pattern.compile(nameRegex);
        Matcher nameMatcher= namePattern.matcher(name);
        if (nameMatcher.matches()){
            return true;
        }else{
            System.err.println("Invalid name");
            return false;
        }

    }

}
