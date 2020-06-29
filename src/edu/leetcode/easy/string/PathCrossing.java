package edu.leetcode.easy.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathCrossing {
    public boolean isPathCrossing(String path) {
        if (path == null || path.length() == 0)
            return false;

        int x = 0, y = 0;
        char[] chars = path.toUpperCase().toCharArray();
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        visited.put(x, new HashSet<>());
        visited.get(x).add(y);

        for (Character ch : chars) {
            switch(ch) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            if (!visited.containsKey(x)) {
                visited.put(x, new HashSet<>());
            }

            if (!visited.get(x).add(y)) {
                return true;
            }
        }

        return false;
    }
}
