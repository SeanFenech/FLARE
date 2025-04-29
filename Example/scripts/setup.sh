#!/bin/bash

echo "SealFS Environment Setup Starting"


SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"
SEALFS_DIR="$PROJECT_ROOT/sealfs"


# Will just make error if module is already in, and continue running script
sudo insmod "$SEALFS_DIR/module/sealfs.ko"
echo "SealFS module ready"

# Will mount directory
sudo mount -o kpath=/var/lib/SealFS/keys/k1,nratchet=2048 -t sealfs /var/lib/SealFS/logs "$PROJECT_ROOT/logs"
   #sudo chmod 777 "$PROJECT_ROOT/logs"
echo "Directory mounted to SealFS"



# Run compiler, will make monitor, and create keys
# Run application with monitor, will call this script to mount
# Script to run when you stop application. Exit handler?
# Verify whenever user wants

echo "SealFS Environment Setup End"
