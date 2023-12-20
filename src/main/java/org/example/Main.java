package org.example;

import org.example.enums.StudentComparators;
import org.example.enums.UniversityComparators;
import org.example.students.Student;
import org.example.students.StudentsComp;
import org.example.university.University;
import org.example.university.UniversityComp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = FileWork.readStudents();
        StudentsComp comp1 = EnumWork.getMyComparatorStudent(StudentComparators.STUDENT_COMPARATOR_FULL_NAME);
        students.stream().sorted(comp1).forEach(System.out::println);

        System.out.println("---");

        List<University> universities = FileWork.readUniversities();
        UniversityComp comp2 = EnumWork.getMyComparatorUniversity(UniversityComparators.UNIVERSITY_COMPARATOR_ID);
        universities.stream().sorted(comp2).forEach(System.out::println);
    }
}