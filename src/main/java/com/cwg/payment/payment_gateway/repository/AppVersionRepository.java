/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.repository;

import com.cwg.payment.payment_gateway.io.entity.AppVersionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppVersionRepository extends PagingAndSortingRepository<AppVersionEntity,Integer> {
    AppVersionEntity findById(int id);
}
