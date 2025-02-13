#!/bin/bash

BASE_URL="http://localhost:8080/api/producer"

send_info() {
  curl -X POST "$BASE_URL/send/info" -d "message=$1" -w "\n"
}

send_warn() {
  curl -X POST "$BASE_URL/send/warn" -d "message=$1" -w "\n"
}

send_error() {
  curl -X POST "$BASE_URL/send/error" -d "message=$1" -w "\n"
}

# 示例调用
send_info "System started successfully"
send_warn "High memory usage detected"
send_error "Application crashed"