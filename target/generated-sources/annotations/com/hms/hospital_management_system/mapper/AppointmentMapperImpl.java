package com.hms.hospital_management_system.mapper;

import com.hms.hospital_management_system.dto.AppointmentDto;
import com.hms.hospital_management_system.entity.Appointment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-08T03:52:37+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentDto toDto(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentDto appointmentDto = new AppointmentDto();

        appointmentDto.setId( appointment.getId() );
        appointmentDto.setName( appointment.getName() );
        appointmentDto.setAge( appointment.getAge() );
        appointmentDto.setSymtomps( appointment.getSymtomps() );
        appointmentDto.setMobile( appointment.getMobile() );

        return appointmentDto;
    }

    @Override
    public Appointment toEntity(AppointmentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setId( dto.getId() );
        appointment.setName( dto.getName() );
        appointment.setAge( dto.getAge() );
        appointment.setSymtomps( dto.getSymtomps() );
        appointment.setMobile( dto.getMobile() );

        return appointment;
    }
}
