package org.example.students;

public class StudentComparatorCurrentCourseNumber implements StudentsComp{
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
