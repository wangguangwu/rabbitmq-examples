package com.wangguangwu.rpccallcommon.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 聚合后的订单处理结果
 *
 * @author wangguangwu
 */
@Data
public class OrderResult implements Serializable {

    private String inventoryStatus;
    private String paymentStatus;
    private String logisticsInfo;

}
