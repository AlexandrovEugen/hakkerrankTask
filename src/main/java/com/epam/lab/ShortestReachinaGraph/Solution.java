package com.epam.lab.ShortestReachinaGraph;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numQueries = scan.nextInt();

        for (int q = 0; q < numQueries; q++) {
            int numNodes = scan.nextInt();
            int numEdges = scan.nextInt();

            HashMap<Integer, Graph> graph = new HashMap<>();

            for (int i = 0; i < numNodes; i++) {
                graph.put(i + 1, new Graph(i + 1));
            }

            for (int i = 0; i < numEdges; i++) {
                final Graph graph1 = graph.get(scan.nextInt());
                final Graph graph2 = graph.get(scan.nextInt());

            }
        }
    }

    public static class Graph {
        List<List<Integer>> adjLst;
        int size;
        public Graph(int size) {
            adjLst = new ArrayList<>();
            this.size = size;
            while(size-- > 0)
                adjLst.add(new ArrayList<>());
        }

        public void addEdge(int first, int second) {
            adjLst.get(first).add(second);
            adjLst.get(second).add(first);
// For undirected graph, you gotta add edges from both sides.
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[size];
            Arrays.fill(distances, -1); // O(n) space.
            Queue<Integer> que = new LinkedList<>();

            que.add(startId); // Initialize queue.
            distances[startId] = 0;
            HashSet<Integer> seen = new HashSet<>(); //O(n) space. Could be further optimized. I leave it to you to optimize it.

            seen.add(startId);
            while(!que.isEmpty()) { // Standard BFS loop.
                Integer curr = que.poll();
                for(int node : adjLst.get(curr)) {
                    if(!seen.contains(node)) {
                        que.offer(node);
                        // Right place to add the visited set.
                        seen.add(node);
                        // keep on increasing distance level by level.
                        distances[node] = distances[curr] + 6;
                    }
                }
            }
            return distances;
        }
    }
}
