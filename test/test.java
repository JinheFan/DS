package test;

import java.util.*;
import java.util.function.Predicate;

public class test {
    public void doAction(Queue q) {
        if (q.isEmpty()) return;

        Object first = q.remove();
        doAction(q);
        System.out.println(first.toString());
    }

    public static void main(String[] args) {
        /* string key ops */
        HashMap<String, Integer> stringKeyHashMap =
                new HashMap<>();
        stringKeyHashMap.put("A", Integer.valueOf(1));
        stringKeyHashMap.put("A", Integer.valueOf(2));
        /*
         * custom key ops
         */
        HashMap<Key, Integer> customKeyHashMap =
                new HashMap<>();

        Key key1A = new Key(
                "A");
        Key key2A = new Key("A");

        customKeyHashMap.put(key1A, Integer.valueOf(1));
        customKeyHashMap.put(key2A, Integer.valueOf(2));

        System.out.println(String.format(
                "stringKey: %s; customKey: %s",
                stringKeyHashMap.get("A"),
                customKeyHashMap.get(key1A)));

    }
    static class Key {
        String keyValue;

        public Key(String keyValue) {
            this.keyValue = keyValue;
        }
    }
}
