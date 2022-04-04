package com.challenge.appgate.calc.operations.model.user;

import com.challenge.appgate.calc.operations.model.operands.Operand;

import java.util.List;

public interface UserRepository {
    public void save(UserId userId, Operand operand);
    public List<Operand> getOperatorsByUserIdOrderAsStack(UserId userId);

    List<Operand> getOperandsByUserId();
    User findUserById(UserId userId);
}
