package com.example.resapp2023.service;

import com.example.resapp2023.domain.entity.UserEntity;
import com.example.resapp2023.domain.serviceModel.UserServiceModel;
import com.example.resapp2023.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean isNameExistMetod(String username) {
        return userRepository.existsByUsername(username)
                .isPresent();
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel, UserEntity.class));
    }
}
