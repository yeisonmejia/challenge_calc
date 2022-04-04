package com.challenge.appgate.calc.operations.model.user;

import com.challenge.appgate.calc.operations.model.operators.OperationResult;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class User {
    private final UserId userId;
    private final Optional<OperationResult> lastResult;


    public User(UserId userId, Optional<OperationResult> lastResult) {
        this.userId = userId;
        this.lastResult = lastResult;
    }

    public static User create() {
        return new User(
                new UserId(UUID.randomUUID()),
                Optional.empty()
                );
    }

    public UserId getUserId() {
        return userId;
    }

    public String getUserIdAsString(){
        return userId.getValue().toString();
    }

    public Optional<OperationResult> getLastResult() {
        return lastResult;
    }

}
