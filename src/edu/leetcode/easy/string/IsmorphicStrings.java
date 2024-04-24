package edu.leetcode.easy.string;

import java.util.Arrays;

public class IsmorphicStrings {

    // Solution 1: Character mapping with dictionaries
    public boolean isIsomorphic(String s, String t) {
        //Step 1: Define dictionaries
        int[] mappingStoT = new int[256];
        int[] mappingTtoS = new int[256];

        // Indicate that all characters in String S and T do not map yet
        Arrays.fill(mappingStoT, -1);  
        Arrays.fill(mappingTtoS, -1);

        // Step 2: Interate strings
        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: No mapping exists in dictionary
            if (mappingStoT[c1] == -1) {
                mappingStoT[c1] = c2;
            } // Case 2: Mapping exists and it does not map in dictionary
            else if (mappingStoT[c1] != c2) {
                return false;
            } // Case 3: We expect character mappings to exsit in the dictionary and its value should be mappingStoT[c1] == c2 => true
                //   => Do nothing and move to next character

            // Case 1: No mapping exists in dictionary
            if (mappingTtoS[c2] == -1) {
                mappingTtoS[c2] = c1;
            } // Case 2: Mapping exists and it does not map in dictionary
            else if (mappingTtoS[c2] != c1) {
                return false;
            } // Case 3: We expect character mappings to exsit in the dictionary and its value should be MappingTtoS[c2] == c1 => true
                //   => Do nothing and move to next character
        } 

        // Both strings have been exhauted.
        return true;
    }
}
