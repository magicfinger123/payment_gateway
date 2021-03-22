/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.repository;

import com.cwg.payment.payment_gateway.io.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity,Integer> {
    UserEntity findByUsername(String username);
    UserEntity findByUserId(String userId);
    UserEntity findByEmail(String email);
}
