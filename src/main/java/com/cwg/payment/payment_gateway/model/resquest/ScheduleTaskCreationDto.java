/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.resquest;

import lombok.Data;

@Data
public class ScheduleTaskCreationDto {
    private String scheduleId;
    private String taskName;
    private String taskAction;
    private Boolean taskStatus;
    private String email;
    private String teamLead;
    private String date;
    private String genSize;
    private String genLocation;
    private String genEngineSerial;
}
