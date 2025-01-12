package com.hms.hospital_management_system.controller;

import com.hms.hospital_management_system.dto.AppointmentDto;
import com.hms.hospital_management_system.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDto dto) {
        AppointmentDto appointmentDto = appointmentService.createAppointment(dto);
        if(appointmentDto==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDto);
    }

    @GetMapping(path = "/allAppointments")
    public List<AppointmentDto> getAppointments(){
        return appointmentService.getAppointments();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {
        boolean isDeleted = appointmentService.deleteAppointment(id);
        if(!isDeleted) {
            throw new AttributeNotFoundException("Appointment not found with id: "+id);
        }
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
