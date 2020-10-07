package com.uncleray.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.uncleray.entity.Person;

import java.util.HashMap;
import java.util.Map;

public class JsonMapToObject {

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

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", 12);
        Person person = map2Object(map, Person.class);
        System.out.println(person);
        Person person1 = json2Object(map, Person.class);
        System.out.println(person1);
    }
}
