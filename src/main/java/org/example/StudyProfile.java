package org.example;

public enum StudyProfile {
    BIOTECHNOLOGY("Биотехнологии"),
    DESIGN("Дизайн"),
    COMPUTER_SCIENCE("Информатика"),
    INFORMATION_SECURITY("Информационная безопасность");
    private String profileName;
    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
