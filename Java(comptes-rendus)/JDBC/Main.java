package JDBC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student {
    private int id;
    private String firstName;
    private String cin;
    private List<Double> grades;

    public Student(int id, String firstName, String cin, List<Double> grades) {
        this.id = id;
        this.firstName = firstName;
        this.cin = cin;
        this.grades = grades;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public double getMaxGrade() {
        return grades.stream().max(Double::compare).orElse(0.0);
    }

    public double getAverage() {
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}

class Classroom {
    private int number;
    private String level;
    private String major;
    private List<Student> studentList;

    public Classroom(int number, String level, String major) {
        this.number = number;
        this.level = level;
        this.major = major;
        this.studentList = new ArrayList<>();
    }

    // Getters and setters

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public void displayStudentList() {
        for (Student student : studentList) {
            System.out.println("ID: " + student.getId() +
                    ", First Name: " + student.getFirstName() +
                    ", CIN: " + student.getCin());
        }
    }

    public List<Student> studentsWithAverageAbove12() {
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getAverage() > 12.0) {
                result.add(student);
            }
        }
        return result;
    }

    public double calculateClassAverage() {
        double totalAverage = 0.0;
        for (Student student : studentList) {
            totalAverage += student.getAverage();
        }
        return totalAverage / studentList.size();
    }
}

public class Main {
    public static void main(String[] args) {
        // Testing the class with two students in Telecommunications Engineering
        Classroom telecomEngineeringClass = new Classroom(2, "Bachelor", "Telecommunications Engineering");

        Student student1 = new Student(1, "wissem", "14582968", List.of(15.0, 14.0, 16.0));
        Student student2 = new Student(2, "ahmed", "12457896", List.of(12.0, 13.0, 14.0));

        telecomEngineeringClass.addStudent(student1);
        telecomEngineeringClass.addStudent(student2);

        // Display the list of students
        System.out.println("List of students:");
        telecomEngineeringClass.displayStudentList();

        // Display the list of students with an average above 12
        System.out.println("\nStudents with an average above 12:");
        List<Student> studentsAbove12Average = telecomEngineeringClass.studentsWithAverageAbove12();
        for (Student student : studentsAbove12Average) {
            System.out.println("ID: " + student.getId() +
                    ", First Name: " + student.getFirstName() +
                    ", CIN: " + student.getCin() +
                    ", Average: " + student.getAverage());
        }

        // Calculate the class average
        double classAverage = telecomEngineeringClass.calculateClassAverage();
        System.out.println("\nClass average: " + classAverage);
    }
}
