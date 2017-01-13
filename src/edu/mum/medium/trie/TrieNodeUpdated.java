package edu.mum.medium.trie;

/**
 * Created by hungduong on 10/30/16.
 */
public class TrieNodeUpdated {
    public char c;
    public TrieNodeUpdated[] nodes;
    public boolean isLeaf;

    public TrieNodeUpdated() {
        //26 character in alphabet
        nodes = new TrieNodeUpdated[26];
    }

    public TrieNodeUpdated(char c){
        this();
        this.c = c;
    }
}
