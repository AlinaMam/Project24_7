package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;
import org.example.students.Student;
import org.example.university.University;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileWork {

    private FileWork() {
    }

    public static List<Student> readStudents() {
        List<Student> listStudents = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("/Users/alina/Desktop/Java/Project24_7/src/main/resources/universityInfo.xlsx")) {
            XSSFWorkbook sheets = new XSSFWorkbook(fis);
            XSSFSheet students = sheets.getSheet("Студенты");
            Iterator<Row> rowIterator = students.rowIterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Student student = new Student.Builder()
                        .setFullName(row.getCell(1).getStringCellValue())
                        .setUniversityId(row.getCell(0).getStringCellValue())
                        .setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue())
                        .setAvgExamScore((float) row.getCell(3).getNumericCellValue())
                        .build();
                listStudents.add(student);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listStudents;
    }

    public static List<University> readUniversities() {
        List<University> listUniversities = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("/Users/alina/Desktop/Java/Project24_7/src/main/resources/universityInfo.xlsx")) {
            XSSFWorkbook sheets = new XSSFWorkbook(fis);
            XSSFSheet universities = sheets.getSheet("Университеты");
            Iterator<Row> rowIterator = universities.rowIterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                University university = new University.Builder()
                        .setId(row.getCell(0).getStringCellValue())
                        .setFullName(row.getCell(1).getStringCellValue())
                        .setShortName(row.getCell(2).getStringCellValue())
                        .setYearOfFoundation((int) row.getCell(3).getNumericCellValue())
                        .setMainProfile(StudyProfile.valueOf(row.getCell(4).getStringCellValue()))
                        .build();
                listUniversities.add(university);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listUniversities;
    }
}

