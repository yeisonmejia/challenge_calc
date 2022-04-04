package com.challenge.appgate.calc.operations.actions;

import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.operands.OperandRepository;
import com.challenge.appgate.calc.operations.model.user.User;
import com.challenge.appgate.calc.operations.model.user.UserId;
import com.challenge.appgate.calc.operations.model.user.UserNotExistException;
import com.challenge.appgate.calc.operations.model.user.UserRepository;

public class OperandSaver {

    private final UserRepository userRepository;
    private final OperandRepository operandRepository;

    public OperandSaver(UserRepository userRepository, OperandRepository operandRepository) {
        this.userRepository = userRepository;
        this.operandRepository = operandRepository;
    }

    public void saveOperandForUser(String userIdParam, String operandParam) {
        UserId userId = new UserId(userIdParam);
        User user = userRepository.findUserById(userId);

        if (user == null) throw new UserNotExistException("User not exist");

        Operand operand = Operand.create(operandParam, userId);
        operandRepository.saveOperand(operand);

        // Aqui se deberia hacer commit
        // Aqui se deberian lanzar eventos de dominio si existieran
    }
}
