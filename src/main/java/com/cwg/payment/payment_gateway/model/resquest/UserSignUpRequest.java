/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.resquest;

import lombok.Data;

@Data
public class UserSignUpRequest {
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String department;
    private String job_title;
    private String password;
    private String role;
}
