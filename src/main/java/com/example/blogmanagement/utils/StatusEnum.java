package com.example.blogmanagement.utils;

public enum StatusEnum {
    DRAFT("draft"),
    RELEASED("released"),
    ACTIVE("active"),
    INACTIVE("inactive");

    private final String code;

    private StatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
