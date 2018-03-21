package com.test.base.utils;

import java.security.MessageDigest;

public class MD5Util {
    public static String MD5(String pwd) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] bytes = digest.digest(pwd.getBytes());
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            int salt = b & 0xff;
            String str = Integer.toHexString(salt);
            if (str.length() == 1) {
                buffer.append("0");
            }
            buffer.append(str);
        }
        return buffer.toString();
    }
}
