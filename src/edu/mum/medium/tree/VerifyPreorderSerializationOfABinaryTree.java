package edu.mum.medium.tree;

/**
 * Created by hungduong on 10/9/16.
 * Complexity: O(n)
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public static boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0) {
            return false;
        }

        String[] strArr = preorder.split(",");

        int index = 0;
        int diff = 1;
        for(String s : strArr) {
            if(s.equals("#")) {
                diff--;
            } else {
                diff++;
            }

            if (diff == 0 && index < strArr.length - 1) {
                return false;
            }

            index++;
        }

        return diff == 0 ? true : false;
    }


    public static void main(String[] args) {
        String str = "7,2,#,2,#,#,#,6,#";

        System.out.println(VerifyPreorderSerializationOfABinaryTree.isValidSerialization(str));
    }
}
