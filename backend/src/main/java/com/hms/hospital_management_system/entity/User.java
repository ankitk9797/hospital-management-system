package com.hms.hospital_management_system.entity;

import com.hms.hospital_management_system.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_admin")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

}
