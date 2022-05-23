package com.offertechnicaltest.repository;


import com.offertechnicaltest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}