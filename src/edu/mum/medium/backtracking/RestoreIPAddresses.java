package edu.mum.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/25/17.
 */
public class RestoreIPAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        restoreIpAddressesHelper(s, 0, 0, "", result);
        return result;
    }

    // idx = 0 -> n
    // count = 1 -> 4
    public static void restoreIpAddressesHelper(String s, int idx, int count, String restored, List<String> result) {
        if(count > 4) return;
        if(count == 4) {
            if(idx == s.length())
                result.add(restored);
            return;
        }

        for(int i = 1; i < 4; i++) {
            if(idx + i > s.length())
                break;

            String str = s.substring(idx, idx + i);
            if((str.startsWith("0") && str.length() > 1) || (i == 3 && Integer.parseInt(str) >= 256))
                continue;

            restoreIpAddressesHelper(s, idx + i, count + 1, restored+str+(count==3?"":"."), result);
        }
    }

    public static void main(String[] args) {
        String str = "2525511135";
        List<String> result = restoreIpAddresses(str);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
