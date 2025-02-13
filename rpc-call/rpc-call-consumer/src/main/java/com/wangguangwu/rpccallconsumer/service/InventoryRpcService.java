package com.wangguangwu.rpccallconsumer.service;

import com.wangguangwu.rpccallcommon.constants.RpcConstants;
import com.wangguangwu.rpccallcommon.dto.OrderRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * InventoryRpcService 处理库存查询 RPC 请求，并返回库存状态。
 *
 * @author wangguangwu
 */
@Service
public class InventoryRpcService {

    @RabbitListener(queues = RpcConstants.INVENTORY_QUEUE)
    public String handleInventoryRequest(OrderRequest request) {
        System.out.println("Inventory Service received request: " + request);
        // 模拟库存查询处理逻辑
        String response = "Inventory Available";
        System.out.println("Inventory Service sending response: " + response);
        return response;
    }
}