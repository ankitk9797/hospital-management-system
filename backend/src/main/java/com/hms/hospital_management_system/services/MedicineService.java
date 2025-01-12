package com.hms.hospital_management_system.services;

import com.hms.hospital_management_system.dto.MedicineDto;

import java.util.List;

public interface MedicineService {

    MedicineDto createMedicine(MedicineDto dto);

    List<MedicineDto> getMedicines();

    MedicineDto getMedicineById(long id);

    MedicineDto updateMedicineByid(long id, MedicineDto dto);

    boolean deleteMedicineById(long id);
}
