package com.twinfrozr.shorturl.common.utils;

import org.apache.commons.lang3.StringUtils;

public class ConversionUtil {

    private static String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static int scale = 62;

    /**
     * 数字转62进制
     * @param num 待转换数字
     * @return 62进制字符串
     */
    public static String encode(long num) {
        StringBuilder sb = new StringBuilder();
        int remainder = 0;

        while (num > scale - 1) {
            remainder = Long.valueOf(num % scale).intValue();
            sb.append(chars.charAt(remainder));

            num = num / scale;
        }

        sb.append(chars.charAt(Long.valueOf(num).intValue()));
        return sb.reverse().toString();
    }

    /**
     * 将数字转换位62进制
     * @param num 待转换数
     * @param length 转换后的字符串长度
     * @return 62进制字符串
     */
    public static String encode(long num, int length) {
        String value = encode(num);
        return StringUtils.leftPad(value, length, '0');
    }

    /**
     * 62进制字符串转为数字
     * @param str 编码后的62进制字符串
     * @return 解码后的 10 进制字符串
     */
    public static long decode(String str) {
        str = str.replace("^0*", "");
        long num = 0;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            index = chars.indexOf(str.charAt(i));
            num += (long) (index * (Math.pow(scale, str.length() - i - 1)));
        }

        return num;
    }
}
