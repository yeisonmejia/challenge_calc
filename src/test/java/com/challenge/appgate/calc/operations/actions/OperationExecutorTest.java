package com.challenge.appgate.calc.operations.actions;

import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.operands.OperandBadFormatException;
import com.challenge.appgate.calc.operations.model.operands.OperandsFinder;
import com.challenge.appgate.calc.operations.model.operators.OperationResult;
import com.challenge.appgate.calc.operations.model.user.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OperationExecutorTest {

    public OperationExecutor operationExecutor;
    public OperandsFinder operandsFinder;
    public String paramUserId;

    @BeforeEach
    void setUp() {
        operandsFinder = Mockito.mock(OperandsFinder.class);
        operationExecutor = new OperationExecutor(operandsFinder);
        paramUserId = UUID.randomUUID().toString();
    }

    @Test
    public void should_execute_initial_sum_operation() throws OperandBadFormatException {
        List<Operand> operands = givenACreatedListOfOperands(0, 10);
        when(operandsFinder.findOperandsByUserId(any())).thenReturn(operands);

        OperationResult result = operationExecutor.executeOperation(
                paramUserId,
                "sum"
        );

        assertThat(result.getValue(), is(10.0));
    }

    private List<Operand> givenACreatedListOfOperands(int x, int x1) {
        UserId userId = new UserId(paramUserId);
        List<Operand> operands = new ArrayList<>();
        operands.add(Operand.create(x, userId));
        operands.add(Operand.create(x1, userId));
        return operands;
    }

    @Test
    public void should_execute_initial_div_operation() throws OperandBadFormatException {
        List<Operand> operands = givenACreatedListOfOperands(25, 5);
        when(operandsFinder.findOperandsByUserId(any())).thenReturn(operands);

        operationExecutor = new OperationExecutor(operandsFinder);
        OperationResult result = operationExecutor.executeOperation(
                paramUserId,
                "div"
        );

        assertThat(result.getValue(), is(5.0));
    }

    @Test
    public void should_execute_initial_mult_operation() throws OperandBadFormatException {
        List<Operand> operands = givenACreatedListOfOperands(5, 5);
        when(operandsFinder.findOperandsByUserId(any())).thenReturn(operands);

        operationExecutor = new OperationExecutor(operandsFinder);
        OperationResult result = operationExecutor.executeOperation(
                paramUserId,
                "Mult"
        );

        assertThat(result.getValue(), is(25.0));
    }

    @Test
    public void should_execute_initial_sub_operation() throws OperandBadFormatException {
        List<Operand> operands = givenACreatedListOfOperands(20, 10);
        when(operandsFinder.findOperandsByUserId(any())).thenReturn(operands);

        operationExecutor = new OperationExecutor(operandsFinder);
        OperationResult result = operationExecutor.executeOperation(
                paramUserId,
                "sub"
        );

        assertThat(result.getValue(), is(10.0));
    }

    @Test
    public void should_execute_initial_pow_operation() throws OperandBadFormatException {
        List<Operand> operands = givenACreatedListOfOperands(5, 3);
        when(operandsFinder.findOperandsByUserId(any())).thenReturn(operands);

        operationExecutor = new OperationExecutor(operandsFinder);
        OperationResult result = operationExecutor.executeOperation(
                paramUserId,
                "pow"
        );

        assertThat(result.getValue(), is(125.0));
    }
}
