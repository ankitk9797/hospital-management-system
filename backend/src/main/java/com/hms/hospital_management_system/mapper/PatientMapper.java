package com.hms.hospital_management_system.mapper;

import com.hms.hospital_management_system.dto.PatientDto;
import com.hms.hospital_management_system.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientDto toDto(Patient patient);

    Patient toEntity(PatientDto dto);
}
