package com.example.covoiturage.repository;

import com.example.covoiturage.Models.ERole;
import com.example.covoiturage.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
