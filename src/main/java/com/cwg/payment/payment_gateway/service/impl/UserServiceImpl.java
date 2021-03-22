/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.service.impl;

import com.cwg.payment.payment_gateway.exceptions.UserServiceException;
import com.cwg.payment.payment_gateway.io.SuccessMessage;
import com.cwg.payment.payment_gateway.io.entity.AppVersionEntity;
import com.cwg.payment.payment_gateway.io.entity.UserEntity;
import com.cwg.payment.payment_gateway.model.response.ApiResponse;
import com.cwg.payment.payment_gateway.model.response.ResponseBuilder;
import com.cwg.payment.payment_gateway.repository.AppVersionRepository;
import com.cwg.payment.payment_gateway.repository.UserRepository;
import com.cwg.payment.payment_gateway.service.UserService;
import com.cwg.payment.payment_gateway.shared.Utils;
import com.cwg.payment.payment_gateway.shared.dto.AppVersionDto;
import com.cwg.payment.payment_gateway.shared.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AppVersionRepository appVersionRepository;

    @Autowired
    private Utils utils;

    @Autowired
    ResponseBuilder responseBuilder;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserDto returnValue = new UserDto();
        if (userRepository.findByUsername(userDto.getUsername())!=null) {
            throw new UserServiceException("user already exist","user already exist");
        }
        if(userRepository.findByEmail(userDto.getEmail())!=null) {
            throw new UserServiceException("user already exist","user already exist");
        }
        userDto.setUserId(utils.generateId(20));
        userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()).toString());
        userDto.setActivated(true);
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        userEntity.setRole(userDto.getRole().toLowerCase());
        UserEntity saveUser = userRepository.save(userEntity);
        BeanUtils.copyProperties(saveUser, returnValue);
        return returnValue;
    }

    @Override
    public UserDto getUser(String username) {
        UserDto returnValue = new UserDto();
         UserEntity userEntity = userRepository.findByUsername(username);
         if (userEntity == null) throw new UserServiceException("invalid username: "+username,username+": does not exist");
         BeanUtils.copyProperties(userEntity, returnValue);
        return returnValue;
    }

    @Override
    public ApiResponse getUserbyUserId(String userId) {
        UserDto returnValue = new UserDto();
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) throw new UserServiceException("invalid userid: "+userId,userId+": does not exist");
        BeanUtils.copyProperties(userEntity, returnValue);
        returnValue.setPassword("");
        returnValue.setEncryptedPassword("");
        ApiResponse apiResponse = responseBuilder.successfulResponse();
        apiResponse.responseEntity = ResponseEntity.ok(returnValue);
        return apiResponse;
    }
    @Override
    public ApiResponse getAllUsers() {
        List<UserDto> returnedValue = new ArrayList<>();
        try {
            Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
            Page<UserEntity> teamPage = userRepository.findAll(pageable);
            List<UserEntity> teamList = teamPage.getContent();
            for (UserEntity team : teamList) {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(team, userDto);
                returnedValue.add(userDto);
            }
            ApiResponse apiResponse = responseBuilder.successfulResponse();
            apiResponse.responseEntity = ResponseEntity.ok(returnedValue);
            return apiResponse;
        } catch (Exception e) {
            throw new UserServiceException("Unable to create schedule","something went wrong: "+e.getLocalizedMessage());
        }
    }


    @Override
    public ApiResponse updateUser(UserDto userDto) {
        UserDto returnValue = new UserDto();
        log.debug("debug",userDto.getUserId());
        UserEntity u = userRepository.findByUserId(userDto.getUserId());
        if (u == null) {
            throw new UserServiceException("user does not exist","user does not exist");
        }
        if (userDto.getPassword() == null || userDto.getPassword().equals("")) {
            userDto.setEncryptedPassword(u.getEncryptedPassword());
            userDto.setPassword(u.getPassword());
        }
        else
            userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()).toString());
        userDto.setActivated(true);
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        userEntity.setRole(userDto.getRole().toLowerCase());
        userEntity.setId(u.getId());
        UserEntity saveUser = userRepository.save(userEntity);
        BeanUtils.copyProperties(saveUser, returnValue);
        ApiResponse apiResponse = responseBuilder.successfulResponse();
        apiResponse.responseEntity = ResponseEntity.ok(returnValue);
        return apiResponse;
    }

    @Override
    public ApiResponse deleteUser(String userId) {
        UserEntity u = userRepository.findByUserId(userId);
        if (u == null) {
            throw new UserServiceException("user does not exist","user does not exist");
        }
        userRepository.delete(u);
        ApiResponse apiResponse = responseBuilder.successfulResponse();
        SuccessMessage successMessage = SuccessMessage.builder().message("User "+u.getLast_name()+" "+u.getLast_name()+" has been deleted").build();
        apiResponse.responseEntity = ResponseEntity.ok(successMessage);
        return apiResponse;
    }

    @Override
    public ApiResponse updateVersion(AppVersionDto dto) {
        dto.setId(1);
        AppVersionEntity r = new AppVersionEntity();
        BeanUtils.copyProperties(dto, r);
        appVersionRepository.save(r);
        ApiResponse apiResponse = responseBuilder.successfulResponse();
        apiResponse.responseEntity = ResponseEntity.ok(r);
        return apiResponse;
    }

    @Override
    public ApiResponse checkVersion() {
        AppVersionEntity r = appVersionRepository.findById(1);
        if (r == null){
         throw new UserServiceException("no app version available","no app version available");
        }
        ApiResponse apiResponse = responseBuilder.successfulResponse();
        apiResponse.responseEntity = ResponseEntity.ok(r);
        return apiResponse;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(s);
        if (userEntity == null) throw new UserServiceException("invalid login credentials","user: "+s+" not founnd");
        return new User(userEntity.getUsername(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}
