package com.tysj.common;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @Classname JsonUtil
 * @Description TODO
 * @Date 2018/11/9 14:44
 * @Created by xzcawl
 */
public class JsonUtil {
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);


    /**
     * 所有属性都序列化(包括没有get/set方法的)
     */
    public static ObjectMapper objectMapper$fieldAny = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);

    /**
     * 默认--所有属性都序列化(包括没有get/set方法的)
     */
    public static ObjectMapper objectMapper = objectMapper$fieldAny;

    /**
     * 属性为NULL 不序列化
     */
    public static ObjectMapper objectMapper$excludeNull = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY).setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);


    public static ObjectMapper objectMapper$fieldAnyAndStandardDateFormat = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);

    public static final String DATE_FORMAT_yMdHms = "yyyy-MM-dd HH:mm:ss";

    static {

        /**yyyy-MM-dd HH:mm:ss*/
        DeserializationConfig dconf = objectMapper$fieldAnyAndStandardDateFormat.getDeserializationConfig();
        dconf.setDateFormat(new SimpleDateFormat(DATE_FORMAT_yMdHms));
    }


    /**
     * obj转为json字符串
     *
     * @param obj
     * @return
     */
    public static String objToStr(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("transform obj to string errors.  ", e);
            return null;
        }
    }

    /**
     * @param objectMapper 构造器
     * @param obj
     * @return
     */
    public static String objToStr(ObjectMapper objectMapper, Object obj) {
        objectMapper = objectMapper == null ? JsonUtil.objectMapper : objectMapper;
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("transform obj to string errors.  ", e);
            return null;
        }
    }

    /**
     * 字符串转为JsonNode对象
     *
     * @param str
     * @return
     */
    public static JsonNode strToJsonNode(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return objectMapper.readTree(str);
        } catch (Exception e) {
            log.error("str:" + str == null ? "NULL" : str);
            log.error("transform str to jsonNode errors.", e);
            return null;
        }
    }

    /**
     * 是否为空
     *
     * @param node
     * @return
     */
    public static boolean isEmpty(JsonNode node) {
        if (node == null || node.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 返回 "[]" 对象
     *
     * @return
     */
    public static ArrayNode createArrayNode() {
        return objectMapper.createArrayNode();
    }

    /**
     * 返回 {} 对象
     *
     * @return
     */
    public static ObjectNode createObjectNode() {
        return objectMapper.createObjectNode();
    }

    /**
     * @param val    json字符串
     * @param class_ 待转换的类
     * @return
     */
    public static Map<String, Object> readValue(String val) {
        try {
            return objectMapper.readValue(val, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T readValue(String val, TypeReference valueTypeRef) {
        try {
            return objectMapper.readValue(val, valueTypeRef);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T readValue(ObjectMapper objectMapper, String val, TypeReference valueTypeRef) {
        try {
            objectMapper = objectMapper == null ? JsonUtil.objectMapper : objectMapper;
            return objectMapper.readValue(val, valueTypeRef);
        } catch (Exception e) {
            log.error("[readValue] err. val:{}", val, e);
            return null;
        }
    }


    /**
     * @param content    json字符串
     * @param valueType 待转换的类
     * @return
     */
    public static <T> T readValue(String content, Class<T> valueType) {
        if (content == null) {
            return null;
        }
        try {
            return objectMapper.readValue(content, valueType);
        } catch (Exception e) {
//			e.printStackTrace();
            return null;
        }
    }

    public static <T> T readValue(ObjectMapper objectMapper, String content, Class<T> valueType) {
        if (content == null) {
            return null;
        }

        objectMapper = objectMapper == null ? JsonUtil.objectMapper : objectMapper;
        try {
            return objectMapper.readValue(content, valueType);
        } catch (Exception e) {
            log.error("[readValue] err. content:{}", content, e);
            return null;
        }
    }

    /**
     * 从json文件读取
     *
     * @param filePath
     * @return
     */
    public static JsonNode readTreeFromFile(String filePath) {
        try {
            File file = new File(filePath);
            JsonNode nodes = objectMapper.readTree(file);
            return nodes;
        } catch (Exception e) {
            log.error("read Json file errors.", e);
            return null;
        }
    }
}
