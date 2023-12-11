package org.example;

public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    public Student() {
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
