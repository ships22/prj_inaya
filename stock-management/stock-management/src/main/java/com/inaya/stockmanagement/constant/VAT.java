package com.inaya.stockmanagement.constant;

import lombok.Getter;

@Getter
public enum VAT {
    _10(10),
    _15(15),
    _20(20);
    private final int value;
    VAT(final int newValue) {
        value = newValue;
    }

}

