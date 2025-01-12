package com.hms.hospital_management_system.services.impl;

import com.hms.hospital_management_system.dto.AppointmentDto;
import com.hms.hospital_management_system.entity.Appointment;
import com.hms.hospital_management_system.mapper.AppointmentMapper;
import com.hms.hospital_management_system.repository.AppointmentRepository;
import com.hms.hospital_management_system.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentMapper appointmentMapper;
    @Override
    public AppointmentDto createAppointment(AppointmentDto dto) {
        return appointmentMapper.toDto(appointmentRepository.save(appointmentMapper.toEntity(dto)));
    }

    @Override
    public List<AppointmentDto> getAppointments() {
        return  appointmentRepository.findAll().stream().map(appointment -> appointmentMapper.toDto(appointment)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteAppointment(long id) {
        Optional<Appointment> optional = appointmentRepository.findById(id);
        if(optional.isPresent()) {
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
