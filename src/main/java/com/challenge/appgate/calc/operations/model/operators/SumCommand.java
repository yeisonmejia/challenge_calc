package com.challenge.appgate.calc.operations.model.operators;

import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.OperationResult;

import java.util.List;

public class SumCommand implements OperationCommand {
    List<Operand> operands;

    public SumCommand(Operand ...operands) {
        this.operands = List.of(operands);
    }

    @Override
    public OperationResult execute() {
        Double result = operands.stream()
                .map((Operand::getValue))
                .reduce(0.0, Double::sum);
        return new OperationResult(result);
    }
}
