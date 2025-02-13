#!/bin/bash

BASE_URL="http://localhost:8080/api/producer"

send_A() {
  curl -X POST "$BASE_URL/send/A" -d "message=$1" -w "\n"
}

send_US() {
  curl -X POST "$BASE_URL/send/US" -d "message=$1" -w "\n"
}

send_HK() {
  curl -X POST "$BASE_URL/send/HK" -d "message=$1" -w "\n"
}

# 示例调用，发送不同市场的股票消息
send_A "A股消息：股票行情更新"
send_US "美股消息：Market update for US stocks"
send_HK "港股消息：更新港股信息"
