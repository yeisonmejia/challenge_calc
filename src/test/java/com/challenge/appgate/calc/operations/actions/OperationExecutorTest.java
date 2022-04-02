package com.challenge.appgate.calc.operations.actions;

import com.challenge.appgate.calc.operations.model.*;
import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.operands.OperandBadFormatException;
import com.challenge.appgate.calc.operations.model.operands.OperandsFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OperationExecutorTest {

    public OperationExecutor operationExecutor;

//    @BeforeEach
//    void setUp() {
////        OperandRepository operandRepository = new OperandRepository() {
////            @Override
////            public List<Operand> getOperatorsByUserId(UserId userId) {
////                return new ArrayList<>(List.of(new Operand(10)));
////            }
////        };
////        operationExecutor = new OperationExecutor(operandRepository);
//    }

    @Test
    public void should_execute_initial_sum_operation() throws OperandBadFormatException {
        OperandsFinder operandsFinder = Mockito.mock(OperandsFinder.class);
        List<Operand> operands = new ArrayList<>();
        operands.add(new Operand(0));
        operands.add(new Operand(10));
        when(operandsFinder.findOperandsByUserId(any())).thenReturn(operands);

        operationExecutor = new OperationExecutor(operandsFinder);
        OperationResult result = operationExecutor.executeOperation(
                "pedro",
                "sum"
        );

        assertThat(result.getValue(), is(10.0));
    }

    @Test
    public void should_execute_initial_div_operation() throws OperandBadFormatException {
        OperandsFinder operandsFinder = Mockito.mock(OperandsFinder.class);
        List<Operand> operands = new ArrayList<>();
        operands.add(new Operand(25));
        operands.add(new Operand(5));
        when(operandsFinder.findOperandsByUserId(any())).thenReturn(operands);

        operationExecutor = new OperationExecutor(operandsFinder);
        OperationResult result = operationExecutor.executeOperation(
                "pedro",
                "div"
        );

        assertThat(result.getValue(), is(5.0));
    }

    @Test
    public void should_execute_initial_mult_operation() throws OperandBadFormatException {
        OperandsFinder operandsFinder = Mockito.mock(OperandsFinder.class);
        List<Operand> operands = new ArrayList<>();
        operands.add(new Operand(5));
        operands.add(new Operand(5));
        when(operandsFinder.findOperandsByUserId(any())).thenReturn(operands);

        operationExecutor = new OperationExecutor(operandsFinder);
        OperationResult result = operationExecutor.executeOperation(
                "pedro",
                "Mult"
        );

        assertThat(result.getValue(), is(25.0));
    }

    @Test
    public void should_execute_initial_sub_operation() throws OperandBadFormatException {
        OperandsFinder operandsFinder = Mockito.mock(OperandsFinder.class);
        List<Operand> operands = new ArrayList<>();
        operands.add(new Operand(20));
        operands.add(new Operand(10));
        when(operandsFinder.findOperandsByUserId(any())).thenReturn(operands);

        operationExecutor = new OperationExecutor(operandsFinder);
        OperationResult result = operationExecutor.executeOperation(
                "pedro",
                "sub"
        );

        assertThat(result.getValue(), is(10.0));
    }
}
