package edu.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hungduong on 7/2/17.
 */
public class Tips {
    public static void main(String[] args) {
        /*
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()) {
            //Returns the next token of input
            String token = scan.next();
            System.out.println(token);
        }

        while (scan.hasNextLine()) {
            //Returns the next Line of input
            String str = scan.nextLine();
            System.out.println(str);
        }

        scan.close();
        */

        String s1 = "abc";
        String s2 = "abc";
        s2 = "cde";
        System.out.print(s1 + s2);

        //Convert int[] to List<Integer>. Use Java 8
        int[] arr = {5, 2, 8, 4, 6, 9};

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Collections.sort(list);

        //Convert int[] to Integer[]. Use Java 8
        Integer[] arrConvert = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        //Convert Integer[] to List<Integer>
        List<Integer> list2 = Arrays.stream(arrConvert).collect(Collectors.toList());


        //Convert List<Integer> to Int[]
        List<Integer> listInt = new ArrayList<>();
        listInt.add(1);
        listInt.add(2);

        arr = listInt.stream().mapToInt(Integer::intValue).toArray();
    }
}
