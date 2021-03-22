/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.io.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "app_version")
@Data
public class AppVersionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int versionCode;
    @Column(nullable = false)
    private String versionName;
    @Column(nullable = false)
    private String uploadUrl;
    @Column(nullable = false)
    private Boolean isUpdate;
}
