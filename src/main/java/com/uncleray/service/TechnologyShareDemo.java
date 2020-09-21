package com.uncleray.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class TechnologyShareDemo {
    public static String getSharer() {
        Map map = new HashMap();
        Random random = new Random();
        int nextInt = random.nextInt(28);
        return ""+nextInt;
    }

    public static void main(String[] args) {
        System.out.println(getSharer());
    }
}
