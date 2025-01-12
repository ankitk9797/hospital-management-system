package com.hms.hospital_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="medicines")
@Data
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="drug_name")
    private String drugName;
    private String stock;
}
