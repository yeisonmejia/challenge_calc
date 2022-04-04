package com.challenge.appgate.calc.operations.actions;

import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.operands.OperandRepository;
import com.challenge.appgate.calc.operations.model.user.UserId;
import com.challenge.appgate.calc.operations.model.user.User;
import com.challenge.appgate.calc.operations.model.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class )
class OperandSaverTest {

    @Test
    void should_save_operand() {
        String userParam = UUID.randomUUID().toString();
        String operandParam = "20";

        UserId userId = new UserId(userParam);
        User user = new User(
                userId,
                Optional.empty()
        );
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findUserById(userId)).thenReturn(user);

        Operand operand = Operand.create(operandParam, new UserId(userParam));
        OperandRepository operandRepository = mock(OperandRepository.class);


        OperandSaver operandSaver = new OperandSaver(userRepository, operandRepository);
        operandSaver.saveOperandForUser(userParam, operandParam);

        verify(operandRepository).saveOperand(operand);
    }
}
