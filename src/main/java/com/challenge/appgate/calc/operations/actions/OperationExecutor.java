package com.challenge.appgate.calc.operations.actions;

import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.operands.OperandBadFormatException;
import com.challenge.appgate.calc.operations.model.operands.OperandsFinder;
import com.challenge.appgate.calc.operations.model.operands.OperandsFlush;
import com.challenge.appgate.calc.operations.model.operators.OperationCommand;
import com.challenge.appgate.calc.operations.model.operators.OperationFactory;
import com.challenge.appgate.calc.operations.model.operators.OperationResult;
import com.challenge.appgate.calc.operations.model.operators.OperatorEnum;
import com.challenge.appgate.calc.operations.model.user.User;
import com.challenge.appgate.calc.operations.model.user.UserId;
import com.challenge.appgate.calc.operations.model.user.UserRepository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class OperationExecutor {

    private OperandsFinder operandsFinder;
    private UserRepository userRepository;
    private OperandsFlush operandsFlush;

    public OperationExecutor(OperandsFinder operandsFinder, UserRepository userRepository, OperandsFlush operandsFlush) {
        this.operandsFinder = operandsFinder;
        this.userRepository = userRepository;
        this.operandsFlush = operandsFlush;
    }

    public OperationResult executeOperation(String userIdParam, String operatorName) throws OperandBadFormatException {
        UserId userId = new UserId(userIdParam);
        List<Operand> operands = operandsFinder.findOperandsByUserId(userId);

        OperatorEnum operator = OperatorEnum.valueOf(
                operatorName.toUpperCase(Locale.ROOT)
        );

        OperationCommand command = OperationFactory.create(
                operator,
                operands.toArray(new Operand[operands.size()])
        );

        OperationResult result = command.execute();
        User user = new User(userId, Optional.of(result));
        userRepository.save(user);

        // hacer el flush
        operandsFlush.invoke(userId);

        return command.execute();
    }
}
