package com.pampa.springfinder.service;

import com.pampa.springfinder.model.UserModel;
import com.pampa.springfinder.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    final UserRepository userRepository;

    @Transactional
    public List<UserModel> findUsers(UserModel userModel) {
        if (userModel.getCpf() != null && !userModel.getCpf().isBlank()) {
            Optional<UserModel> opt = userRepository.findById(userModel.getCpf());
            return opt.map(List::of).orElseGet(List::of);
        }
        else if (userModel.getName() != null && !userModel.getName().isBlank()) {
            return userRepository.findFirst1000AllByNameLike(userModel.getName());
        }
        else if (userModel.getDate() != null && !userModel.getDate().isBlank()) {
            return userRepository.findFirst1000AllByDateLike(userModel.getDate());
        }
        else {
            return List.of();
        }
    }
}
