package com.challenge.appgate.calc.operations.model.operands;

import com.challenge.appgate.calc.operations.model.user.User;
import com.challenge.appgate.calc.operations.model.user.UserId;
import com.challenge.appgate.calc.operations.model.user.UserRepository;

import java.util.List;

public class OperandsFinder {

    private OperandRepository operandRepository;
    private UserRepository userRepository;

    public OperandsFinder(OperandRepository operandRepository, UserRepository userRepository) {
        this.operandRepository = operandRepository;
        this.userRepository = userRepository;
    }

    public List<Operand> findOperandsByUserId(UserId userId) {
        List<Operand> operands = operandRepository.getOperandsByUserId(userId);

        if (operands == null || operands.size() == 0) {
            throw new InvalidOperandsNumber("you need 2 operands to operate");
        }

        if (operands.size() == 1) {
            User user = userRepository.findUserById(userId);
            if (!user.getLastResult().isPresent()) throw new InvalidOperandsNumber("you need 2 operands to operate");
            operands.add(0, Operand.create(user.getLastResult().get().getValue(), userId));
            return operands;
        }

        return getLastTwoOperands(operands);
    }

    private List<Operand> getLastTwoOperands(List<Operand> operands) {
        return operands.subList(operands.size() - 2, operands.size());
    }
}
