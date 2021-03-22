/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.exceptions;

public class FileStorageException extends RuntimeException {

        private static final long serialVersionUID = 1L;
        private String msg;

        public FileStorageException(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }


