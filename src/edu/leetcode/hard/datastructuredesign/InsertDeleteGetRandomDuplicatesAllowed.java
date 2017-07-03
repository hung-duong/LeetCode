package edu.leetcode.hard.datastructuredesign;

import java.util.*;

/**
 * Created by hungduong on 10/28/16.
 */
public class InsertDeleteGetRandomDuplicatesAllowed {
    public class RandomizedCollection {

        private List<Integer> list;
        private Map<Integer, HashSet<Integer>> listMap;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            list = new ArrayList<>();
            listMap = new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            list.add(val);

            HashSet<Integer> hashSet;
            if(!listMap.containsKey(val)) {
                hashSet = new HashSet<>();
                hashSet.add(list.size() - 1);
                listMap.put(val, hashSet);

                return true;
            } else {
                hashSet = listMap.get(val);

                hashSet.add(list.size() - 1);
            }

            return false;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            /* Eg: index  0 1 2 3 4 5 6 7 8
            *      List = 1 3 5 7 8 9 1 1 7
            *      Map = 1 -> 0 6 7
            *            3 -> 1
            *            5 -> 2
            *            7 -> 3 8
            *            8 -> 4
            *            9 -> 5
            *     1. How to delete 7 in List
            *        Map(7) = 3 8
            *        firstEleHashSet = 3
            *        lastEleList = 7
            *        List.set(3, 7) // Replace element index = 3 by last element 7
            *        hashSetTemp = Map(lastEleList) = 3 8
            *        hashSetTemp.remove(List.size() - 1) = remove(8) = 3
            *        hashSetTemp.add(firstEleHashSet) = add(3) = 3 3
            *
            *        because Map(7) > 1
            *           Map(7).remove(firstEleHashSet) = remove(3) -> Map(7) = 3
            *        List.remove(List.size - 1) = remove(8) -> List = 1 3 5 7 8 9 1 1
            *
            *     2. How to delete 5 when
            *     index  0 1 2 3 4 5 6 7
            *     List = 1 3 5 7 8 9 1 1
            *     Map = 1 -> 0 6 7
            *           3 -> 1
            *           5 -> 2
            *           7 -> 3
            *           8 -> 4
            *           9 -> 5
            */
            //Eg. val = 7
            if(listMap.containsKey(val)) {
                //Get the hashSet = listMap.get(7) -> 3 8
                HashSet<Integer> hashSet = listMap.get(val);

                //size = 9
                int size = list.size();

                //First firstEleHashSet = 3
                int firstEleHashSet = hashSet.iterator().next();

                if(hashSet.size() > 1) {
                    //remove 3 in hashSet = 3 8 -> hashSet = 8
                    hashSet.remove(firstEleHashSet);
                } else {
                    listMap.remove(val);
                }

                //If there is only one element in List
                //OR remove the last element
                if(size == 1 || firstEleHashSet == size - 1) {
                    list.remove(size - 1);

                    return true;
                }

                //Get lastEleList = list.get(8) -> 7
                int lastEleList = list.get(size - 1);

                //replace element index = 3 (firstEleHashSet = 3) by element 7
                list.set(firstEleHashSet, lastEleList);

                //Get hasSetTemp of lastEleList -> hasSetTemp = 8
                HashSet<Integer> hashSetTemp = listMap.get(lastEleList);

                //remove element size - 1 = 8 in hasSetTemp
                hashSetTemp.remove(size - 1);

                //Add firstEleHashSet = 3 into hashSetTemp -> hashSetTemp = 3
                hashSetTemp.add(firstEleHashSet);

                list.remove(size - 1);

                return true;
            }

            return false;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }
}
