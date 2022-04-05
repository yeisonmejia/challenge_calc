package com.challenge.appgate.calc.operations.system;

import com.challenge.appgate.calc.operations.actions.OperandSaver;
import com.challenge.appgate.calc.operations.infrastructure.AddOperandController;
import com.challenge.appgate.calc.operations.infrastructure.InMemoryOperandRespository;
import com.challenge.appgate.calc.operations.model.operands.OperandRepository;
import com.challenge.appgate.calc.operations.model.operands.OperandsFinder;
import com.challenge.appgate.calc.operations.model.operands.OperandsFlush;
import com.challenge.appgate.calc.operations.model.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringOperandConfiguration {

    @Bean
    public OperandSaver operandSaver(UserRepository userRepository, OperandRepository operandRepository) {
        return new OperandSaver(userRepository, operandRepository);
    }

    @Bean
    public OperandsFinder operandsFinder(OperandRepository operandRepository, UserRepository userRepository) {
        return new OperandsFinder(operandRepository, userRepository);
    }

    @Bean
    public OperandRepository operandRepository(InMemoryDataBase inMemoryDataBase) {
        return new InMemoryOperandRespository(inMemoryDataBase);
    }

    @Bean
    public OperandsFlush operandsFlush(OperandRepository operandRepository){
        return new OperandsFlush(operandRepository);
    }
}
