package com.challenge.appgate.calc.operations.model.operators;

import com.challenge.appgate.calc.operations.model.operands.Operand;

import java.util.List;
import java.util.stream.Collectors;

public class DivCommand implements OperationCommand {
    private final List<Operand> operands;

    public DivCommand(Operand ...operands) {
        this.operands = List.of(operands);
    }

    @Override
    public OperationResult execute() {
        // No se puede usar reduce porque la division no es una operacion asosiativa
        List<Double> result = operands.stream()
                .map((Operand::getValue)).collect(Collectors.toList());

        Double accumulator = result.get(0);
        for (int i = 1 ; i < result.size() ; i++) {
            Double divisor = result.get(i);
            if (divisor == 0) throw new DivisionByZeroExeption("The divisor can't be Zero");
            accumulator = accumulator / divisor;
        }

        return new OperationResult(accumulator);
    }
}
