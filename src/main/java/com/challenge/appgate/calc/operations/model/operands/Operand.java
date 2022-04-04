package com.challenge.appgate.calc.operations.model.operands;

import com.challenge.appgate.calc.operations.model.user.UserId;

import java.util.UUID;

public class Operand {
    private OperandId operandId;
    private UserId userId;
    private Double value;

    public Operand(Double value, UserId userId, OperandId operandId) throws OperandBadFormatException {
        createOperand(String.valueOf(value), userId, operandId);
    }

    public Operand(Integer value, UserId userId, OperandId operandId) throws OperandBadFormatException {
        createOperand(String.valueOf(value), userId, operandId);
    }

    public Operand(String value, UserId userId, OperandId operandId) throws OperandBadFormatException {
        createOperand(String.valueOf(value), userId, operandId);
    }

    private void createOperand(String value, UserId userId, OperandId operandId) throws OperandBadFormatException {
        this.userId = userId;
        this.operandId = operandId;
        try {
            this.value = Double.valueOf(value);
        } catch (NumberFormatException e) {
            throw new OperandBadFormatException(e);
        }
    }

    public static Operand create(int value, UserId userId) throws OperandBadFormatException {
        return  new Operand(value, userId, new OperandId(UUID.randomUUID()));
    }

    public static Operand create(double value, UserId userId) throws OperandBadFormatException {
        return  new Operand(value, userId, new OperandId(UUID.randomUUID()));
    }

    public static Operand create(String value, UserId userId) throws OperandBadFormatException {
        return  new Operand(value, userId, new OperandId(UUID.randomUUID()));
    }

    public Double getValue() {
        return value;
    }

    public OperandId getOperandId() {
        return operandId;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getOperandIdAsString() {
        return this.operandId.getValueAsString();
    }
}
