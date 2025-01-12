package com.hms.hospital_management_system.mapper;

import com.hms.hospital_management_system.dto.AppointmentDto;
import com.hms.hospital_management_system.entity.Appointment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentDto toDto(Appointment appointment);

    Appointment toEntity(AppointmentDto dto);
}
