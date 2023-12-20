package org.example.university;

import org.apache.commons.lang3.StringUtils;

public class UniversityComparatorShortName implements UniversityComp{
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }
}
