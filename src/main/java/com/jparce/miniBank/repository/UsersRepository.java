package com.jparce.miniBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jparce.miniBank.model.UsersModel;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

}
