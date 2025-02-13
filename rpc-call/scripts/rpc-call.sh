#!/bin/bash
# order_request.sh
# 该脚本向订单聚合服务发送一个 POST 请求，提交订单请求并输出响应结果。

BASE_URL="http://localhost:8080/api/orders/process"

# 构造 JSON 格式的订单请求数据
JSON_DATA='{
  "orderId": "ORD12345",
  "product": "Laptop",
  "quantity": 1,
  "amount": 1200.00
}'

echo "Sending order request to ${BASE_URL}..."
# 使用 curl 发送 POST 请求，Content-Type 为 application/json
curl -X POST "${BASE_URL}" \
     -H "Content-Type: application/json" \
     -d "${JSON_DATA}" \
     -w "\n"