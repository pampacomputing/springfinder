package com.pampa.springfinder.repository;

import com.pampa.springfinder.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, String> {
    UserModel findByName(String name);
    UserModel findByDate(String date);
}
