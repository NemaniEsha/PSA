package com.cg.citipark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.citipark.beans.User;


public interface UserRepository extends JpaRepository<User,Long>{

	User findByEmail(String email);
}
