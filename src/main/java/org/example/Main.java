package org.example;

import com.google.gson.Gson;
import org.example.enums.StudentComparators;
import org.example.enums.StudyProfile;
import org.example.enums.UniversityComparators;
import org.example.students.Student;
import org.example.students.StudentsComp;
import org.example.university.University;
import org.example.university.UniversityComp;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Получение коллекций и сортировка:\n");
        List<Student> students1 = FileWork.readStudents();
        StudentsComp comp1 = EnumWork.getMyComparatorStudent(StudentComparators.STUDENT_COMPARATOR_FULL_NAME);

        //сортировка коллекции students1
        students1 = students1.stream().sorted(comp1).collect(Collectors.toList());

        //вывод в консоль всех элементов коллекции
        students1.forEach(System.out::println);

        System.out.println("---");

        List<University> universities1 = FileWork.readUniversities();
        UniversityComp comp2 = EnumWork.getMyComparatorUniversity(UniversityComparators.UNIVERSITY_COMPARATOR_ID);

        //сортировка коллекции universities1
        universities1 = universities1.stream().sorted(comp2).collect(Collectors.toList());

        //вывод в консоль всех элементов коллекции
        universities1.forEach(System.out::println);

        System.out.println("---");

        //Задание "27.8. Проект"
        UtilStudentUniversities.statisticsMethod(students1, universities1).forEach(System.out::println);
        String path = "statistic.xls";
        XlsWriter.excelFile(UtilStudentUniversities.statisticsMethod(students1, universities1), path);
    }
}