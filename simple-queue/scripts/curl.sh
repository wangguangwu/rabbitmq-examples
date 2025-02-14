#!/bin/bash
# send_message.sh
# 该脚本通过 curl 调用 REST 接口 /api/producer/send 发送消息

# 设置 API 基础 URL（根据实际情况调整主机和端口）
BASE_URL="http://localhost:8080/api/producer/send"

# 定义要发送的消息
MESSAGE="Hello, RabbitMQ!"

echo "Sending message: $MESSAGE"

# 使用 curl 发送 POST 请求，参数 message 将作为请求参数传递
curl -X POST "$BASE_URL" -d "message=$MESSAGE" -w "\n"