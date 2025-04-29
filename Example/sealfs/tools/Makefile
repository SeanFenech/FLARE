CC = gcc
L=-lssl -lcrypto
CFLAGS = -O2 -g -Wall -Wshadow -I.
DEPS = ../module/sealfstypes.h entries.h
SRCS = $(wildcard *.c)
OBJS = $(SRCS:.c=.o)
TOCLEAN = prep $(OBJS)

all: dump prep verify test secube_prep

uthash.h:
	rm -rf /tmp/uthash
	git clone https://github.com/troydhanson/uthash.git /tmp/uthash
	cp /tmp/uthash/src/uthash.h .

verify: uthash.h verify.o $(DEPS) heap.h heap.o entries.o
	$(CC) $(CFLAGS) -o $@ $@.o  heap.o entries.o $L

prep: prep.o $(DEPS)
	$(CC) $(CFLAGS) -o $@ $@.o

dump: dump.o $(DEPS) entries.o
	$(CC) $(CFLAGS) -o $@ $@.o entries.o $L

secube_prep: secube_sources
	$(CC) -c $(CFLAGS) -D_GNU_SOURCE -DDEBUG -o secube_prep.o secube_prep.c
	$(CC) $(CFLAGS) -D_GNU_SOURCE -o secube_prep secube_prep.o secube/aes256.c secube/crc16.c secube/L0.c secube/L1.c secube/pbkdf2.c secube/se3_common.c secube/se3comm.c secube/sha256.c

secube_sources:
	$(CC) -c $(CFLAGS) -D_GNU_SOURCE -o secube/aes256.o secube/aes256.c
	$(CC) -c $(CFLAGS) -D_GNU_SOURCE -o secube/crc16.o secube/crc16.c
	$(CC) -c $(CFLAGS) -D_GNU_SOURCE -o secube/L0.o secube/L0.c
	$(CC) -c $(CFLAGS) -D_GNU_SOURCE -o secube/L1.o secube/L1.c
	$(CC) -c $(CFLAGS) -D_GNU_SOURCE -o secube/pbkdf2.o secube/pbkdf2.c
	$(CC) -c $(CFLAGS) -D_GNU_SOURCE -o secube/se3_common.o secube/se3_common.c
	$(CC) -c $(CFLAGS) -D_GNU_SOURCE -o secube/se3comm.o secube/se3comm.c
	$(CC) -c $(CFLAGS) -D_GNU_SOURCE -o secube/sha256.o secube/sha256.c

test: test.o
	$(CC) $(CFLAGS) -std=gnu99 -o $@ $@.o

%.o: %.c $(DEPS) 
	$(CC) -c $(CFLAGS) $(CPPFLAGS) $< -o $@

clean:
	rm -f $(TOCLEAN)
	rm -f secube/*.o

nuke: clean
	rm -f  uthash.h

.PHONY: all clean

