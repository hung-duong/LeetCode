package edu.mum.medium.trie;

import java.util.*;

/**
 * Created by hungduong on 10/28/16.
 */
public class AddAndSearchWord {

    //Use the TrieNode
    public class WordDictionary {

        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        // Adds a word into the data structure.
        public void addWord(String word) {
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

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            if(word == null || word.length() == 0) return false;

            return searchNode(root, word, 0);
        }

        public boolean searchNode(TrieNode node, String str, int position) {
            HashMap<Character, TrieNode> children = (HashMap<Character, TrieNode>) node.children;
            char c = str.charAt(position);
            TrieNode t = null;

            if(c == '.') {
                for(Map.Entry entry : children.entrySet()) {
                    t = (TrieNode) entry.getValue();
                    if(t != null) {
                        if(str.length() - 1 == position) {
                            if(t.isLeaf) return true;
                        } else {
                            if(searchNode(t, str, position + 1)) return true;
                        }
                    }
                }
            } else {
                if(children.containsKey(c)) {
                    t = children.get(c);

                    if(str.length() - 1 == position) return t.isLeaf;

                    return searchNode(t, str, position + 1);
                }
            }

            return false;
        }
    }

    //Using the TrieNodeUpdated
    public class WordDictionary2 {

        private TrieNodeUpdated root;

        public WordDictionary2() {
            root = new TrieNodeUpdated();
        }

        // Adds a word into the data structure.
        public void addWord(String word) {
            if(word == null || word.length() == 0) return;

            TrieNodeUpdated node = root;

            for(Character c : word.toCharArray()) {
                if(node.nodes[c - 'a'] == null) {
                    node.nodes[c - 'a'] = new TrieNodeUpdated(c);
                }

                node = node.nodes[c - 'a'];
            }

            node.isLeaf = true;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            if(word == null || word.length() == 0) return false;

            return searchNode(root, word, 0);
        }

        public boolean searchNode(TrieNodeUpdated node, String str, int position) {
            char c = str.charAt(position);

            if(c == '.') {
                for(TrieNodeUpdated childNode : node.nodes) {
                    if(childNode != null) {
                        if(str.length() - 1 == position) {
                            if(childNode.isLeaf) return true;
                        } else {
                            if(searchNode(childNode, str, position + 1)) return true;
                        }
                    }
                }
            } else {
                if(node.nodes[c - 'a'] != null) {
                    if(str.length() - 1 == position) return node.nodes[c - 'a'].isLeaf;

                    return searchNode(node.nodes[c - 'a'], str, position + 1);
                }
            }

            return false;
        }
    }



    // Your WordDictionary object will be instantiated and called as such:
    // WordDictionary wordDictionary = new WordDictionary();
    // wordDictionary.addWord("word");
    // wordDictionary.search("pattern");
}
