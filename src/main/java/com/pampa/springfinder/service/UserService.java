package com.pampa.springfinder.service;

import com.pampa.springfinder.model.UserModel;
import com.pampa.springfinder.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    final UserRepository userRepository;

    @Transactional
    public UserModel findUser(UserModel userModel) {
        UserModel user;
        try {
            if (!userModel.getCpf().isEmpty())
                user = userRepository.getReferenceById(userModel.getCpf());
            else if (!userModel.getName().isEmpty())
                user = userRepository.findByName(userModel.getName());
            else if (!userModel.getDate().isEmpty())
                user = userRepository.findByDate(userModel.getDate());
            else user = new UserModel("", "", "", "");
        } catch (Exception e) {
            throw new RuntimeException("Not enough data to find user");
        }
        return user;
    }

}
