package com.challenge.appgate.calc.operations.system;

import com.challenge.appgate.calc.operations.model.user.User;
import com.challenge.appgate.calc.operations.model.user.UserId;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// clase que simula la base de datos
@Component
public class InMemoryDataBase {
    Map<User, Map<String, Double>> databaseUserOperands;

    public InMemoryDataBase() {
        databaseUserOperands = new HashMap<>();
    }

    synchronized public void insertUser(User user, Map<String, Double> operands) {
        databaseUserOperands.put(user, operands);
    }

    public User findUserById(String userId) {
        for (Map.Entry<User, Map<String, Double>> entry : databaseUserOperands.entrySet()) {
            if (entry.getKey().getUserIdAsString().equals(userId)) return entry.getKey();
        }
        return null;
    }

    synchronized public Map<String, Double> findOperandByUserId(String userId) {
        for (Map.Entry<User, Map<String, Double>> entry : databaseUserOperands.entrySet()) {
            if (entry.getKey().getUserIdAsString().equals(userId)) return entry.getValue();
        }
        return null;
    }
}
