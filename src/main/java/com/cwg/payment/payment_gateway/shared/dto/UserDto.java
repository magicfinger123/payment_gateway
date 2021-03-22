/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.shared.dto;

import lombok.Data;

@Data
public class UserDto {
    public static final long serialVersionUID = 7168715137979527464L;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String department;
    private String userId;
    private String job_title;
    private String password;
    private String encryptedPassword;
    private String role;
    private Boolean activated;
}
