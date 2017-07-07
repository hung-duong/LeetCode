package edu.common.test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by hungduong on 6/20/17.
 */
public class OraInteractive {


    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<Integer>();
        tree.add(45);
        tree.add(12);
        tree.add(63);
        tree.add(34);

        Iterator<Integer> iterator = tree.iterator();
        System.out.print("Tree set data: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }

}
