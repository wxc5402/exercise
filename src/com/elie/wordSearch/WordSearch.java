package com.elie.wordSearch;


import com.elie.trie.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {

    Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<String>(res);
    }

    private void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
        if (i < 0 || i > board.length || j < 0 || j > board[0].length) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        str+=board[i][j];
        if(!trie.startsWith(str)){
            return;
        }
        if (trie.search(str)) {
            res.add(str);
        }

        visited[i][j] = true;
        dfs(board, visited, str, i - 1, j, trie);
        dfs(board, visited, str, i + 1, j, trie);
        dfs(board, visited, str, i, j - 1, trie);
        dfs(board, visited, str, i, j + 1, trie);
        visited[i][j] = false;
    }
}
