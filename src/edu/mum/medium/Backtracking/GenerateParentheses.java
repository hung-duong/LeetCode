package edu.mum.medium.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 9/18/16.
 */
public class GenerateParentheses {
    //Solution 1
    List<String> stringList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        stringList.clear();

        generateParenthesisHelper(n);

        return stringList;
    }

    public void generateParenthesisHelper(int n) {
        if(n <= 0) {
            return;
        } else {
            List<String> list = new ArrayList<>();

            if(stringList.isEmpty()) {
                stringList.add("()");
            } else {
                list.clear();
                for(String s : stringList) {
                    StringBuilder stringBuilder = new StringBuilder(s);

                    for(int index = 0; index <= s.length() / 2; index++) {
                        stringBuilder.insert(index, "()");
                        if(!list.contains(stringBuilder.toString())) {
                            list.add(stringBuilder.toString());
                        }
                        stringBuilder.replace(index, index + 2, "");
                    }
                }

                stringList.clear();
                stringList.addAll(new ArrayList<>(list));
            }

            generateParenthesisHelper(n-1);
        }
    }


    //Solution 2
    public static List<String> generateParenthesis2(int n)
    {
        List<String> list = new ArrayList<>();

        if(n==0)return list;

        genParentHelper(list, "", n, 0);

        return list;
    }

    public static void genParentHelper(List<String> cu_list, String cu_string, int l, int r) {
        if( l == 0 && r == 0) {
            cu_list.add(cu_string);
            return;
        }

        if(l > 0) {// open left bracket
            genParentHelper(cu_list,cu_string + "(", l - 1, r + 1);
        }

        if(r > 0) {
            genParentHelper(cu_list,cu_string + ")", l, r - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> stringList =  generateParentheses.generateParenthesis2(2);
        stringList.forEach(System.out::println);
    }
}
