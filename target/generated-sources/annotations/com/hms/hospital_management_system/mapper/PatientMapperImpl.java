package com.hms.hospital_management_system.mapper;

import com.hms.hospital_management_system.dto.PatientDto;
import com.hms.hospital_management_system.entity.Patient;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-12T08:25:09+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientDto toDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDto patientDto = new PatientDto();

        patientDto.setId( patient.getId() );
        patientDto.setName( patient.getName() );
        patientDto.setAge( patient.getAge() );
        patientDto.setBlood( patient.getBlood() );
        patientDto.setPrescription( patient.getPrescription() );
        patientDto.setDose( patient.getDose() );
        patientDto.setFees( patient.getFees() );
        patientDto.setUrgency( patient.getUrgency() );

        return patientDto;
    }

    @Override
    public Patient toEntity(PatientDto dto) {
        if ( dto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( dto.getId() );
        patient.setName( dto.getName() );
        patient.setAge( dto.getAge() );
        patient.setBlood( dto.getBlood() );
        patient.setPrescription( dto.getPrescription() );
        patient.setDose( dto.getDose() );
        patient.setFees( dto.getFees() );
        patient.setUrgency( dto.getUrgency() );

        return patient;
    }
}
