package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.students.Student;
import org.example.university.University;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    public static String serializeStudent(Student student) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String strStudent = gson.toJson(student);
        return strStudent;
    }

    public static String serializeUniversity(University university) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String strUniversity = gson.toJson(university);
        return strUniversity;
    }

    public static String serializeListStudent(List<Student> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String strListStudent = gson.toJson(list);
        return strListStudent;
    }

    public static String serializeListUniversity(List<University> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String strListUniversity = gson.toJson(list);
        return strListUniversity;
    }

    public static Student deserializeStudent(String str) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        Student student = gson.fromJson(str, Student.class);
        return student;
    }

    public static University deserializeUniversity(String str) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        University university = gson.fromJson(str, University.class);
        return university;
    }

    public static List<Student> deserializeListStudent(String str) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        Type listType = new TypeToken<List<Student>>() {}.getType();
        List<Student> listStudents = gson.fromJson(str, listType);
        return listStudents;
    }

    public static List<University> deserializeListUniversity(String str) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        Type listType = new TypeToken<List<University>>() {}.getType();
        List<University> universities = gson.fromJson(str, listType);
        return universities;
    }
}
