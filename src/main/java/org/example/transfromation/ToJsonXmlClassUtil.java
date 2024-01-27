package org.example.transfromation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.classesForUtil.Statistics;
import org.example.classesForUtil.XmlClass;
import org.example.students.Student;
import org.example.university.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class ToJsonXmlClassUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileWork.class);
    public static void createJsonStructure(XmlClass xmlClass) {
        //получение списка студентов
        xmlClass.setStudents(FileWork.readStudents());
        List<Student> students = xmlClass.getStudents();

        //получение списка университетов
        xmlClass.setUniversities(FileWork.readUniversities());
        List<University> universities = xmlClass.getUniversities();

        //получение списка со статистикой
        xmlClass.setStatistics(UtilStudentUniversities.statisticsMethod(students, universities));
        List<Statistics> statistics = xmlClass.getStatistics();

        //создание объекта GSON
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        //объединение 3х листов
        List<Object> allLists = new ArrayList<>();
        allLists.add(students);
        allLists.add(universities);
        allLists.add(statistics);

        //преобразование в JSON и запись в файл
        String json = gson.toJson(allLists);
        try {
            Files.write(Paths.get("src/main/java/org/example/jsonReqs/reg_2024_01_27.json"), json.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            logger.error("Error to write in file.");
            e.printStackTrace();
        }
    }
}
