package com.uncleray.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.Map;

public class TypeUtils {

    public static <T> T map2Object(Map<String, Object> map, Class<T> tClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        T value = objectMapper.convertValue(map, tClass);
        return value;
    }

    public static <T> T json2Object(Map<String, Object> map, Class<T> tClass) {
        JsonMapper jsonMapper = new JsonMapper();
        T value = jsonMapper.convertValue(map, tClass);
        return value;
    }

}
