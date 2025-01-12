package com.hms.hospital_management_system.services.impl;

import com.hms.hospital_management_system.dto.MedicineDto;
import com.hms.hospital_management_system.entity.Medicine;
import com.hms.hospital_management_system.mapper.MedicineMapper;
import com.hms.hospital_management_system.repository.MedicineRepository;
import com.hms.hospital_management_system.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public MedicineDto createMedicine(MedicineDto dto) {
        Medicine medicine = medicineRepository.findMedicineByDrugName(dto.getDrugName());
        if(medicine!=null){
            return null;
        }
        return medicineMapper.toDto(medicineRepository.save(medicineMapper.toEntity(dto)));
    }

    @Override
    public List<MedicineDto> getMedicines() {
        return medicineRepository.findAll().stream().map(medicine -> medicineMapper.toDto(medicine)).collect(Collectors.toList());
    }

    @Override
    public MedicineDto getMedicineById(long id) {
        Optional<Medicine> optional = medicineRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        return medicineMapper.toDto(optional.get());
    }

    @Override
    public MedicineDto updateMedicineByid(long id, MedicineDto dto) {
        Optional<Medicine> optional = medicineRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        dto.setId(optional.get().getId());
        return medicineMapper.toDto(medicineRepository.save(medicineMapper.toEntity(dto)));
    }

    @Override
    public boolean deleteMedicineById(long id) {
        Optional<Medicine> optional = medicineRepository.findById(id);
        if(optional.isEmpty()){
            return false;
        }

        medicineRepository.deleteById(id);
        return true;
    }
}
