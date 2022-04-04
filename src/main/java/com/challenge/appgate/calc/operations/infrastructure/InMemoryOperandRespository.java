package com.challenge.appgate.calc.operations.infrastructure;

import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.operands.OperandId;
import com.challenge.appgate.calc.operations.model.operands.OperandRepository;
import com.challenge.appgate.calc.operations.model.user.UserId;
import com.challenge.appgate.calc.operations.system.InMemoryDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class InMemoryOperandRespository implements OperandRepository {
    private InMemoryDataBase dataBase;

    public InMemoryOperandRespository(InMemoryDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void saveOperand(Operand operand) {
        dataBase.findOperandByUserId(operand.getUserId().getValueAsString())
                .put(operand.getOperandIdAsString(), operand.getValue());
    }

    @Override
    public List<Operand> getOperandsByUserId(UserId userId) {
        Map<String, Double> operandByUserId = dataBase.findOperandByUserId(userId.getValueAsString());
        List<Operand> operands = new ArrayList<>();
        operandByUserId.forEach(
                (key, value) -> operands.add(
                        new Operand(
                                value,
                                userId,
                                new OperandId(UUID.fromString(key))
                        )
                )
        );
        return operands;
    }
}
