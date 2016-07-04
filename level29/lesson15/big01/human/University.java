package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double value) {
        for (Student student : students) {
            if (student.getAverageGrade() >= value) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        if (students.size() > 0) {
            int index = 0;
            double maxValue = students.get(0).getAverageGrade();
            for (int i = 1; i < students.size(); i++) {
                Student student = students.get(i);
                double value = student.getAverageGrade();
                if (value > maxValue) {
                    index = i;
                    maxValue = value;
                }
            }
            return students.get(index);
        }
        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        if (students.size() > 0) {
            int index = 0;
            double minValue = students.get(0).getAverageGrade();
            for (int i = 1; i < students.size(); i++) {
                Student student = students.get(i);
                double value = student.getAverageGrade();
                if (value < minValue) {
                    index = i;
                    minValue = value;
                }
            }
            return students.get(index);
        }
        return null;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}