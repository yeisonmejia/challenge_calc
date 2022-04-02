package com.challenge.appgate.calc.operations.model.operators;

import com.challenge.appgate.calc.operations.model.OperationResult;
import com.challenge.appgate.calc.operations.model.operands.Operand;

import java.util.List;

public class MultCommand implements OperationCommand {
    private final List<Operand> operands;

    public MultCommand(Operand ...operands) {
        this.operands = List.of(operands);
    }

    @Override
    public OperationResult execute() {
        return new OperationResult(
                operands.stream().reduce(
                    new Operand(1.0),
                    (accumulate, value) -> new Operand(accumulate.getValue() * value.getValue())
                ).getValue()
        );
    }
}
