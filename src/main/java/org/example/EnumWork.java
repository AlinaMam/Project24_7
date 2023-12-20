package org.example;

import org.example.enums.StudentComparators;
import org.example.enums.UniversityComparators;
import org.example.students.*;
import org.example.university.*;

public class EnumWork {
    private EnumWork() {

    }

    public static StudentsComp getMyComparatorStudent(StudentComparators stdComp) {
        StudentsComp studentsComp = null;
        switch (stdComp) {
            case STUDENT_COMPARATOR_AVG_EXAM_SCORE:
                studentsComp = new StudentComparatorAvgExamScore();
                break;
            case STUDENT_COMPARATOR_CURRENT_COURSE_NUMBER:
                studentsComp = new StudentComparatorCurrentCourseNumber();
                break;
            case STUDENT_COMPARATOR_FULL_NAME:
                studentsComp = new StudentComparatorFullName();
                break;
            case STUDENT_COMPARATOR_UNIVERSITY_ID:
                studentsComp = new StudentComparatorUniversityId();
                break;
        }
        return studentsComp;
    }

    public static UniversityComp getMyComparatorUniversity(UniversityComparators uniComp) {
        UniversityComp universityComp = null;
        switch (uniComp) {
            case UNIVERSITY_COMPARATOR_FULL_NAME:
                universityComp = new UniversityComparatorFullName();
                break;
            case UNIVERSITY_COMPARATOR_ID:
                universityComp = new UniversityComparatorId();
                break;
            case UNIVERSITY_COMPARATOR_MAINPROFILE:
                universityComp = new UniversityComparatorMainProfile();
                break;
            case UNIVERSITY_COMPARATOR_SHORTNAME:
                universityComp = new UniversityComparatorShortName();
                break;
            case UNIVERSITY_COMPARATOR_YEAR_OF_FOUNDATION:
                universityComp = new UniversityComparatorYearOfFoundation();
        }
        return universityComp;
    }
}
