package com.hms.hospital_management_system.services.impl;

import com.hms.hospital_management_system.dto.PatientDto;
import com.hms.hospital_management_system.entity.Patient;
import com.hms.hospital_management_system.mapper.PatientMapper;
import com.hms.hospital_management_system.repository.PatientRepository;
import com.hms.hospital_management_system.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientMapper patientMapper;

    @Override
    public PatientDto create(PatientDto dto) {
        return patientMapper.toDto(patientRepository.save(patientMapper.toEntity(dto)));
    }

    @Override
    public List<PatientDto> getAllPatiennts() {
        return patientRepository.findAll().stream().map(patient -> patientMapper.toDto(patient)).collect(Collectors.toList());
    }

    @Override
    public PatientDto getPatientById(long id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        return patientMapper.toDto(optional.get());
    }

    @Override
    public PatientDto updatePatient(long id, PatientDto dto) {
        Optional<Patient> optional = patientRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        dto.setId(optional.get().getId());
        return patientMapper.toDto(patientRepository.save(patientMapper.toEntity(dto)));
    }

    @Override
    public boolean deletePatient(long id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if(optional.isEmpty()){
            return false;
        }
        patientRepository.deleteById(id);
        return true;
    }
}
