package org.example.students;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("university_id")
    private String universityId;
    @SerializedName("current_course_number")
    private int currentCourseNumber;
    @SerializedName("avg_exam_score")
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


