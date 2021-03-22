/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
    @Autowired
    private Environment env;

    public String getTokenSecret(){
       // return env.getProperty("token_secret");
        return "hudqwkjdndbewhk";
    }
}
