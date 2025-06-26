package com.example.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auth.model.userinfo;

@Repository
public interface user_repo extends JpaRepository<userinfo,Long>{
    Optional<userinfo> findbyemail(String email);
}
