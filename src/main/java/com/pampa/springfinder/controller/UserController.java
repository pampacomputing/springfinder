package com.pampa.springfinder.controller;

import com.pampa.springfinder.model.UserModel;
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

@RestController
@AllArgsConstructor
public class UserController {

    final private static Logger logger = LoggerFactory.getLogger(UserService.class);

    final UserService userService;

    @PostMapping("/user-info")
    public ResponseEntity<UserModel> getUserData(@RequestBody @Valid UserRecordDTO userRecordDTO) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDTO, userModel);

        logger.info("User data requested: {}", userModel);

        ResponseEntity<UserModel> response;
        try {
            response = ResponseEntity.status(HttpStatus.FOUND).body(userService.findUser(userModel));
            logger.info("User blablabla data found: {}", response.getBody());
        } catch (Exception e) {
            logger.error("Error finding user data: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return response;
    }
}