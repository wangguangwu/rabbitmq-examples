package com.wangguangwu.rpccallcommon.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单请求数据
 *
 * @author wangguangwu
 */
@Data
public class OrderRequest implements Serializable {

    private String orderId;
    private String product;
    private int quantity;
    private double amount;

}
