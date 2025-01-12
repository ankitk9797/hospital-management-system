package com.hms.hospital_management_system.repository;

import com.hms.hospital_management_system.entity.User;
import com.hms.hospital_management_system.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByUsername(String Username);

    Optional<User> findUserByUsernameAndRole(String Username, Role role);

}
