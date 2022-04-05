package com.challenge.appgate.calc.operations.system;

import com.challenge.appgate.calc.operations.model.operands.Operand;
import com.challenge.appgate.calc.operations.model.user.User;
import com.challenge.appgate.calc.operations.model.user.UserId;
import com.challenge.appgate.calc.operations.model.user.UserNotExistException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// clase que simula la base de datos
@Component
public class InMemoryDataBase {
    Map<String, Map<String, Double>> operandsTable;
    Map<String , User> userTable;

    public InMemoryDataBase() {
        operandsTable = new HashMap<>();
        userTable = new HashMap<>();
    }

    synchronized public void insertUser(User user) {
        userTable.put(user.getUserIdAsString(), user);
    }

    synchronized public void insertOperand(UserId userId, Operand operand) {
        if (findUserById(userId.getValueAsString()) == null) {
            throw new UserNotExistException("User does not exist");
        }

        if (!operandsTable.containsKey(userId.getValueAsString())) {
            operandsTable.put(userId.getValueAsString(), new HashMap<>());
        }

        operandsTable.get(userId.getValueAsString()).put(
                operand.getOperandIdAsString(),
                operand.getValue()
                );
    }

    public User findUserById(String userId) {
        for (Map.Entry<String, User> entry : userTable.entrySet()) {
            if (entry.getKey().equals(userId)) return entry.getValue();
        }
        return null;
    }

    synchronized public Map<String, Double> findOperandByUserId(String userId) {
        for (Map.Entry<String, Map<String, Double>> entry : operandsTable.entrySet()) {
            if (entry.getKey().equals(userId)) return entry.getValue();
        }
        return null;
    }
}
