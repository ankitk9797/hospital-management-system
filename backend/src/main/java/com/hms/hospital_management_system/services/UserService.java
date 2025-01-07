package com.hms.hospital_management_system.services;

import com.hms.hospital_management_system.dto.UserDto;

public interface UserService {
   UserDto createUser(UserDto dto);

   UserDto getUserByUsername(String username);

}
