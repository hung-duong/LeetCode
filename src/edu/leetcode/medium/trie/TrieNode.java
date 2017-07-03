package edu.leetcode.medium.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hungduong on 10/30/16.
 */
public class TrieNode {
    public char c;
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isLeaf;

    public TrieNode() {}

    public TrieNode(char c){
        this.c = c;
    }
}
