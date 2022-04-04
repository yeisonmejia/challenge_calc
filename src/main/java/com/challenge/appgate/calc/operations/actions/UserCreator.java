package com.challenge.appgate.calc.operations.actions;

import com.challenge.appgate.calc.operations.model.user.User;
import com.challenge.appgate.calc.operations.model.user.UserId;
import com.challenge.appgate.calc.operations.model.user.UserRepository;

public class UserCreator {

    private UserRepository userRepository;

    public UserCreator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserId createUser() {
        User user = User.create();
        userRepository.save(user);
        return user.getUserId();
    }
}
