package com.daily.product.users.msg;

public enum Login {
    SUCCESS("Successful."),
    EMPTY("Empty Data."),
    LOCK("Account is locked."),
    WITHDRAWAL("Withdrawn user."),
    NOT_MATCH_PASSWORD("Invalid password.");

    private final String value;
    Login(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}