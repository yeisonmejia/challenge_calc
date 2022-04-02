package com.challenge.appgate.calc.operations.model.operands;

import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.operators.UserId;

import java.util.List;

public interface OperandRepository {
    public void save(UserId userId, Operand operand);
    public List<Operand> getOperatorsByUserIdOrderAsStack(UserId userId);

    List<Operand> getOperandsByUserId();
}
