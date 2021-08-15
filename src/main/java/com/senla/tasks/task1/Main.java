package com.senla.tasks.task1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * int count - counter for letters
     * int count3 - counter for group of three symbols
     */
    public static void main(String[] args) {
        String initialText = " ГГГkkk kkk ffffff 22222.f.f.Ff";
        String text = initialText.toLowerCase();
        char[] chars = text.toCharArray();
        int count;
        int count3 = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length - 1; i ++) {
            if (!map.containsKey(chars[i])) {
                count = 1;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        count++;
                    }
                    if (count == 3) {
                        count3++;
                        count = 0;
                    }
                }
                if (count3 != 0) {
                    map.put(chars[i], count3);
                    count3 = 0;
                }
            }
        }
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
