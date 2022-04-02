package com.challenge.appgate.calc.operations.model.operators;

import com.challenge.appgate.calc.operations.model.OperationResult;
import com.challenge.appgate.calc.operations.model.operands.Operand;

import java.util.List;
import java.util.Optional;

public class SubCommand implements OperationCommand {

    private final List<Operand> operands;

    public SubCommand(Operand ...operands) {
        this.operands = List.of(operands);
    }

    @Override
    public OperationResult execute() {
        Optional<Operand> result =  operands.stream().reduce(
                (accumulate, value) -> new Operand(accumulate.getValue() - value.getValue())
        );

        if (result.isPresent()) return new OperationResult(result.get().getValue());
        throw new OperationFailExeption("After Operate result is empty");
    }
}
