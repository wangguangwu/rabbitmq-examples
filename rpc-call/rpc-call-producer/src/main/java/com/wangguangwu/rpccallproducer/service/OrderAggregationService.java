package com.wangguangwu.rpccallproducer.service;

import com.wangguangwu.rpccallcommon.constants.RpcConstants;
import com.wangguangwu.rpccallcommon.dto.OrderRequest;
import com.wangguangwu.rpccallcommon.dto.OrderResult;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrderAggregationService 用于调用库存、支付和物流服务，
 * 聚合各个 RPC 调用的结果，生成最终的订单处理结果。
 *
 * @author wangguangwu
 */
@Service
public class OrderAggregationService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public OrderAggregationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public OrderResult processOrder(OrderRequest orderRequest) {
        // 调用库存服务
        Object inventoryResponse = rabbitTemplate.convertSendAndReceive(
                RpcConstants.INVENTORY_EXCHANGE,
                RpcConstants.INVENTORY_ROUTING_KEY,
                orderRequest);

        // 调用支付服务
        Object paymentResponse = rabbitTemplate.convertSendAndReceive(
                RpcConstants.PAYMENT_EXCHANGE,
                RpcConstants.PAYMENT_ROUTING_KEY,
                orderRequest);

        // 调用物流服务
        Object logisticsResponse = rabbitTemplate.convertSendAndReceive(
                RpcConstants.LOGISTICS_EXCHANGE,
                RpcConstants.LOGISTICS_ROUTING_KEY,
                orderRequest);

        // 聚合各服务返回的结果
        OrderResult result = new OrderResult();
        result.setInventoryStatus(inventoryResponse.toString());
        result.setPaymentStatus(paymentResponse.toString());
        result.setLogisticsInfo(logisticsResponse.toString());
        return result;
    }
}
