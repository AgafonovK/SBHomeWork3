package com.company.keyValueChange;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;
//TODO WIP
public class KeyValueChange {

    static HashMap<Integer, String> hashMap;

    public static void main(String[] args) {
        hashMap = new HashMap<>();
        hashMap.put(1, "First");
        hashMap.put(2, "Second");
        hashMap.put(3, "Third");
        hashMap.put(4, "First");
        System.out.println(hashMap);

        System.out.println(changeKV(hashMap));

    }

    static <K, V> Map<V, Collection<K>> changeKV(Map<K, V> map) {
        Map<V, Collection<K>> foo;
        Collection<K> newValueCollectionK = map.keySet();
        System.out.println("Value: " + newValueCollectionK);
        //System.out.println("New value: " + newValueCollectionK);
        /*map.values().stream()
                .collect(toMap(v -> {
                    return v;
                    }, w -> {
                    return null;
                }));*/
        /*map.forEach((key, value) -> f1oo.compute(value,((v,ks)->{
           if (ks==null){
               Collection<K> a = map.get();
           }
        }));*/
        Set<K> keys = new HashSet<K>();
        return map.entrySet().stream()
                .collect(toMap(a -> {
                            System.out.println();
                            System.out.println("Put new Key: " + a.getValue());
                            return a.getValue();
                        },
                        w -> {

                            for (Map.Entry<K, V> entry : map.entrySet()) {
                                System.out.println("Check Entry: " + entry);
                                if (Objects.equals(w.getValue(), entry.getValue())) {
                                    System.out.println("Put " + entry.getKey());
                                    keys.add(entry.getKey());
                                }

                            }
                            return keys;
                        }));
                                    /*return map.entrySet().stream()
                                    .filter(entry -> {
                                        System.out.println("Entry " + entry.getValue() + " w= " + w.getValue() +" "+ Objects.equals(entry.getValue(), w.getValue()));
                                        return Objects.equals(entry.getValue(), w.getValue());
                                    })
                                    .map(Map.Entry::getKey)
                                    .collect(Collectors.toList());}));*/

    }
        /*
        map.forEach((key, value) -> foo.compute(value, ((v, ks) -> {
            if (ks == null) {
                List<K> kList = null;
                kList.add(key);
                return kList;
            } else {
                ks.add(key);
                return ks;
            }
        })));
        return foo;
    }*/

    static HashMap<String, ArrayList<Integer>> change(HashMap<Integer, String> map) {

        HashMap<String, ArrayList<Integer>> foo = new HashMap<>();
        map.entrySet().stream().forEach(valueOldMap -> foo.compute(valueOldMap.getValue(), (stringKey, listIntegers) -> {
            System.out.println("valueoldmap is new key: " + valueOldMap + " ! ListValues: " + listIntegers);
            if (listIntegers == null) {
                System.out.println("Create new List!");
                ArrayList<Integer> listRet = new ArrayList<>();
                listRet.add(valueOldMap.getKey());
                return listRet;
            } else {
                listIntegers.add(valueOldMap.getKey());
                return listIntegers;
            }
        }));
        return foo;

    }
}
