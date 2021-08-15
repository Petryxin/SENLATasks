package com.senla.tasks.task5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    static Map<String, Integer> getMapOfWordsWithNumberOfVowels(String text){
        String[] words = text.split(" ");
        String regex = "[aeiouAEIOU]";

        Pattern pattern = Pattern.compile(regex);
        Map<String, Integer> mapOfWords = new HashMap<>();
        for (String str: words) {
            Matcher matcher = pattern.matcher(str);
            int counterForVowels = 0;
            while (matcher.find()) {
                counterForVowels++;
            }
            mapOfWords.put(str,counterForVowels);
        }
        return mapOfWords;
    }

    static Map<String, Integer> getSortedMapByNumberOfVowels(Map<String, Integer> map){
        Map<String, Integer> sortedWordsByNumberOfVowels = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return sortedWordsByNumberOfVowels;
    }

    static Map<String, Integer> changeFirstVowelToUpperCase(Map<String, Integer> map){
        String regex = "[aeiouAEIOU]";
        Pattern vowelPattern = Pattern.compile(regex);
        Map<String, Integer> mapWordsWithFirstVowelInUpperCase = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Matcher vowelMatcher = vowelPattern.matcher(entry.getKey());
            int counterForV = 0;
            while (vowelMatcher.find() && counterForV == 0) {
                counterForV++;
                String firstVowel = vowelMatcher.group();
                String newKey = entry.getKey().replaceFirst(regex, firstVowel.toUpperCase());
                mapWordsWithFirstVowelInUpperCase.put(newKey,entry.getValue());
            }
        }
        return mapWordsWithFirstVowelInUpperCase;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        ///String text = "KK Kon korn a Aikiiii Noto noook moik Majy Daoooy diooooooon";

        Map<String, Integer> mapOfWords = getMapOfWordsWithNumberOfVowels(text);
        System.out.println("The number of vowels in a word: ");
        mapOfWords.forEach((key, value) -> System.out.println(key + ":" + value));

        Map<String, Integer> sortedWordsByNumberOfVowels = getSortedMapByNumberOfVowels(mapOfWords);
        System.out.println("Sorted words by number of vowels");
        sortedWordsByNumberOfVowels.forEach((key, value) -> System.out.println(key + ":" + value));

        Map<String, Integer> mapWordsWithFirstVowelInUpperCase = changeFirstVowelToUpperCase(sortedWordsByNumberOfVowels);
        System.out.println("Change of the first vowel from lower case to upper case (saved sort)");
        mapWordsWithFirstVowelInUpperCase.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
