package com.wangguangwu.topicexchangecommon.constants;

/**
 * RoutingKey 常量类，用于存放所有路由键
 *
 * @author wangguangwu
 */
public final class StockRoutingKeyConstants {

    // A 股 routing key
    public static final String STOCK_A_ROUTING_KEY = "routingkey.stock.A";
    // 美股 routing key
    public static final String STOCK_US_ROUTING_KEY = "routingkey.stock.US";
    // 港股 routing key
    public static final String STOCK_HK_ROUTING_KEY = "routingkey.stock.HK";
    // all 市场 routing key
    public static final String STOCK_ALL_ROUTING_KEY = "routingkey.stock.#";

    private StockRoutingKeyConstants() {
        // 私有构造方法，防止实例化
    }
}
