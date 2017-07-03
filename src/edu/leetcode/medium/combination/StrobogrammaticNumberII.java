/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.leetcode.medium.combination;

import java.util.*;

/**
 *
 * @author hungduong
 */
public class StrobogrammaticNumberII {
    HashMap<Character, Character> hashMap = new HashMap<>();
    List<String> strobogrammaticNumbers = new ArrayList<>();
    
    public List<String> findStrobogrammatic01(int n) {
        hashMap.clear();
        strobogrammaticNumbers.clear();
        fillHashMap(hashMap);
       
        strobogrammaticHelper(n);
        
        return strobogrammaticNumbers;
    }
    
    void strobogrammaticHelper(int n) {
        if(n <= 0) return;
        
        List<String> newResult = new ArrayList<>();
        if(n == 1) {
            if(!strobogrammaticNumbers.isEmpty()) {
                newResult.clear();
                int mid = strobogrammaticNumbers.get(0).length() / 2;
                
                for(String str : strobogrammaticNumbers) {
                    String tmp = str.substring(0, mid) + "0" + str.substring(mid, str.length());
                    newResult.add(tmp);
                    
                    tmp = str.substring(0, mid) + "1" + str.substring(mid, str.length());
                    newResult.add(tmp);
                    
                    tmp = str.substring(0, mid) + "8" + str.substring(mid, str.length());
                    newResult.add(tmp);
                }
                
                strobogrammaticNumbers.clear();
                strobogrammaticNumbers.addAll(new ArrayList(newResult));
            } else {
                strobogrammaticNumbers.add("0");
                strobogrammaticNumbers.add("1");
                strobogrammaticNumbers.add("8");
            }
        } else {
            if(!strobogrammaticNumbers.isEmpty()) {
                newResult.clear();
                int mid = strobogrammaticNumbers.get(0).length() / 2;
                
                for(String str : strobogrammaticNumbers) {
                    Iterator iter = hashMap.entrySet().iterator();
                    String tmp;
                    while(iter.hasNext()){
                        Map.Entry me = (Map.Entry) iter.next();
                        tmp = str.substring(0, mid) + me.getKey().toString() + me.getValue().toString() + str.substring(mid, str.length());
                        newResult.add(tmp);
                    }
                }
                
                strobogrammaticNumbers.clear();
                strobogrammaticNumbers.addAll(new ArrayList(newResult));
            } else {
                hashMap.entrySet().stream().filter((me) -> (!"0".equals(me.getValue().toString()))).forEach((me) -> {
                    strobogrammaticNumbers.add("" + me.getKey().toString() + me.getValue().toString());
                });
            }
        }
        
        strobogrammaticHelper(n - 2);
    }
    
    public void fillHashMap(Map<Character, Character> hm) {
        hm.put('0', '0');
        hm.put('8', '8');
        hm.put('1', '1');
        hm.put('6', '9');
        hm.put('9', '6');
    }

    //Solution 2:
    public List<String> findStrobogrammatic02(int n) {
        List<String> one = new ArrayList<>(Arrays.asList("0","1","8"));
        List<String> two = new ArrayList<>(Arrays.asList(""));
        List<String> res = two;

        if(n % 2 == 1) res = one;

        for(int i = (n%2) + 2; i <= n; i++) {
            List<String> tmp = new ArrayList<>();

            for(String str: res) {
                if(i != n)
                    tmp.add("0" + str + "0");
                tmp.add("1" + str + "1");
                tmp.add("6" + str + "9");
                tmp.add("8" + str + "8");
                tmp.add("9" + str + "6");
            }

            res = tmp;
        }

        return res;
    }

    public static void main (String[] args) {
        StrobogrammaticNumberII sn = new StrobogrammaticNumberII();
        List<String> ls = sn.findStrobogrammatic02(2);
        
        ls.stream().forEach((s) -> {
            System.out.println(s);
        });
    }


































}
