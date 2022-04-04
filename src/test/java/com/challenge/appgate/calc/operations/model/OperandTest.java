package com.challenge.appgate.calc.operations.model;

import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.operands.OperandBadFormatException;
import com.challenge.appgate.calc.operations.model.operands.OperandId;
import com.challenge.appgate.calc.operations.model.user.UserId;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OperandTest {

    @Test
    void should_create_operand_from_integer() throws OperandBadFormatException {
        Operand op = new Operand(20, new UserId(UUID.randomUUID()), new OperandId(UUID.randomUUID()));
        MatcherAssert.assertThat(op.getValue().intValue(), CoreMatchers.is(20));
    }

    @Test
    void should_create_operand_from_double() throws OperandBadFormatException {
        Operand op = new Operand(20.0, new UserId(UUID.randomUUID()), new OperandId(UUID.randomUUID()));
        MatcherAssert.assertThat(op.getValue(), CoreMatchers.is(20.0) );
    }

    @Test
    void should_create_operand_from_integer_in_string() throws OperandBadFormatException {
        Operand op = new Operand("20", new UserId(UUID.randomUUID()), new OperandId(UUID.randomUUID()));
        MatcherAssert.assertThat(op.getValue(), CoreMatchers.is(20.0) );
    }

    @Test
    void should_create_operand_from_doubles_in_string() throws OperandBadFormatException {
        Operand op = new Operand("20.0", new UserId(UUID.randomUUID()), new OperandId(UUID.randomUUID()));
        MatcherAssert.assertThat(op.getValue(), CoreMatchers.is(20.0) );

        assertThrows(
                OperandBadFormatException.class,
                () -> new Operand("22,1", new UserId(UUID.randomUUID()), new OperandId(UUID.randomUUID()))
        );
    }

    @Test
    void should_throw_exception_when_string_is_empty() {
        assertThrows(
                OperandBadFormatException.class,
                () -> new Operand("", new UserId(UUID.randomUUID()), new OperandId(UUID.randomUUID()))
        );

    }
}
