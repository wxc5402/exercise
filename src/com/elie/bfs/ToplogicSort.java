package com.elie.bfs;

import java.util.*;

public class ToplogicSort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];  // 计算入度

        // 组建有向图
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            graph.computeIfAbsent(start, x->new ArrayList<>()).add(end);
            indegree[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
                if (--indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        return count == numCourses;
    }
}
