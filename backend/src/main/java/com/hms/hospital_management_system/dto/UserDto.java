package com.hms.hospital_management_system.dto;

import com.hms.hospital_management_system.enums.Role;
import lombok.Data;

@Data
public class UserDto {

    long id;

    String username;

    String password;

    Role role;
}
