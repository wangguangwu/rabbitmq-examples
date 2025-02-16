#!/bin/bash

# 服务器地址
API_URL="http://localhost:8080/api/producer/send"

# 需要发送的消息
MESSAGE=${1:-"Hello, RabbitMQ Fanout!"}

# 发送 POST 请求
curl -X POST "$API_URL" \
     -H "Content-Type: application/x-www-form-urlencoded" \
     --data-urlencode "message=$MESSAGE"

# 换行美观输出
echo