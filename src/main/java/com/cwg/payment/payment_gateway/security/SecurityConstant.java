/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.security;


import com.cwg.payment.payment_gateway.SpringApplicationContext;
import com.cwg.payment.payment_gateway.app.ApplicationProperties;

public class SecurityConstant {
    public static final long EXPIRATION_TIME = 864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/user/**";
    public static final String PAYMENRT_URL = "/payment/**";
    public static final String VERIFY = "/order";
    //public static final String TOKEN_SECRET = "uT_9uh0whr42o1hb";
    public static String getTokenSecret()
    {
        ApplicationProperties applicationProperties = (ApplicationProperties) SpringApplicationContext.getBean("ApplicationProperties");
        return applicationProperties.getTokenSecret();
    }
}
