package edu.leetcode.medium.string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by hungduong on 7/24/17.
 */
public class ReplaceWords {
    public String replaceWords01(List<String> dict, String sentence) {
        Trie trie = new Trie();

        for (String str : dict) {
            trie.insert(str);
        }

        String[] arr = sentence.split(" ");
        for(int i = 0; i < arr.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(arr[i]);

            boolean found = false;
            for (int j = 0; j < stringBuilder.length() && !found; j++) {
                if (trie.search(stringBuilder.subSequence(0, j + 1).toString())) {
                    arr[i] = stringBuilder.subSequence(0, j + 1).toString();
                    found = true;
                }
            }
        }

        return Arrays.stream(arr).collect(Collectors.joining(" "));
    }

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

                    if (!t.isLeaf)
                        children = (HashMap<Character, TrieNode>) t.children;
                    else
                        return t;
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

    public class TrieNode {
        public char c;
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isLeaf;

        public TrieNode() {}

        public TrieNode(char c){
            this.c = c;
        }
    }


    //Solution 2:
    public String replaceWords02(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0) return sentence;

        Set<String> hashSet = new HashSet<>();
        for (String str : dict) {
            hashSet.add(str);
        }

        String[] strings = sentence.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            StringBuilder sb = new StringBuilder(strings[i]);

            int j = 1;
            while (j <= sb.length()){
                if (hashSet.contains(sb.substring(0, j))) {
                    break;
                }
                j++;
            }

            j = j <= sb.length() ? j : sb.length();
            res.append(" " + sb.substring(0, j).toString());
        }

        return res.deleteCharAt(0).toString();
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("rat");
        dict.add("bat");
        String sentence = "the cattle was rattled by the battery";

        ReplaceWords rw = new ReplaceWords();
        String res = rw.replaceWords02(dict, sentence);
        System.out.print(res);
    }
}
