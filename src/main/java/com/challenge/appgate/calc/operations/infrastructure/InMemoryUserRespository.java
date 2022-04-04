package com.challenge.appgate.calc.operations.infrastructure;

import com.challenge.appgate.calc.operations.model.user.User;
import com.challenge.appgate.calc.operations.model.user.UserId;
import com.challenge.appgate.calc.operations.model.user.UserRepository;
import com.challenge.appgate.calc.operations.system.InMemoryDataBase;

import java.util.HashMap;

public class InMemoryUserRespository implements UserRepository {
    private InMemoryDataBase dataBase;

    public InMemoryUserRespository(InMemoryDataBase dataBase) {
        // simula una conexion a la db
        this.dataBase = dataBase;
    }


    @Override
    public void save(User user) {
        dataBase.insertUser(user, new HashMap<>());
    }

    @Override
    public User findUserById(UserId userId) {
        return dataBase.findUserById(userId.getValueAsString());
    }
}
