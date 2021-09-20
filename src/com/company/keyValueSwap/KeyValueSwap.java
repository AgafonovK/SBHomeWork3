package com.company.keyValueSwap;

import java.util.*;

import static java.util.stream.Collectors.toMap;


public class KeyValueSwap {

    static HashMap<Integer, String> hashMap;

    public static void main(String[] args) {
        hashMap = new HashMap<>();
        hashMap.put(1, "First");
        hashMap.put(2, "Second");
        hashMap.put(3, "Third");
        hashMap.put(4, "First");
        System.out.println("Original map: " + hashMap);
        System.out.println("Swap map: " + changeKV(hashMap));

    }

    static <K, V> Map<V, Collection<K>> changeKV(Map<K, V> map) {
        Map<V, Collection<K>> foo =  new HashMap<>();
        map.forEach((key, value) -> foo.compute(value, ((v, ks) -> {
            if (ks == null) {
                List<K> kList = new ArrayList<>();
                kList.add(key);
                return kList;
            } else {
                ks.add(key);
                return ks;
            }
        })));
        return foo;
    }

}
