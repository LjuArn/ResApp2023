package com.example.resapp2023.repository;

import com.example.resapp2023.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    Optional<UserEntity>existsByUsername(String username);
}
