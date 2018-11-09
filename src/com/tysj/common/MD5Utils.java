package com.tysj.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname MD5Utils
 * @Description TODO
 * @Date 2018/11/9 14:44
 * @Created by xzcawl
 */
public class MD5Utils {

    private static final Logger log = LoggerFactory.getLogger(MD5Utils.class);

    private static final String algorithm = "MD5";

    /**
     * 生成32位的md5
     *
     * @param text
     * @return
     * @throws Exception
     */
    public static String md5_32bit(String text) {
        try {
            if (text == null) text = "";
            byte[] source = text.getBytes();
            char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(algorithm);
            md.update(source);
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            log.error("[md5_32bit] text:{}", text);
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(md5_32bit("aaaaa"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
