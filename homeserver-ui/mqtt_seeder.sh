#!/usr/bin/env bash

set -euo pipefail

if ! command -v mosquitto_pub >/dev/null 2>&1; then
    echo "mosquitto cli tools not found, cannot seed data"
    exit 0
fi

# Obviously these values are bogus, just seed to show something
for i in {1..100}; do
    c=${RANDOM}
    v=$((c % 100))
    vf=$(echo "scale=2; $c * 9 / 5 + 32" | bc)
    suffix=$((i % 10))
    mosquitto_pub --host localhost \
      --port 1883 \
      --qos 1 \
      --topic "iot-device-${suffix}/status/humidity:0" \
      --message "{\"id\":1, \"rh\": $v}"

    mosquitto_pub --host localhost \
      --port 1883 \
      --qos 1 \
      --topic "iot-device-${suffix}/status/temperature:0" \
      --message "{\"id\":1, \"tC\": $v, \"tF\": $vf}"
done;
