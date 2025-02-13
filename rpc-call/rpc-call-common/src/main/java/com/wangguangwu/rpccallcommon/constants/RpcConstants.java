package com.wangguangwu.rpccallcommon.constants;

/**
 * RpcConstants 定义了 RPC 调用中各个下游服务使用的交换机、队列和 routing key 常量。
 *
 * @author wangguangwu
 */
public final class RpcConstants {

    // Inventory（库存）服务配置
    public static final String INVENTORY_EXCHANGE = "rpc.inventory.exchange";
    public static final String INVENTORY_QUEUE = "rpc.inventory.queue";
    public static final String INVENTORY_ROUTING_KEY = "rpc.inventory.routingkey";

    // Payment（支付）服务配置
    public static final String PAYMENT_EXCHANGE = "rpc.payment.exchange";
    public static final String PAYMENT_QUEUE = "rpc.payment.queue";
    public static final String PAYMENT_ROUTING_KEY = "rpc.payment.routingkey";

    // Logistics（物流）服务配置
    public static final String LOGISTICS_EXCHANGE = "rpc.logistics.exchange";
    public static final String LOGISTICS_QUEUE = "rpc.logistics.queue";
    public static final String LOGISTICS_ROUTING_KEY = "rpc.logistics.routingkey";

    private RpcConstants() {
    }
}
