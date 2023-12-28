package org.example;

import org.example.enums.StudyProfile;

public class Statistics {
    private StudyProfile studyProfile;
    private double avgGrade;
    private int countStudents;
    private int countUniversities;
    private String nameUniversity;

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public Statistics setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
        return this;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public Statistics setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
        return this;
    }

    public int getCountStudents() {
        return countStudents;
    }

    public Statistics setCountStudents(int countStudents) {
        this.countStudents = countStudents;
        return this;
    }

    public int getCountUniversities() {
        return countUniversities;
    }

    public Statistics setCountUniversities(int countUniversities) {
        this.countUniversities = countUniversities;
        return this;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public Statistics setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
        return this;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "studyProfile=" + this.studyProfile +
                ", avgGrade=" + this.avgGrade +
                ", countStudents=" + this.countStudents +
                ", countUniversities=" + this.countUniversities +
                ", nameUniversity='" + this.nameUniversity + '\'' +
                '}';
    }
}
