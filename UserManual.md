## User Manual

### Stages of use
1. Setting up the environment specified below
2. Setting up /toolname
3. Running the target application with /toolname
4. Verifying the target application
5. Renewing the key

---

### Necessary Environment/File Structure

First ensure that the project directory includes all the below.
These are available in `ProjectTemplate`.

- `src/` The target application `.java` files, and the larva script `properties.lrv`.
- `sealfs/`
  - `module/` The user is to put their SealFS kernel module in here, which can be found [here](https://gitlab.eif.urjc.es/esoriano/sealfs)
  - `tools/` Ensure executable similarly.
- `scripts/` Ensure the bash files inside are executable by root.
- `logs/` To be mounted to SealFS. Ensure no process is accessing it when it is mounted/unmounted.
- `compiler/`
- `encryption_key` To be used as the encryption key if this option was selected. More about it [here](./Encryption.md)
- `aspectjrt.jar`, `aspectjtools-1.9.22.1.jar`, `larva.jar`

---

### Setting up /toolname
1. Run the compiler and pass the key size with `-k`. Note that the default key size is 100000 bytes.
   
   ```bash
   java -cp .:compiler.Compiler ./src/properties.lrv -o ./src -k keysize
   ```

If encrypted logs are required, include `-e` and the file containing the key. Note that if no key is specified then it will generate one.
   ```bash
   java -cp .:compiler.Compiler ./src/properties.lrv -o ./src -k keysize -e encryption_key
   ```

2. Remove the key `/home/user/var/lib/SealFS/keys/k2` and store it safely for verification in the future.
3. Compile the instrumented target application.
   
   Example:
   ```bash
   java -cp "aspectjtools-1.9.22.1.jar:aspectjrt.jar:compiler" org.aspectj.tools.ajc.Main -1.9 -cp "aspectjrt.jar:compiler" -inpath compiler -sourceroots src -d out
   ```

---

### Running the target application with /toolname
- Run as root:
  ```bash
  sudo java -cp "aspectjrt.jar:out" Main
  ```

---

### Verifying the target application:
1. Re-insert `/home/user/var/lib/SealFS/keys/k2`
2. Run the verify script:
   ```bash
   ./scripts/verify.sh
   ```
3. Remove `/home/user/var/lib/SealFS/keys/k2` and store safely for future verification.

---

### Renewing the key:
1. Delete the directory:
   ```bash
   rm -r /home/user/var/lib/SealFS
   ```
2. Run the script:
   ```bash
   scripts/set_keys.sh
   ```
3. Remove `/home/user/var/lib/SealFS/keys/k2` and store safely for future verification.

---

### Decrypting Logs
Use the decryption algorithm provided [here](./src/decrypter)

   ```bash
   java Main <key> <file_to_decrypt>
   ```
