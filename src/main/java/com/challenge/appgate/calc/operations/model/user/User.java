package com.challenge.appgate.calc.operations.model.user;

import com.challenge.appgate.calc.operations.model.operators.OperationResult;

import java.util.Optional;
import java.util.UUID;

public class User {
    private final UserId userId;
    private final Optional<OperationResult> lastResult;


    public User(UserId userId, Optional<OperationResult> lastResult) {
        this.userId = userId;
        this.lastResult = lastResult;
    }

    public static User create(UUID userId) {
        return new User(
                new UserId(userId),
                Optional.empty()
                );
    }

    public UserId getUserId() {
        return userId;
    }

    public Optional<OperationResult> getLastResult() {
        return lastResult;
    }
}
