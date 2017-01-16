package edu.mum.medium.trie;

import java.util.HashMap;

/**
 * Created by hungduong on 10/30/16.
 */
public class ImplementTriePrefixTree {
    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            HashMap<Character, TrieNode> children = (HashMap<Character, TrieNode>) root.children;

            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                TrieNode t;
                if(children.containsKey(c)) {
                    t = children.get(c);
                } else {
                    t = new TrieNode(c);
                    children.put(c, t);
                }

                children = (HashMap<Character, TrieNode>) t.children;

                //set leaf node
                if(i == word.length() - 1) {
                    t.isLeaf = true;
                }
            }
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode t = searchNode(word);

            if(t != null && t.isLeaf) {
                return true;
            } else {
                return false;
            }
        }

        public TrieNode searchNode(String str) {

            HashMap<Character, TrieNode> children = (HashMap<Character, TrieNode>) root.children;
            TrieNode t = null;

            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if(children.containsKey(c)) {
                    t = children.get(c);
                    children = (HashMap<Character, TrieNode>) t.children;
                } else {
                    return null;
                }
            }

            return t;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if(searchNode(prefix) != null) {
                return true;
            } else {
                return false;
            }
        }
    }
}
