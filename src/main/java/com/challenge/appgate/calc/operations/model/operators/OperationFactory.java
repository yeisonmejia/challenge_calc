package com.challenge.appgate.calc.operations.model.operators;

import com.challenge.appgate.calc.operations.model.operands.Operand;

public class OperationFactory {
    public static OperationCommand create(OperatorEnum operation, Operand...operands) {
        switch (operation) {
            case SUM :
                return new SumCommand(operands);
            case DIV:
                return new DivCommand(operands);
            case MULT:
                return new MultCommand(operands);
            case SUB:
                return new SubCommand(operands);
            case POW:
                return new PowCommand(operands);
            default:
                throw new OperationNotSupportedException(
                        String.format("The operation '%s' is not supported", operation)
                );
        }
    }
}
