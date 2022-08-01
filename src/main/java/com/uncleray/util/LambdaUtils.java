package com.uncleray.util;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @description: lambda表达式是对 匿名内部类的简写
 * 方法引用又是lambda表达式的一种简写形式。如果lambda表达式方法体中只是调用一个特定的已经存在的方法，
 * 则可以使用方法引用 ::
 * 常见形式：
 * 对象::实例方法
 * 类::静态方法
 * 类::实例方法
 * 类::new
 * @author: leipei
 * @create: 2020-12-12 16:39
 */
public class LambdaUtils {

    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "2");
        hashMap.put("2", "3");
        hashMap.entrySet().stream().map(Map.Entry::getKey).forEach(System.out::println);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(integer -> System.out.println(integer));
        list.forEach(System.out::println);


        int[] array = {10, 3, 5, 6, 7, 7};
        Function<int[], int[]> bubbleSort = SortUtils::bubbleSort;
        System.out.println(Arrays.toString(bubbleSort.apply(array)));

    }

    public static void executor() {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        executorService.execute(() -> {
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            System.out.println(sum);
        });
        executorService.shutdown();
    }
}
