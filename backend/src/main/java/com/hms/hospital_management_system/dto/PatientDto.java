package com.hms.hospital_management_system.dto;

import lombok.Data;

@Data
public class PatientDto {
    long id;

    String name;

    String age;

    String blood;

    String prescription;

    String dose;

    String fees;

    String urgency;
}
