#!/bin/bash
# send_confirm_test.sh
# 该脚本使用 curl 模拟两种情况：
# 1. 使用正确路由键发送消息（success场景）
# 2. 使用错误路由键发送消息（failure场景）

# 设置 API 基础 URL，根据实际情况修改主机和端口
BASE_URL="http://localhost:8080/api/confirm/sendTest"

# 定义消息内容
MESSAGE_SUCCESS="测试成功场景"
MESSAGE_FAILURE="测试失败场景"

echo "发送成功场景消息..."
curl -X POST "${BASE_URL}?testType=success" \
     -H "Content-Type: application/json" \
     -d "{\"message\": \"${MESSAGE_SUCCESS}\"}" \
     -w "\n"

echo "发送失败场景消息..."
curl -X POST "${BASE_URL}?testType=failure" \
     -H "Content-Type: application/json" \
     -d "{\"message\": \"${MESSAGE_FAILURE}\"}" \
     -w "\n"