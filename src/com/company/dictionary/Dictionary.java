package com.company.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dictionary {

    String foo = "This method returns the index of the first occurrence of the specified element in the given list," +
            " or -1 if the list doesn't contain the element.\n" +
            "\n" +
            "So logically, if this method returns anything other than -1, we know that the list contains the element:";

    private HashMap<Character, Integer> charToFrequency = new HashMap<>();


    void getFrequency(String message) {
        if (!charToFrequency.isEmpty()) charToFrequency.clear();
        for (int i = 0; i < message.length(); i++) {
            if (isLatinLetter(foo.charAt(i))) {
                charToFrequency.compute(foo.charAt(i), (u, o) -> {
                    if (o == null) {
                        return 1;
                    } else {
                        return charToFrequency.get(u) + 1;
                    }
                });
            }
        }
    }

    boolean isLatinLetter( char c){
        return (((c>='a') && (c<='z'))||(c>='A')&&(c<='A'));
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.getFrequency(dictionary.foo);
        System.out.println(dictionary.charToFrequency.entrySet());
        dictionary.getFrequency("Hello world");
        System.out.println(dictionary.charToFrequency.entrySet());
    }
}
