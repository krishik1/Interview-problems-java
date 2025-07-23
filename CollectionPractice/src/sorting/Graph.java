package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Graph {
	public static void main(String[] args) {
		int A = 7; // Number of vertices
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(1, 2, 468)));
        B.add(new ArrayList<>(Arrays.asList(2, 3, 335)));
        B.add(new ArrayList<>(Arrays.asList(3, 1, 501)));
        B.add(new ArrayList<>(Arrays.asList(2, 4, 170)));
        B.add(new ArrayList<>(Arrays.asList(2, 5, 725)));
        B.add(new ArrayList<>(Arrays.asList(2, 7, 479)));
        B.add(new ArrayList<>(Arrays.asList(4, 6, 359)));
        B.add(new ArrayList<>(Arrays.asList(5, 6, 963)));
        
        ArrayList<Integer> result = solve(A, B);
        System.out.println("Result: " + result);
		
		
	}
	static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + dest;
            result = prime * result + src;
            result = prime * result + weight;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Edge other = (Edge) obj;
            if (dest != other.dest)
                return false;
            if (src != other.src)
                return false;
            if (weight != other.weight)
                return false;
            return true;
        }
    }

	static int[] par;

    public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
    	ArrayList<ArrayList<Integer>> org = new ArrayList<>(B.size());
    	for (ArrayList<Integer> innerList : B) {
    	    ArrayList<Integer> innerCopy = new ArrayList<>(innerList);
    	    org.add(innerCopy);
    	}
//        for (int i = 0; i < B.size(); i++) {
//            ArrayList<Integer> list = B.get(i);
//            org.add(list);
//        }
        org.sort((a, b) -> a.get(2) - b.get(2));
        HashMap<Edge, Integer> hm = new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>(Collections.nCopies(B.size(), 0));

        if (B.size() == 1) {
            res.set(0, 1); // Set the first element to 1 if there's only one edge
            return res;
        }

        par = new int[A + 1];
        for (int i = 0; i <= A; i++) {
            par[i] = i;
        }
        for (ArrayList<Integer> edge : org) {
            int x = edge.get(0), y = edge.get(1), wt = edge.get(2);
            if (DSU(x, y)) {
                hm.put(new Edge(x, y, wt), 1);
            } else {
                hm.put(new Edge(x, y, wt), 0);
            }
        }
        
        for (int i = 0; i < B.size(); i++) {
            Edge edge = new Edge(B.get(i).get(0), B.get(i).get(1), B.get(i).get(2));
            if (hm.containsKey(edge)) {
                res.set(i, hm.get(edge)); // Use set() method to update elements in the res ArrayList
            } else {
                res.set(i, 0); // Set to 0 if the edge is not found in the HashMap
            }
        }
        return res;
    }

    public static int getRoot(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = getRoot(par[x]);
    }

    public static boolean DSU(int x, int y) {
        int rx = getRoot(x);
        int ry = getRoot(y);
        if (rx == ry) {
            return false;
        } else {
            par[rx] = ry;
            return true;
        }
    }
}
