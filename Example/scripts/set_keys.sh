#!/bin/bash

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"
SEALFS_DIR="$PROJECT_ROOT/sealfs"


sudo insmod "$SEALFS_DIR/module/sealfs.ko"

cd /var/lib/
sudo mkdir SealFS

cd SealFS
sudo mkdir keys logs

sudo "$SEALFS_DIR/tools/prep" /var/lib/SealFS/logs/.SEALFS.LOG /var/lib/SealFS/keys/k1 /var/lib/SealFS/keys/k2 $1


echo "Keys ready"
