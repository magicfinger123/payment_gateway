/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.response;


import lombok.Data;

@Data
public class UserRest {
    private String first_name;
    private String last_name;
    private String username;
    private String department;
    private String userId;
    private String email;
    private String job_title;
    private String role;
    private Boolean activated;
}
