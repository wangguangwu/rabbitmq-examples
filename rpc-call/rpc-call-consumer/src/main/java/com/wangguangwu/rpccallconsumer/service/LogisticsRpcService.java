package com.wangguangwu.rpccallconsumer.service;

import com.wangguangwu.rpccallcommon.constants.RpcConstants;
import com.wangguangwu.rpccallcommon.dto.OrderRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * LogisticsRpcService 处理物流 RPC 请求，并返回物流计算结果。
 *
 * @author wangguangwu
 */
@Service
public class LogisticsRpcService {

    @RabbitListener(queues = RpcConstants.LOGISTICS_QUEUE)
    public String handleLogisticsRequest(OrderRequest request) {
        System.out.println("Logistics Service received request: " + request);
        // 模拟物流计算逻辑
        String response = "Delivery in 3 days";
        System.out.println("Logistics Service sending response: " + response);
        return response;
    }
}