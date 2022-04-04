package com.challenge.appgate.calc.operations.actions;

import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.operands.OperandRepository;
import com.challenge.appgate.calc.operations.model.user.UserId;
import com.challenge.appgate.calc.operations.model.user.User;
import com.challenge.appgate.calc.operations.model.user.UserRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class )
class OperandSaverTest {

    @Test
    void should_save_operand() {
        String userParam = UUID.randomUUID().toString();
        UserId userId = new UserId(userParam);
        User user = new User(
                userId,
                Optional.empty()
        );
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findUserById(any())).thenReturn(user);

        String operandParam = "20";
        OperandRepository operandRepository = mock(OperandRepository.class);

        OperandSaver operandSaver = new OperandSaver(userRepository, operandRepository);
        operandSaver.saveOperandForUser(userParam, operandParam);

        ArgumentCaptor<Operand> operandArgumentCaptor = ArgumentCaptor.forClass(Operand.class);
        verify(operandRepository).saveOperand(operandArgumentCaptor.capture());
        assertThat(operandArgumentCaptor.getValue().getUserId().getValue().toString(), is(userParam));
        assertThat(operandArgumentCaptor.getValue().getValue(), is(Double.valueOf(operandParam)));
    }
}
