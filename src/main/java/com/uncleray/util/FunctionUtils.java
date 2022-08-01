package com.uncleray.util;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @description:
 * @author: leipei
 * @create: 2020-12-12 16:45
 */
public class FunctionUtils {
    /**
     * 常见函数式接口
     * Consumer<T></>消费型
     * Supplier<T></>供给型
     * Function<T,R></>函数型
     * Predicate<T></>断言型
     */
    public static void main(String[] args) {
        String string = "uncle";
        Predicate<String> predicate = string::contains;
        System.out.println(predicate.test("1"));

        Function<String, String> function = s -> s.toUpperCase();
        System.out.println(function.apply("uncle"));

    }
}
