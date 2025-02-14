#!/bin/bash
# send_message.sh
# 此脚本通过 curl 向 REST 接口发送消息

# 设置 API 的基础 URL，根据实际情况修改主机和端口
BASE_URL="http://localhost:8080/api/producer/send"

# 定义要发送的消息
MESSAGE="Hello, RabbitMQ!"

echo "Sending message: $MESSAGE"

# 使用 curl 发送 POST 请求，并将 message 参数传递给接口
curl -X POST "$BASE_URL" -d "message=$MESSAGE" -w "\n"