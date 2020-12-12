package com.twinfrozr.shorturl.common.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * JSONUtils
 *
 * @author mavin
 */
public class JSONUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper(){
        private static final long serialVersionUID = 7353624999246999670L;
        {
            setSerializationInclusion(JsonInclude.Include.NON_NULL );
        }
    };

    /**
     * 转换为map
     *
     * @param content
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> toMap(String content) throws IOException {
        try {
            return objectMapper.readValue(content, Map.class);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * 转换为字符串
     *
     * @param object
     * @return
     * @throws IOException
     */
    public static String toJsonString(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * 转换为数组
     *
     * @param object
     * @return
     * @throws IOException
     */
    public static byte[] toJsonByte(Object object) throws IOException {
        return objectMapper.writeValueAsBytes(object);
    }

    /**
     * 转换为对象
     *
     * @param content
     * @param clz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T toObject(String content, Class<T> clz) throws IOException {
        try {
            return objectMapper.readValue(content, clz);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * 转换为对象
     *
     * @param content
     * @param clz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T toObject(byte[] content, Class<T> clz) throws IOException {
        try {
            return objectMapper.readValue(content, clz);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * 转换为对象
     *
     * @param content
     * @param javaType
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T toObject(byte[] content, JavaType javaType) throws IOException {
        try {
            return objectMapper.readValue(content, javaType);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
