package edu.mum.hard.datastructuredesign;

import java.util.*;

/**
 * Created by hungduong on 10/25/16.
 */
public class InsertDeleteGetRandom {
    public class RandomizedSet {

        private List<Integer> list;
        private Map<Integer, Integer> listMap;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            list = new ArrayList<>();
            listMap = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {

            /*If val does not contain into Map, it means it will not contain in List,
            * so, we will add this val into List and put the val as well as its position
            * into Map
            */
            if(!listMap.containsKey(val)) {
                list.add(val);
                listMap.put(val, list.size() - 1);

                return true;
            }

            return false;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {

            /*If val contains into Map, it means this value will contain into List
            * so, we replace the element val in List by the end element and remove
            * the end element in List, then remove the element val in Map
            * Eg. List = 1 2 3
            *     Map = {<1, 0>, <2, 1>, <3, 2>}
            *     Remove 1 in List
            *     put <3, 0> in to map => Map = {<1, 0>, <2, 1>, <3, 0>}
            *     Set List(0) = List(2) => List = 3 2 3
            *     Remove List(3) => List =  3 2
            */
            if(listMap.containsKey(val)) {
                listMap.put(list.get(list.size() - 1), listMap.get(val));

                list.set(listMap.get(val), list.get(list.size() - 1));
                list.remove(list.size() - 1);

                listMap.remove(val);


                return true;
            }

            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }
}
