package com.challenge.appgate.calc.operations.actions;

import com.challenge.appgate.calc.operations.model.*;
import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.operands.OperandBadFormatException;
import com.challenge.appgate.calc.operations.model.operands.OperandsFinder;
import com.challenge.appgate.calc.operations.model.operators.OperationCommand;
import com.challenge.appgate.calc.operations.model.operators.OperationFactory;
import com.challenge.appgate.calc.operations.model.operators.OperatorEnum;
import com.challenge.appgate.calc.operations.model.operators.UserId;

import java.util.List;
import java.util.Locale;

public class OperationExecutor {

    private OperandsFinder operandsFinder;

    public OperationExecutor(OperandsFinder operandsFinder) {
        this.operandsFinder = operandsFinder;
    }

    public OperationResult executeOperation(String userId, String operatorName) throws OperandBadFormatException {
        List<Operand> operands = operandsFinder.findOperandsByUserId(new UserId(userId));

        OperatorEnum operator = OperatorEnum.valueOf(
                operatorName.toUpperCase(Locale.ROOT)
        );

        OperationCommand command = OperationFactory.create(
                operator,
                operands.toArray(new Operand[operands.size()])
        );
        return command.execute();
    }
}
