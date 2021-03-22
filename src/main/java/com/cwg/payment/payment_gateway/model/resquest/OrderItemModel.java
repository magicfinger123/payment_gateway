/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.resquest;

import lombok.Data;

@Data
public class OrderItemModel {

    private String orderItemId;
    private String productId;
    private String productName;
    private String productDescription;
    private String productImageUrl;
    private String amount;
    private Integer quantity;
    private String commonName;
    private String categoryName;
}
