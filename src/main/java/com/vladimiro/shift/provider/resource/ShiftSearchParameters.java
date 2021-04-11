package com.vladimiro.shift.provider.resource;

import java.util.List;

public class ShiftSearchParameters {
    List<String> ids;
    List<String> userIds;
    String from;
    String to;
    Boolean showCosts;
    Boolean showAwardInterpretation;
    Boolean showNotes;
    Integer reportLocationId;
    Boolean platform;
    Long updatedAfter;
}
