package com.hms.hospital_management_system.services;

import com.hms.hospital_management_system.dto.UserDto;
import com.hms.hospital_management_system.enums.Role;

public interface UserService {
   UserDto createUser(UserDto dto);

   UserDto getUserByUsername(String username);

   UserDto getUserByUsernameAndRole(String username, Role role);

}
