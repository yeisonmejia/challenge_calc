package com.challenge.appgate.calc.operations.model.user;

import com.challenge.appgate.calc.operations.model.user.InvalidUserId;

import java.util.UUID;

public class UserId {
    private UUID value;

    public UserId(UUID userId) {
        if (userId == null) throw new InvalidUserId("User id can not be null");
        this.value = userId;
    }

    public UserId(String userIdParam) {
        try {
            this.value = UUID.fromString(userIdParam);
        } catch (IllegalArgumentException e) {
            throw new InvalidUserId("Invalid User Id format");
        }
    }

    public UUID getValue() {
        return this.value;
    }

    public String getValueAsString() {
        return value.toString();
    }
}
