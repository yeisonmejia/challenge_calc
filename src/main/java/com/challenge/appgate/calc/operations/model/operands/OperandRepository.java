package com.challenge.appgate.calc.operations.model.operands;

import com.challenge.appgate.calc.operations.model.user.UserId;

import java.util.List;

public interface OperandRepository {
    void saveOperand(Operand operand);
    List<Operand> getOperandsByUserId(UserId userId);
}
