package com.hms.hospital_management_system.repository;

import com.hms.hospital_management_system.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Long> {

    Medicine findMedicineByDrugName(String name);
}
