package edu.leetcode.medium.topologicalsort;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by hungduong on 10/30/16.
 */
public class CourseSchedule {
    private int V;  //No. of vertices

    //array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    //Function to add an edge into DataStructure.Graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.V = numCourses;
        this.adj = new LinkedList[numCourses];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }

        for(int index = 0; index < prerequisites.length; index++) {
            addEdge(prerequisites[index][1], prerequisites[index][0]);
        }

        HashMap<Integer, Integer> arr = topologicalSort();

        for(int index = 0; index < prerequisites.length; index++) {
            if(arr.get(prerequisites[index][1]) > arr.get(prerequisites[index][0]))
                return false;
        }

        return true;
    }

    // The function to do Topological Sort.
    private HashMap<Integer, Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();

        //Mark all vertices as not visited
        boolean[] visited = new boolean[V];

        for(int index = 0; index < V; index++)
            visited[index] = false;


        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for(int index = 0; index < V; index++) {
            if (!visited[index]) {
                topologicalSortHelper(index, visited, stack);
            }
        }

        HashMap<Integer, Integer> hasMap = new HashMap<>();
        int i = 0;
        while(!stack.isEmpty()) {
            hasMap.put(stack.pop(), i);
            i++;
        }

        return hasMap;
    }

    private void topologicalSortHelper(int v, boolean[] visited, Stack<Integer> stack) {
        // Mark the current node as visited.
        visited[v] = true;

        int i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> iter = adj[v].listIterator();
        while(iter.hasNext()) {
            i = iter.next();
            if(!visited[i]) {
                topologicalSortHelper(i, visited, stack);
            }
        }

        // Push current vertex to stack which stores result
        stack.push(v);
    }
}
