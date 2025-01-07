package com.hms.hospital_management_system.mapper;

import com.hms.hospital_management_system.dto.UserDto;
import com.hms.hospital_management_system.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto dto);
}
