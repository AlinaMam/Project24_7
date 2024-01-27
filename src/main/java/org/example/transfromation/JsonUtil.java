package org.example.transfromation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.students.Student;
import org.example.university.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private JsonUtil() {
    }

    public static String studentToJson(Student student) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String strStudent = gson.toJson(student);
        logger.info("Object 'Student' serialized: " + strStudent);
        return strStudent;
    }

    public static String universityToJson(University university) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String strUniversity = gson.toJson(university);
        logger.info("Object 'University' serialized: " + strUniversity);
        return strUniversity;
    }

    public static Student jsonToStudent(String str) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        Student student = gson.fromJson(str, Student.class);
        logger.info("Object 'Student' deserialized: " + student);
        return student;
    }

    public static University jsonToUniversity(String str) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        University university = gson.fromJson(str, University.class);
        logger.info("Object 'Student' deserialized: " + university);
        return university;
    }

    public static <T> String collectionToJson(List<T> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String strSerialized = gson.toJson(list);
        logger.info("Collection serialized: " + strSerialized);
        return strSerialized;
    }

    public static <T> List<T> collectionFromJson(String str) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        Type listType = new TypeToken<List<T>>() {
        }.getType();
        List<T> list = gson.fromJson(str, listType);
        logger.info("Object deserialized: " + list);
        return list;
    }
}
