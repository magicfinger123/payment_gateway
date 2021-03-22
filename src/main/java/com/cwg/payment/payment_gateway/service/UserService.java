/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.service;


import com.cwg.payment.payment_gateway.model.response.ApiResponse;
import com.cwg.payment.payment_gateway.shared.dto.AppVersionDto;
import com.cwg.payment.payment_gateway.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
    UserDto getUser(String username);
    ApiResponse getUserbyUserId(String userId);
    ApiResponse getAllUsers();
    ApiResponse updateUser(UserDto dto);
    ApiResponse deleteUser(String userId);
    ApiResponse updateVersion(AppVersionDto dto);
    ApiResponse checkVersion();

}
