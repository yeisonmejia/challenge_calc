package com.challenge.appgate.calc.operations.model.operands;

public class Operand {
    private Double value;

    public Operand(Double value) throws OperandBadFormatException {
        createOperand(String.valueOf(value));
    }

    public Operand(Integer value) throws OperandBadFormatException {
        createOperand(String.valueOf(value));
    }

    public Operand(String value) throws OperandBadFormatException {
        createOperand(String.valueOf(value));
    }

    private void createOperand(String value) throws OperandBadFormatException {
        try {
            this.value = Double.valueOf(value);
        } catch (NumberFormatException e) {
            throw new OperandBadFormatException(e);
        }
    }

    public static Operand create(int value) throws OperandBadFormatException {
        return  new Operand(value);
    }

    public static Operand create(double value) throws OperandBadFormatException {
        return  new Operand(value);
    }

    public static Operand create(String value) throws OperandBadFormatException {
        return  new Operand(value);
    }

    public Double getValue() {
        return value;
    }
}
