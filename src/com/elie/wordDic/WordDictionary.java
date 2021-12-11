package com.elie.wordDic;

public class WordDictionary {
    TrieNode root;
    public WordDictionary () {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return helper(word, 0 , root);
    }

    private boolean helper(String word, int pos, TrieNode node) {
        if (pos == word.length()) {
            return node.isWord;
        }
        char ch = word.charAt(pos);
        if (ch != '.' ) {
            return node.children[ch - 'a'] != null && helper(word, pos + 1, node.children[ch - 'a']);
        }
        for (int index =0; index < 26; index++) {
            if (node.children[index] != null
                    && helper(word, pos + 1, node.children[index])) {
                return true;
            }
        }
        return false;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
}
