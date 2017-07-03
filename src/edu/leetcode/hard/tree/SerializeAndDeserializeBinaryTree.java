package edu.leetcode.hard.tree;

import edu.common.Utils.TreeNode;

import java.util.*;

/**
 * Created by hungduong on 4/29/17.
 */
public class SerializeAndDeserializeBinaryTree {
    // Serialization if the process of converting a data structure or object into a sequence of bits so that it can be stored
    // in a file or memory buffer or transmitted across a network connection link to be reconstructed later in the same or
    // another computer environment

    // Encodes a tree to a single string.
    // Use BFS
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();

        if(root == null) return list.toString();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(String.valueOf(node.val));

            if(node.left != null) {
                queue.add(node.left);
            } else {
                list.add("null");
            }

            if(node.right != null) {
                queue.add(node.right);
            } else {
                list.add("null");
            }
        }

        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;

        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));

        return buildTree(nodes);
    }

    public TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();

        if(val.equals("#")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
