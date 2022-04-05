package com.challenge.appgate.calc.operations.system;

import com.challenge.appgate.calc.operations.actions.OperationExecutor;
import com.challenge.appgate.calc.operations.infrastructure.InMemoryOperandRespository;
import com.challenge.appgate.calc.operations.model.operands.OperandRepository;
import com.challenge.appgate.calc.operations.model.operands.OperandsFinder;
import com.challenge.appgate.calc.operations.model.operands.OperandsFlush;
import com.challenge.appgate.calc.operations.model.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringOperationConfiguration {
    @Bean
    public OperationExecutor operationExecutor(OperandsFinder operandsFinder, UserRepository userRepository, OperandsFlush operandsFlush) {
        return new OperationExecutor(operandsFinder, userRepository, operandsFlush);
    }

}
