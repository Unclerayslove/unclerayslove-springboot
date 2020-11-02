package com.uncleray.utils;

import com.uncleray.model.pojo.User;
import org.springframework.util.Assert;

/**
 * @program: uncle-ray
 * @description: 排序算法类
 * @author: lei pei
 * @create: 2020-10-14 21:01
 */
public class SortUtil {

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;//表示有数据交换
                }
            }
            if (!flag) break;
        }
        return array;
    }

    public static int[] insertionSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int value = arrays[i];
            int j = i - 1;
            // 寻找插入的位置
            for (; j >= 0; j--) {
                if (arrays[j] > value) {
                    arrays[j + 1] = arrays[j];//数据移动
                } else {
                    break;
                }
            }
            arrays[j + 1] = value;//插入数据
        }
        return arrays;
    }

    public static void main(String[] args) {
        User user = null;
        Assert.notNull(null, "用户不存在。");
    }


}
