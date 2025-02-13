package com.wangguangwu.topicexchangecommon.constants;

/**
 * 队列常量类，用于存放所有队列名称
 *
 * @author wangguangwu
 */
public final class StockQueueConstants {

    // A 股队列
    public static final String QUEUE_STOCK_A = "queue.stock.A";
    // 美股队列
    public static final String QUEUE_STOCK_US = "queue.stock.US";
    // 港股队列
    public static final String QUEUE_STOCK_HK = "queue.stock.HK";
    // 所有市场队列
    public static final String QUEUE_STOCK_ALL = "queue.stock.all";

    private StockQueueConstants() {
        // 私有构造方法，防止实例化
    }
}
