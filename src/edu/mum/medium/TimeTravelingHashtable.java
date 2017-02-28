package edu.mum.medium;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by hungduong on 2/27/17.
 */
public class TimeTravelingHashtable<K, V> {
    private class Pair<V> {
        public double time;
        public V value;

        public Pair(){}

        public Pair(double time, V value) {
            this.time = time;
            this.value = value;
        }
    }

    Map<K, List<Pair<V>>> hash = new Hashtable<>();

    public int binarySearchIndex(double time, K key, boolean isPut) {
        if (!hash.containsKey(key))
            return -1;

        int start = 0;
        int end = hash.get(key).size() - 1;

        while(start < end) {
            int mid = (start + end) / 2;
            double _time = hash.get(key).get(mid).time;

            if(_time == time) {
                return mid;
            } else if (_time > time) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        double sT = hash.get(key).get(start).time;
        double eT = hash.get(key).get(end).time;

        int index = -1;
        index = sT == time ? start : index;
        index = eT == time ? end : index;

        if(index == -1 && !isPut) {
            if(sT < time && time < sT + 1) index = start;
            else if (eT < time && time < eT + 1) index = end;
        }

        return index;
    }

    public void put(double time, K key, V value) {
        int index = binarySearchIndex(time, key, true);
        List<Pair<V>> list;

        if(index != -1) {
            //If exist, replace by new value
            hash.get(key).get(index).value = value;
        } else {
            if(!hash.containsKey(key)) {
                list = new ArrayList<>();
                list.add(new Pair(time, value));

                hash.put(key, list);
            } else {
                list = hash.get(index);
                list.add(new Pair(time, value));
            }
        }
    }

    public V get(double time, K key) {
        int index = binarySearchIndex(time, key, false);

        if(index != -1)
            return null;

        return hash.get(key).get(index).value;
    }

    public void delete(double time, K key) {
        int index = binarySearchIndex(time, key, false);

        if(index != -1)
            return;

        hash.get(key).remove(index);
    }

    public static void main(String[] args) {
        TimeTravelingHashtable<Character, String> tth = new TimeTravelingHashtable<>();
        tth.put(1, 'K', "A");
        tth.put(2, 'K', "B");
        tth.put(3, 'K', "C");

        System.out.println(tth.get(1, 'K'));
    }
}
