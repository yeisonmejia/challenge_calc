package com.challenge.appgate.calc.operations.model.operators;

import com.challenge.appgate.calc.operations.model.OperationResult;
import com.challenge.appgate.calc.operations.model.operands.Operand;

import java.util.List;
import java.util.stream.Collectors;

public class PowCommand implements OperationCommand {
    private final List<Operand> operands;

    public PowCommand(Operand ...operands) {
        this.operands = List.of(operands);
    }

    @Override
    public OperationResult execute() {
        // No se puede usar reduce porque la potencia no es asociativa 2^3^2 -> (2^3)^2 <> 2^(3^2)
        List<Double> result = operands.stream()
                .map((Operand::getValue)).collect(Collectors.toList());

        Double base = result.get(0);
        for (int i = 1 ; i < result.size() ; i++) {
            Double power = result.get(i);
            base = Math.pow(base, power);
        }

        return new OperationResult(base);
    }
}
