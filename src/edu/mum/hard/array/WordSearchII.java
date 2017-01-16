package edu.mum.hard.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/15/17.
 */
public class WordSearchII {
    private class TrieNode {
        public TrieNode[] nodes;
        public String word;

        public TrieNode() {
            //26 character in alphabet
            nodes = new TrieNode[26];
        }
    }

    private TrieNode root;

    public WordSearchII() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if(word == null || word.length() == 0) return;

        TrieNode node = root;

        for(char c : word.toCharArray()) {
            if(node.nodes[c - 'a'] == null) {
                node.nodes[c - 'a'] = new TrieNode();
            }

            node = node.nodes[c - 'a'];
        }

        node.word = word;
    }

    //Use the DFS (backtracking) and Trie data structure
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if(board == null || board.length == 0 || words.length == 0)
            return result;

        //Build the Trie
        for(String word : words)
            addWord(word);

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root, result);
            }
        }

        return result;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        char c = board[i][j];
        if(c == '*' || node.nodes[c - 'a'] == null) return;

        node = node.nodes[c - 'a'];

        if(node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        //Here we used bit mask for every cell visited
        board[i][j] = '*';

        if(i > 0) dfs(board, i - 1, j, node, result);
        if(i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);

        //Return back to previous letter
        board[i][j] = c;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'s','e', 'e', 'n', 'e', 'w'},
                {'t','m', 'r', 'i', 'v', 'a'},
                {'o','b', 's', 'i', 'b', 'd'},
                {'w','m', 'y', 's', 'e', 'n'},
                {'l','t', 's', 'n', 's', 'a'},
                {'i','e', 'z', 'l', 'g', 'n'}
        };

        String[] word = {"anda"};

        WordSearchII WS = new WordSearchII();
        List<String> list = WS.findWords(board, word);

        list.forEach(System.out::println);
    }
}
