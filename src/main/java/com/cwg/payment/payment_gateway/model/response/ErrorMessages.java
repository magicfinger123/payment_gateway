/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.response;

public enum ErrorMessages {
    USERNAME_PASSWORD_ERROR("username or password incorrect"),
    USER_ALREADY_EXIST("user already exist"),
    USER_NOT_FOUND("user not found"),
    UNABLE_TO_DELETE_USER("user not found");

    private String errormessage;

    ErrorMessages(String errprmessage) {
        this.errormessage = errprmessage;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
