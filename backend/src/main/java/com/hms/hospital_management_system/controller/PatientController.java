package com.hms.hospital_management_system.controller;

import com.hms.hospital_management_system.dto.PatientDto;
import com.hms.hospital_management_system.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patient")
public class PatientController {
    
    @Autowired
    PatientService patientService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody PatientDto dto) {
        PatientDto patientDto = patientService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDto);
    }

    @GetMapping(path = "/allPatients")
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getAllPatiennts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable long id) {
        PatientDto PatientDto = patientService.getPatientById(id);
        if(PatientDto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found with id: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(PatientDto);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable long id, @RequestBody PatientDto dto) {
        PatientDto PatientDto = patientService.updatePatient(id,dto);

        if(PatientDto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found with id: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(PatientDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable long id) {
        boolean isDeleted = patientService.deletePatient(id);

        if(isDeleted == false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found with id: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Patient successfully deleted");
    }
}
