package edu.leetcode.medium.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hungduong on 2/26/17.
 */
public class AutoCompleter {
    private TrieNode root;

    private class TrieNode {
        public char c;
        public Map<Character, TrieNode> children = new HashMap<>();
        public List<String> data = new ArrayList<>();
        public boolean isLeaf;

        public TrieNode() {}

        public TrieNode(char c){
            this.c = c;
        }
    }

    AutoCompleter() {
        root = new TrieNode();
    }

    // Build dictionary
    public void buildDictionary(String[] dictionary) {
        for(String input : dictionary) {
            insert(input);
        }
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            node.data.add(word);

            TrieNode t;
            if(node.children.containsKey(c)) {
                t = node.children.get(c);
            } else {
                t = new TrieNode(c);
                node.children.put(c, t);
            }

            node = t;

            if(i == word.length() - 1) {
                node.isLeaf = true;
            }
        }
    }

    public List<String> search(String str) {
        List<String> result = null;
        TrieNode t = root;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(t.children.containsKey(c)) {
                t = t.children.get(c);
            } else {
                return null;
            }

            if(i == str.length() - 1) {
                result = t.data;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] DICTIONARY = {
                "Oakland",
                "Sacramento",
                "San Diego",
                "San Francisco",
        };


        AutoCompleter ac = new AutoCompleter();
        ac.buildDictionary(DICTIONARY);
        List<String> result = ac.search("S");
        System.out.print(result);
    }
}
