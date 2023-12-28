package org.example;

import org.example.enums.StudyProfile;
import org.example.students.Student;
import org.example.university.University;
import org.example.university.UniversityComp;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilStudentUniversities {
    public static List<Statistics> statisticsMethod(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();

        //Коллекция studyProfile
        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        //Назначаем каждому объекту Statistics имя studyProfile
        profiles.forEach(nameProfile -> {
            Statistics statistics = new Statistics();
            statistics.setStudyProfile(nameProfile);

            //Для каждого StudyProfile считаем кол-во полей "id" в таблице University
            List<String> nameUni = universities.stream()
                    .filter(university -> university.getMainProfile().equals(nameProfile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setCountUniversities(nameUni.size());

            //Для каждого StudyProfile считаем кол-во полей "universityId" в таблице Students и это будет равно кол-ву студентов
            List<Student> countUniId = students.stream()
                    .filter(st -> nameUni.contains(st.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setCountStudents(countUniId.size());

            //Считаем средний avgExamScore по StudyProfile
            countUniId.stream()
                    .mapToDouble(st -> st.getAvgExamScore())
                    .average()
                    .ifPresent(avg -> {
                        MathContext context = new MathContext(3, RoundingMode.HALF_UP);
                        BigDecimal result = new BigDecimal(avg, context);
                        statistics.setAvgGrade(result.doubleValue());
                    });

            //Для каждого mainProfile указываем полное название Университета
            List<String> unis = universities.stream()
                    .filter(name -> nameUni.contains(name.getId()))
                    .map(University::getFullName)
                    .collect(Collectors.toList());
            statistics.setNameUniversity(unis.toString());

            statisticsList.add(statistics);
        });
        return statisticsList;
    }
}

