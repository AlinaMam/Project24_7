package org.example.students;

public class StudentComparatorAvgExamScore implements StudentsComp {
    @Override
    public int compare(Student o1, Student o2) {

        return Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
    }
}
