package com.challenge.appgate.calc.operations.model.operators;

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
        Optional<Double> result =  operands.stream()
                    .map(Operand::getValue)
                    .reduce(
                        (accumulate, value) -> accumulate - value
                    );

        if (result.isPresent()) return new OperationResult(result.get());
        throw new OperationFailExeption("After Operate result is empty");
    }
}
