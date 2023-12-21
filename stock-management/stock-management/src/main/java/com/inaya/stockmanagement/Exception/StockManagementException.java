package com.inaya.stockmanagement.Exception;

public class StockManagementException extends Exception {

    private String message;

    public StockManagementException(String message) {
        this.message = message;
    }
}
