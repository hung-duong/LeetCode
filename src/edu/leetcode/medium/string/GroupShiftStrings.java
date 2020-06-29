package edu.leetcode.medium.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftStrings {
    // This problem related to GroupAnangrams
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0)
            return new ArrayList<List<String>>();

        Map<String, List<String>> container = new HashMap<>();
        for (String str : strings) {
            //Build the key
            String key = buildKey(str);
            if (!container.containsKey(key)) {
                container.put(key, new ArrayList<>());
            }

            container.get(key).add(str);
        }

        return new ArrayList<List<String>>(container.values());
    }

    public String buildKey(String str) {
        // Run 7s
//        String key = "";
//
//        for (int i=1; i<str.length(); i++) {
//            int diff = (str.charAt(i) - 'a') - (str.charAt(i-1) - 'a');
//            if (diff < 0) {
//                diff += 26;
//            }
//
//            //This step take a lot of time should change to use StringBuilder
//            key += String.valueOf(diff);
//        }
//
//        return key;

        // Run 1s
        StringBuilder key = new StringBuilder();

        for (int i=1; i<str.length(); i++) {
            int diff = (str.charAt(i) - 'a') - (str.charAt(i-1) - 'a');
            if (diff < 0) {
                diff += 26;
            }

            key.append(String.valueOf(diff));
        }

        return key.toString();
    }
}
