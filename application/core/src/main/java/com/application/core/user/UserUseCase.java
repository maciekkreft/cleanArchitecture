package com.application.core.user;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserUseCase {
    private final UserDataGateway userDataGateway;

    public UserEntity addUser(UserEntity user) {
        if (userDataGateway.exists(user.getEmail())) {
            throw new UserAlreadyExists(user.getEmail());
        }
        if(!user.getPassword().equals(user.getPasswordRepeated())) {
            throw new RepeatedPasswordNotMatches(user.getEmail());
        }
        return userDataGateway.addUser(user);
    }
}
