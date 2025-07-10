# Encryption
FLARE provides the option for the automatically generated logs to be encrypted using the encryption scheme described below.

Adding the `-e` option at the end of the command to run the FLARE compiler will enable encryption using either a provided key or an automatically generated key.

The decryption binary is available [here](./src/decrypter).

## Encryption Scheme

One (128-bit AES GCM) key is used to encrypt each log that is appended to a file.
To avoid increasing the key depth, a fixed size nonce of 12 bytes is randomly generated for each log.
The nonce, followed by the log encrypted with the key and nonce, and a `\n` to delimit, are then appended to the file.

The file can then be decrypted by splitting on `\n` and using the nonce and key to decrypt each line.
