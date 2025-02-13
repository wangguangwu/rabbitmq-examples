package com.wangguangwu.rpccallconsumer.service;

import com.wangguangwu.rpccallcommon.constants.RpcConstants;
import com.wangguangwu.rpccallcommon.dto.OrderRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * PaymentRpcService 处理支付 RPC 请求，并返回支付结果。
 *
 * @author wangguangwu
 */
@Service
public class PaymentRpcService {

    @RabbitListener(queues = RpcConstants.PAYMENT_QUEUE)
    public String handlePaymentRequest(OrderRequest request) {
        System.out.println("Payment Service received request: " + request);
        // 模拟支付处理逻辑
        String response = "Payment Successful";
        System.out.println("Payment Service sending response: " + response);
        return response;
    }
}
