package org.example.university;

import org.example.enums.StudyProfile;

public class University {
    private String id;
    private String fullName;
    private String shortName;
    private int yearOfFoundation;
    private StudyProfile mainProfile;

    public University() {
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }

    public static class Builder {
        private University university;

        public Builder() {
            university = new University();
        }

        public Builder setId(String id) {
            university.id = id;
            return this;
        }

        public Builder setFullName(String fullName) {
            university.fullName = fullName;
            return this;
        }

        public Builder setShortName(String shortName) {
            university.shortName = shortName;
            return this;
        }

        public Builder setYearOfFoundation(int yearOfFoundation) {
            university.yearOfFoundation = yearOfFoundation;
            return this;
        }

        public Builder setMainProfile(StudyProfile mainProfile) {
            university.mainProfile = mainProfile;
            return this;
        }

        public University build() {
            return university;
        }
    }
}
