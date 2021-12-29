package com.elie.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class HasPath {
    int[][] dirs = {{0,1}, {0,-1}, {-1,0},{1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }

            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];

                if (!visited[x][y]) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
