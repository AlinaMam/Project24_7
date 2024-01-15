package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.students.Student;
import org.example.university.University;


import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtil {
    private static final Logger logger = Logger.getLogger(JsonUtil.class.getName());

    private JsonUtil() {
    }

    public static String serializeStudent(Student student) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String strStudent = gson.toJson(student);
        logger.log(Level.INFO, "Object 'Student' serialized: " + strStudent);
        return strStudent;
    }

    public static String serializeUniversity(University university) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String strUniversity = gson.toJson(university);
        logger.log(Level.INFO, "Object 'University' serialized: " + strUniversity);
        return strUniversity;
    }

    public static String serializeListStudent(List<Student> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String strListStudent = gson.toJson(list);
        logger.log(Level.INFO, "Object 'List<Student>' serialized: " + strListStudent);
        return strListStudent;
    }

    public static String serializeListUniversity(List<University> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String strListUniversity = gson.toJson(list);
        logger.log(Level.INFO, "Object 'List<University>' serialized: " + strListUniversity);
        return strListUniversity;
    }

    public static Student deserializeStudent(String str) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        Student student = gson.fromJson(str, Student.class);
        logger.log(Level.INFO, "Object 'Student' deserialized: " + student);
        return student;
    }

    public static University deserializeUniversity(String str) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        University university = gson.fromJson(str, University.class);
        logger.log(Level.INFO, "Object 'University' deserialized: " + university);
        return university;
    }

    public static List<Student> deserializeListStudent(String str) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        Type listType = new TypeToken<List<Student>>() {
        }.getType();
        List<Student> listStudents = gson.fromJson(str, listType);
        logger.log(Level.INFO, "Object 'List<Student>' deserialized: " + listStudents);
        return listStudents;
    }

    public static List<University> deserializeListUniversity(String str) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        Type listType = new TypeToken<List<University>>() {
        }.getType();
        List<University> listUniversities = gson.fromJson(str, listType);
        logger.log(Level.INFO, "Object 'List<University>' deserialized: " + listUniversities);
        return listUniversities;
    }
}
