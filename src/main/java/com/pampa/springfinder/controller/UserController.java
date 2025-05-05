package com.pampa.springfinder.controller;

import com.pampa.springfinder.model.UserModel;
import com.pampa.springfinder.model.ResponseModel;
import com.pampa.springfinder.record.UserRecordDTO;
import com.pampa.springfinder.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping("/user-info")
    public ResponseEntity<ResponseModel> getUserData(
            @RequestBody @Valid UserRecordDTO userRecordDTO
    ) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDTO, userModel);

        logger.info("User data requested: {}", userModel);

        try {
            List<UserModel> users = userService.findUsers(userModel);
            ResponseModel response = new ResponseModel(users);

            logger.info("Users found: {}", users);
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        } catch (Exception e) {
            logger.error("Error finding user data:", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}