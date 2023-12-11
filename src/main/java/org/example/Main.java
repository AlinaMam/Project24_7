package org.example;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student.Builder()
                .setFullName("Иванов Иван Иванович")
                .setUniversityId("Номер 1")
                .setCurrentCourseNumber(3)
                .setAvgExamScore(9.8f)
                .build();

        University university1 = new University.Builder()
                .setId("Номер 1")
                .setFullName("Московский Государственный Университет Управления")
                .setShortName("ГУУ")
                .setYearOfFoundation(1950)
                .setMainProfile(StudyProfile.COMPUTER_SCIENCE)
                .build();

        System.out.println(student1);
        System.out.println(university1);
    }
}