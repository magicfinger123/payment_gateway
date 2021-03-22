/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.shared;

import org.springframework.stereotype.Component;

@Component
public class AppConstants {
    public static final int AFTERSALES_RECIPENTS = 1;
    public static final int SALES_RECIPENT = 2;
    public static final int HR_RECIPENTS = 3;
    public static final int FINANCE_AND_AFTERSALES = 4;
    public static final int FINANCE_AND_SALES = 5;
    public static final int TEST_RECIPENT = 6;
    public static final String ORDER_CONFIRMATION = "order_confirmation.ftl";
    public static final String ORDER_NOTIFICATION = "order_notification.ftl";
    public static final String INTRODUCTION_MAIL = "introduction.ftl";
    public static final String MAINTENANCE_PROPOSAL = "maintenance_proposal.ftl";
}
