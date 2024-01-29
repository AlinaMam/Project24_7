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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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

        //Создание директории
        String nameFile = "json " + LocalDate.now();
        try {
            Files.createDirectory(Path.of("/Users/alina/Desktop/Java/Project24_7/src/main/java/org/example/jsonReqs/"));
        } catch (IOException e) {
           logger.error("Problem to create directory!");
           e.printStackTrace();
        }

        //устанавливаем дату
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formatter.format(date);
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate);
            xmlClass.setDate(date);
        } catch (ParseException e) {
            logger.error("Error to create date!");
            e.printStackTrace();
        }

        //создание объекта GSON
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        String json = gson.toJson(xmlClass);
        try {
            Files.write(Paths.get("src/main/java/org/example/jsonReqs/" + nameFile + ".json"), json.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            logger.error("Error to write in file.");
            e.printStackTrace();
        }
    }
}
