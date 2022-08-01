package com.uncleray.util;

import java.time.Instant;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流（Stream）中保存对集合或数组数据的操作。和集合类似，但集合中保存的是数据。
 * 一个Stream到另一个Stream，是一个中间操作
 *
 * @author: leipei
 * @since: 2020-12-12 21:30
 */
public class StreamUtils {
    public static void main(String[] args) {
        //1
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Huawei");
        arrayList.add("xiaomi2");
        Stream<String> stream = arrayList.stream();
//        stream.forEach(System.out::println);
//        Set<Integer> collect = stream.map(String::length).collect(Collectors.toSet());
        List<String> collect = stream.map(s -> s == null ? "" : s + new Random().nextInt(100))
                .collect(Collectors.toList());
        System.out.println(collect);
        Instant instant = Instant.now();
        System.out.println(instant.getEpochSecond());

        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        zoneIds.forEach(System.out::println);

    }
}
