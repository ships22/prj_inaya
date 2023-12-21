package com.inaya.stockmanagement.constant;

import lombok.Getter;

@Getter
public enum STATUS {

    PENDING("PENDING"), SENT("SENT"), COMPLETED("COMPLETED");

    private final String value;

    STATUS(final String newValue) {
        this.value = newValue;
    }

}
