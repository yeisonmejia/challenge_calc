package com.challenge.appgate.calc.operations.model.operands;

import com.challenge.appgate.calc.operations.model.user.UserId;
import com.challenge.appgate.calc.operations.model.user.UserRepository;

import java.util.List;

public class OperandsFinder {

    private UserRepository operandRepository;

    public OperandsFinder(UserRepository operandRepository) {
        this.operandRepository = operandRepository;
    }

    public List<Operand> findOperandsByUserId(UserId userId) {
        List<Operand> operands = operandRepository.getOperandsByUserId();

        if (operands == null || operands.size() <= 1) {
            throw new InvalidOperandsNumber("you need 2 operands to operate");
        }

        return getLastTwoOperands(operands);
    }

    private List<Operand> getLastTwoOperands(List<Operand> operands) {
        return operands.subList(operands.size() - 2, operands.size());
    }
}
