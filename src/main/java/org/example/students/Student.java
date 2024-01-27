package org.example.students;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @SerializedName("full_name")
    @XmlElement(name = "studentName")
    private String fullName;
    @SerializedName("university_id")
    @XmlElement(name = "universityId")
    private String universityId;
    @SerializedName("current_course_number")
    private int currentCourseNumber;
    @SerializedName("avg_exam_score")
    @XmlElement(name = "avgScore")
    private float avgExamScore;

    public Student() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }

    public static class Builder {
        private Student student;

        public Builder() {
            student = new Student();
        }

        public Builder setFullName(String fullName) {
            student.fullName = fullName;
            return this;
        }

        public Builder setUniversityId(String universityId) {
            student.universityId = universityId;
            return this;
        }

        public Builder setCurrentCourseNumber(int currentCourseNumber) {
            student.currentCourseNumber = currentCourseNumber;
            return this;
        }

        public Builder setAvgExamScore(float avgExamScore) {
            student.avgExamScore = avgExamScore;
            return this;
        }

        public Student build() {
            return student;
        }
    }
}


