package com.elie.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class HasPath {
    int[][] dirs = {{0,1}, {0,-1}, {-1,0},{1,0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private void dijkstra(int[][] maze, int[] start, int[][] distance) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->a[2]-b[2]);

        queue.offer(new int[]{start[0], start[1], 0});
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            for (int[] dir : dirs) {
                int count = 0;
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                x -= dir[0];
                y -= dir[1];

                if (distance[cur[0]][cur[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[cur[0]][cur[1]] + count;
                    queue.offer(new int[]{x, y , distance[x][y]});
                }
            }
        }
//        boolean[][] visited = new boolean[maze.length][maze[0].length];
//        Queue<int[]> queue = new LinkedList<>();
//
//        queue.offer(start);
//        while(!queue.isEmpty()) {
//            int[] cur = queue.poll();
//            if (cur[0] == destination[0] && cur[1] == destination[1]) {
//                return true;
//            }
//
//            for (int[] dir : dirs) {
//                int x = cur[0] + dir[0];
//                int y = cur[1] + dir[1];
//                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
//                    x += dir[0];
//                    y += dir[1];
//                }
//                x -= dir[0];
//                y -= dir[1];
//
//                if (!visited[x][y]) {
//                    queue.add(new int[]{x, y});
//                    visited[x][y] = true;
//                }
//            }
//        }
//        return false;
    }
}
