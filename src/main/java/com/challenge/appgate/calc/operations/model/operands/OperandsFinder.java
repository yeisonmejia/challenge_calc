package com.challenge.appgate.calc.operations.model.operands;

import com.challenge.appgate.calc.operations.model.operators.UserId;

import java.util.List;

public class OperandsFinder {

    private OperandRepository operandRepository;

    public OperandsFinder(OperandRepository operandRepository) {
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
