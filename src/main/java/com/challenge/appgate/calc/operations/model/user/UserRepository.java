package com.challenge.appgate.calc.operations.model.user;

import com.challenge.appgate.calc.operations.model.operands.Operand;

import java.util.List;

public interface UserRepository {
    void save(User user);
    User findUserById(UserId userId);
}
