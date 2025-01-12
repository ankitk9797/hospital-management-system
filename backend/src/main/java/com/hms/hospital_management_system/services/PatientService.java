package com.hms.hospital_management_system.services;

import com.hms.hospital_management_system.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto create(PatientDto dto);

    List<PatientDto> getAllPatiennts();

    PatientDto getPatientById(long id);

    PatientDto updatePatient(long id, PatientDto dto);

    boolean deletePatient(long id);
}
