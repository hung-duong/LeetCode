/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.medium.combination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hungduong
 */
public class StrobogrammaticNumberII {
    HashMap<Character, Character> hashMap = new HashMap<>();
    List<String> strobogrammaticNumbers = new ArrayList<>();
    
    public List<String> findStrobogrammatic(int n) {
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
    
    void fillHashMap(Map<Character, Character> hm) {
        hm.put('0', '0');
        hm.put('8', '8');
        hm.put('1', '1');
        hm.put('6', '9');
        hm.put('9', '6');
    }

    public static void main (String[] args) {
        StrobogrammaticNumberII sn = new StrobogrammaticNumberII();
        List<String> ls = sn.findStrobogrammatic(5);
        
        ls.stream().forEach((s) -> {
            System.out.println(s);
        });
    }
}
