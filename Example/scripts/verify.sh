#!/bin/bash

echo "Verifying logs"

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"
SEALFS_DIR="$PROJECT_ROOT/sealfs"

sudo "$SEALFS_DIR/tools/verify" /var/lib/SealFS/logs /var/lib/SealFS/keys/k1 /var/lib/SealFS/keys/k2

