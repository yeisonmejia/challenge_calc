package com.challenge.appgate.calc.operations.model.operands;

import com.challenge.appgate.calc.operations.model.user.UserId;

public class OperandsFlush {
    private OperandRepository operandRepository;

    public OperandsFlush(OperandRepository operandRepository) {
        this.operandRepository = operandRepository;
    }

    public void invoke (UserId userId) {
        operandRepository.flushOperands(userId);
    }
}
