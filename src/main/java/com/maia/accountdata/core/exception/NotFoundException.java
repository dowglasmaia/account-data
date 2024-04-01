package com.maia.accountdata.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;

public class NotFoundException extends RestClientException {
    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(String msg, HttpStatus httpStatus) {
        super(msg);
    }
}
