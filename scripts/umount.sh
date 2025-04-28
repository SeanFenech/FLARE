#!/bin/bash

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"
SEALFS_DIR="$PROJECT_ROOT/sealfs"

sudo umount "$PROJECT_ROOT/logs"

echo "Directory unmounted"

