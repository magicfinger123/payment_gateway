/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.shared.dto;

import lombok.Data;


@Data
public class AppVersionDto {
    private int id;
    private int versionCode;
    private String versionName;
    private String uploadUrl;
    private Boolean isUpdate;

}
