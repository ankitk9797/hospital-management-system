package com.hms.hospital_management_system.mapper;

import com.hms.hospital_management_system.dto.MedicineDto;
import com.hms.hospital_management_system.entity.Medicine;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-08T04:52:46+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class MedicineMapperImpl implements MedicineMapper {

    @Override
    public MedicineDto toDto(Medicine medicine) {
        if ( medicine == null ) {
            return null;
        }

        MedicineDto medicineDto = new MedicineDto();

        medicineDto.setId( medicine.getId() );
        medicineDto.setDrugName( medicine.getDrugName() );
        medicineDto.setStock( medicine.getStock() );

        return medicineDto;
    }

    @Override
    public Medicine toEntity(MedicineDto dto) {
        if ( dto == null ) {
            return null;
        }

        Medicine medicine = new Medicine();

        medicine.setId( dto.getId() );
        medicine.setDrugName( dto.getDrugName() );
        medicine.setStock( dto.getStock() );

        return medicine;
    }
}
