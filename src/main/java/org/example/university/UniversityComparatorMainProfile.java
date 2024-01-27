package org.example.university;

public class UniversityComparatorMainProfile implements UniversityComp{
    @Override
    public int compare(University o1, University o2) {
        return o1.getMainProfile().toString().compareTo(o2.getMainProfile().toString());
    }
}
