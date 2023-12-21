package org.example;

import com.google.gson.Gson;
import org.example.enums.StudentComparators;
import org.example.enums.UniversityComparators;
import org.example.students.Student;
import org.example.students.StudentsComp;
import org.example.university.University;
import org.example.university.UniversityComp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Получение коллекций и сортировка:\n");
        List<Student> students1 = FileWork.readStudents();
        StudentsComp comp1 = EnumWork.getMyComparatorStudent(StudentComparators.STUDENT_COMPARATOR_FULL_NAME);

        //сортировка коллекции
        students1 = students1.stream().sorted(comp1).collect(Collectors.toList());

        //вывод в консоль всех элементов коллекции
        students1.forEach(System.out::println);

        System.out.println("---");

        List<University> universities1 = FileWork.readUniversities();
        UniversityComp comp2 = EnumWork.getMyComparatorUniversity(UniversityComparators.UNIVERSITY_COMPARATOR_ID);

        //сортировка коллекции
        universities1 = universities1.stream().sorted(comp2).collect(Collectors.toList());

        //вывод в консоль всех элементов коллекции
        universities1.forEach(System.out::println);

        System.out.println("---");

        System.out.println("\nСериализация\n");

        //Сериализация
        String studentsAfterSerialize = JsonUtil.serializeListStudent(students1);
        System.out.println(studentsAfterSerialize);

        System.out.println("---");

        String universitiesAfterSerialize = JsonUtil.serializeListUniversity(universities1);
        System.out.println(universitiesAfterSerialize);

        System.out.println("\nДесериализация:\n");

        //Десериализация
        List<Student> students2 = JsonUtil.deserializeListStudent(studentsAfterSerialize);
        students2.stream().forEach(System.out::println);

        System.out.println("---");

        List<University> universities2 = JsonUtil.deserializeListUniversity(universitiesAfterSerialize);
        universities2.stream().forEach(System.out::println);

        System.out.println("\nСравнение кол-ва объектов до и после сериализации:\n");
        long count1 = students1.stream().count();
        System.out.println("Кол-во объектов в students до сериализации: " + count1);
        long count2 = students2.stream().count();
        System.out.println("Кол-во объектов в students после десериализации: " + count2);

        System.out.println("---");

        long count3 = universities1.stream().count();
        System.out.println("Кол-во объектов в universities до сериализации: " + count3);
        long count4 = universities2.stream().count();
        System.out.println("Кол-во объектов в universities до сериализации: " + count4);

        //Сериализация отдельных объектов в исходной коллекции:
        System.out.println("Выполним сериализацию и десериализацию элементов students1 в stream: ");
        students1.forEach(student -> {
            String serStud = JsonUtil.serializeStudent(student);
            System.out.println(serStud);
            Student student1 = JsonUtil.deserializeStudent(serStud);
            System.out.println(student1);
        });

        System.out.println("Выполним сериализацию и десериализацию элементов universities1 в stream: ");
        universities1.forEach(university -> {
            String serUni = JsonUtil.serializeUniversity(university);
            System.out.println(serUni);
            University university1 = JsonUtil.deserializeUniversity(serUni);
            System.out.println(university1);
        });
    }
}