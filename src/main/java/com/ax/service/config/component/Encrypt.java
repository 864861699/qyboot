package com.ax.service.config.component;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * FTP上传工具
 */
public class Encrypt {
    private Encrypt() {}

    public static String encryptPassword(String password) {
        try {
            return DigestUtils.sha256Hex(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ignored) {
            ignored.printStackTrace();
            throw new RuntimeException(ignored);
        }
    }

    public static long hash(String key) {
        return hash(key, 1, 5);
    }

    public static long hash(String key, int start, int end) {
        long seed = 31;
        long hash = 0;
        for (int i = 0; i < 8; i++) {
            hash = hash * seed + key.charAt(i);
        }
        return hash % end + start;
    }

    public static String getMd5(File file) throws FileNotFoundException {
        String value = null;
        FileInputStream in = new FileInputStream(file);
        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
