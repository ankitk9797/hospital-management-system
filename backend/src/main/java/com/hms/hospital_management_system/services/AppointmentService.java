package com.hms.hospital_management_system.services;

import com.hms.hospital_management_system.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto dto);

    List<AppointmentDto> getAppointments();

    boolean deleteAppointment(long id);

}
