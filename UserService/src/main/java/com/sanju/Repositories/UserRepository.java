package com.sanju.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanju.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
