package org.example;

import org.example.classesForUtil.Statistics;
import org.example.classesForUtil.XmlClass;
import org.example.enums.StudentComparators;
import org.example.enums.UniversityComparators;
import org.example.students.Student;
import org.example.students.StudentsComp;
import org.example.transfromation.*;
import org.example.university.University;
import org.example.university.UniversityComp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        logger.info("Happy to see you!");
        System.out.println("Получение коллекций и сортировка:\n");

        //Сериализация коллекций при помощи общего метода toSerializeCollection:
        List<Student> students = FileWork.readStudents();
        String lineStudents = JsonUtil.collectionToJson(students);
        System.out.println(lineStudents);

        List<University> universities = FileWork.readUniversities();
        String lineUniversities = JsonUtil.collectionToJson(universities);
        System.out.println(lineUniversities);

        List<Statistics> statistics = UtilStudentUniversities.statisticsMethod(students, universities);
        String lineStatistics = JsonUtil.collectionToJson(statistics);
        System.out.println(lineStatistics);

        //сортировка коллекции students
        StudentsComp comp1 = EnumWork.getMyComparatorStudent(StudentComparators.STUDENT_COMPARATOR_FULL_NAME);
        students = students.stream().sorted(comp1).collect(Collectors.toList());
        students.forEach(System.out::println);

        System.out.println("---");

        //сортировка коллекции universities
        UniversityComp comp2 = EnumWork.getMyComparatorUniversity(UniversityComparators.UNIVERSITY_COMPARATOR_ID);
        universities = universities.stream().sorted(comp2).collect(Collectors.toList());
        universities.forEach(System.out::println);

        System.out.println("---");

        //Задание "27.8. Проект"
        UtilStudentUniversities.statisticsMethod(students, universities).forEach(System.out::println);
        String path = "statistic.xls";
        XlsWriter.excelFile(UtilStudentUniversities.statisticsMethod(students, universities), path);

        //Финальное задание 29.5
        //заполнение файла xmlReqs/req.xml
        XmlClass xmlClass = new XmlClass(FileWork.readStudents(), FileWork.readUniversities(), UtilStudentUniversities.statisticsMethod(FileWork.readStudents(), FileWork.readUniversities()), new Date());
        XmlUtil.createXMLstructure(xmlClass);

        //заполнение файла jsonReqs/reg_2024_01_27.json
        ToJsonXmlClassUtil.createJsonStructure(xmlClass);

        logger.info("Files xml and json created!");
    }
}