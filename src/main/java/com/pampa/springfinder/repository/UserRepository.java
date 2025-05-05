package com.pampa.springfinder.repository;

import com.pampa.springfinder.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, String> {
    List<UserModel> findAllByName(String name);
    List<UserModel> findAllByDate(String date);
}
