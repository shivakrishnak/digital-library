package com.shiva.exception;

import java.util.function.Supplier;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String msg) {
        super(msg);
    }
}
