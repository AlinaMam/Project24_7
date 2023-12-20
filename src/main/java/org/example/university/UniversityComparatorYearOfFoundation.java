package org.example.university;

public class UniversityComparatorYearOfFoundation implements UniversityComp{
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
