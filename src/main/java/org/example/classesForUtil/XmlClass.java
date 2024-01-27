package org.example.classesForUtil;

import org.example.students.Student;
import org.example.university.University;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlClass {
    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    private List<Student> students;
    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private List<University> universities;
    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statistics;
    @XmlElement(name = "processedAt")
    private Date date;

    public XmlClass() {
    }

    public XmlClass(List<Student> students, List<University> universities, List<Statistics> statistics, Date date) {
        this.students = students;
        this.universities = universities;
        this.statistics = statistics;
        this.date = date;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "XmlClass{" +
                "students=" + students +
                ", universities=" + universities +
                ", statistics=" + statistics +
                ", date=" + date +
                '}';
    }
}
