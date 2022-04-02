package com.challenge.appgate.calc.operations.infrastructure;

import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.operands.OperandRepository;
import com.challenge.appgate.calc.operations.model.operators.UserId;
import org.apache.catalina.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryOperandRepository implements OperandRepository {
    private Map<String, List<Operand>> dataBase;

    public InMemoryOperandRepository() {
        this.dataBase = new HashMap<>();
    }

    @Override
    public List<Operand> getOperatorsByUserIdOrderAsStack(UserId userId) {
        return null;
    }

    public void save(UserId userId, Operand operand) {
        List<Operand> userOperands = this.dataBase.get(userId.getValue());
//        if (userOperands == null) throw new
//            userOperands.add(operand);

    }

    @Override
    public List<Operand> getOperandsByUserId() {
        return null;
    }
}
