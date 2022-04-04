package com.challenge.appgate.calc.operations.actions;

import com.challenge.appgate.calc.operations.model.operands.OperandRepository;
import com.challenge.appgate.calc.operations.model.user.UserRepository;

public class OperandSaver {

    private final UserRepository userRepository;

    public OperandSaver(UserRepository userRepository, OperandRepository operandRepository) {
        this.userRepository = userRepository;
    }

    public void saveOperandForUser(String userId, String operand) {
    }
}
