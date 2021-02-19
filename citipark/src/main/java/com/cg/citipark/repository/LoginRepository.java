package com.cg.citipark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.citipark.beans.Login;


public interface LoginRepository extends JpaRepository<Login,String>{

}
