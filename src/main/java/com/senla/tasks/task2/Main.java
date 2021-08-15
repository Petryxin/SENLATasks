package com.senla.tasks.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String texter = "fsdn 900 fad 4dfdp8.8";
        Pattern integerPattern = Pattern.compile("\\d");
        Matcher matcher = integerPattern.matcher(texter);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }

        int sum = integerList.stream().mapToInt(Integer::valueOf).sum();
        System.out.println(sum);
    }
}
