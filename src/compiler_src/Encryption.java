package compiler;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Base64;
import java.util.List;

// WHEN :              | keyFilePath is | generate sealfs key | before every append  
// if no -e            | null           | nothing             | nothing
// if -e "keyFilePath" | "keyFilePath"  | check exists        | load
// if -e               | ""             | create              | load

public class Encryption {
    
    public static void createKey(String keyFilePath) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey key = keyGen.generateKey();

        try (FileOutputStream fos = new FileOutputStream(keyFilePath)) {
            fos.write(key.getEncoded());
        }
    }

}