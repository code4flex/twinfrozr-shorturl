package com.twinfrozr.shorturl.common.hash;

import com.google.common.hash.Hashing;
import com.twinfrozr.shorturl.common.utils.ConversionUtil;

import java.nio.charset.StandardCharsets;

public class HashUtil {

    /**
     * 字符串hashcode
     *
     * @param str 待压缩字符串
     * @return 压缩后字符串
     */
    public static String compress32(String str){

        int code = Hashing.murmur3_32().hashString(str, StandardCharsets.UTF_8).asInt();

        if(code<0){ code = code*-1;}

        return ConversionUtil.encode(code);
    }

    /**
     *
     * @param str 待压缩字符串
     * @param salt 加盐
     * @return 压缩后字符串
     */
    public static String compress32(String str,int salt){

        int code = Hashing.murmur3_32(salt).hashString(str, StandardCharsets.UTF_8).asInt();

        if(code<0){ code = code*-1;}

        return ConversionUtil.encode(code);
    }

    /**
     * 字符串hashcode
     *
     * @param str 待压缩字符串
     * @return 压缩后字符串
     */
    public static String compress128(String str){

        int code = Hashing.murmur3_128().hashString(str, StandardCharsets.UTF_8).asInt();

        if(code<0){ code = code*-1;}

        return ConversionUtil.encode(code);
    }


    /**
     * 字符串hashcode
     *
     * @param str 待压缩字符串
     * @param salt 加盐
     * @return 压缩后字符串
     */
    public static String compress128(String str,int salt){

        int code = Hashing.murmur3_128(salt).hashString(str, StandardCharsets.UTF_8).asInt();

        if(code<0){ code = code*-1;}

        return ConversionUtil.encode(code);
    }


    /**
     * crc32
     * @param str
     * @return
     */
    public static Long crc32(String str) {

        int res = Hashing.crc32().hashString(str,StandardCharsets.UTF_8).asInt();

        return Long.valueOf(res);
    }
}
