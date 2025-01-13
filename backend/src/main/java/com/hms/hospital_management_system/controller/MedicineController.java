package com.hms.hospital_management_system.controller;

import com.hms.hospital_management_system.dto.MedicineDto;
import com.hms.hospital_management_system.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> createMedicine(@RequestBody MedicineDto dto) {
        MedicineDto medicineDto = medicineService.createMedicine(dto);
        if(medicineDto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(medicineDto);
    }

    @GetMapping(path = "/allMedicines")
    public ResponseEntity<List<MedicineDto>> getMedicines(){
        return ResponseEntity.status(HttpStatus.OK).body(medicineService.getMedicines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicineById(@PathVariable long id) {
        MedicineDto medicineDto = medicineService.getMedicineById(id);
        if(medicineDto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicine not found with id: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicineDto);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updateMedicine(@PathVariable long id, @RequestBody MedicineDto dto) {
        MedicineDto medicineDto = medicineService.updateMedicineByid(id,dto);

        if(medicineDto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicine not found with id: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicineDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteMedicine(@PathVariable long id) throws AttributeNotFoundException {
        boolean isDeleted = medicineService.deleteMedicineById(id);

        if(!isDeleted) {
            throw new AttributeNotFoundException("Appointment not found with id: "+id);
        }
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
