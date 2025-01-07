package com.hms.hospital_management_system.services.impl;

import com.hms.hospital_management_system.dto.UserDto;
import com.hms.hospital_management_system.entity.User;
import com.hms.hospital_management_system.mapper.UserMapper;
import com.hms.hospital_management_system.repository.UserRepository;
import com.hms.hospital_management_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDto createUser(UserDto dto) {
        Optional<User> user = userRepository.findUserByUsername(dto.getUsername());
        if(user.isEmpty()){
            dto.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
            User user1 = userRepository.save(userMapper.toEntity(dto));
            return userMapper.toDto(user1);
        }
        return null;
    }

}
