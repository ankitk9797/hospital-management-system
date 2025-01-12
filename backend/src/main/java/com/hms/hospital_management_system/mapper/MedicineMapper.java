package com.hms.hospital_management_system.mapper;

import com.hms.hospital_management_system.dto.MedicineDto;
import com.hms.hospital_management_system.entity.Medicine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicineMapper {

    MedicineDto toDto(Medicine medicine);

    Medicine toEntity(MedicineDto dto);
}
