package com.example.resapp2023.service;

import com.example.resapp2023.domain.serviceModel.UserServiceModel;

public interface UserService {
    boolean isNameExistMetod(String username);

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logOut();
}
