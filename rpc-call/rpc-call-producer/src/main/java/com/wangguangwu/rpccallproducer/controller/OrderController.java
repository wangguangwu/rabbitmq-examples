package com.wangguangwu.rpccallproducer.controller;

import com.wangguangwu.rpccallcommon.dto.OrderRequest;
import com.wangguangwu.rpccallcommon.dto.OrderResult;
import com.wangguangwu.rpccallproducer.service.OrderAggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController 提供订单聚合服务的 HTTP 接口，
 * 调用 OrderAggregationService 进行 RPC 调用，聚合库存、支付和物流服务的响应。
 *
 * @author wangguangwu
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderAggregationService aggregationService;

    @Autowired
    public OrderController(OrderAggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    /**
     * 处理订单请求，聚合下游服务的响应结果。
     *
     * @param orderRequest 请求体，包含订单信息
     * @return 聚合后的订单处理结果
     */
    @PostMapping("/process")
    public OrderResult processOrder(@RequestBody OrderRequest orderRequest) {
        return aggregationService.processOrder(orderRequest);
    }
}
