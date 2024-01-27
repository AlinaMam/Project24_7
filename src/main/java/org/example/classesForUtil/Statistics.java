package org.example.classesForUtil;

import org.example.enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "universityProfile")
    private StudyProfile studyProfile;
    @XmlElement(name = "avgScore")
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
