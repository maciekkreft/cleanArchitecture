package com.application.core.dataproviders.user;

import com.application.core.user.UserDataGateway;
import com.application.core.user.UserEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class UserDataMapper implements UserDataGateway {

    private final UserRepository userRepository;

    @Override
    public UserEntity addUser(UserEntity user) {
        return toEntity(userRepository.save(toRow(user)));
    }

    @Override
    public boolean exists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    private UserEntity toEntity(User u) {
        return new UserEntity(u.getId(), u.getEmail(), null, null);
    }

    private User toRow(UserEntity user) {
        return new User(user.getEmail(), String.valueOf(user.getPassword().hashCode()));
    }
}
