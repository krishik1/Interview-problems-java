package Interviewproblems;

import java.util.Arrays;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MergeIntervals {
	public static void main(String[] args) {
		int[][] in = {{1,3},{2,6},{8,10},{9,18}};
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.x-b.x);
		PriorityQueue<Pair> pq1 = new PriorityQueue<>((a,b)->a.x-b.x);
		for(int i=0;i<in.length;i++) {
			pq.add(new Pair(in[i][0], in[i][1]));
		}
		Pair t = pq.poll();
		while(!pq.isEmpty()) {
			Pair curr = pq.poll();
			if(curr.x<=t.y) {
				t.y=curr.y;
			} else {
				pq1.add(t);
				t=curr;
			}
		}
		pq1.add(t);
		int n= pq1.size(),c=0;
		int[][] res =  new int[n][2];
		
		while(!pq1.isEmpty()) {
			Pair f=pq1.poll();
			res[c][0] = f.x;
			res[c][1] = f.y;
			c++;
		}
		
//		for(int[] row:res) {
//			System.out.println(row[0]+" "+row[1]);
//		}
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 3, 2, 5,1,3,6);
		System.out.println(firstNonRepeatingElement(list));
		
		String sentence = "Check out the accompanying and and guide you on how to prepare for each module effectively";
        Map<String,Long> freqMap = Arrays.stream(sentence.split("\\s+")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        freqMap.forEach((k,v)-> {if(v==1) System.out.print(k+" ");});
		
	}
	
	private static int firstNonRepeatingElement(List<Integer> arr) {
		LinkedHashMap< Integer, Integer> map = new LinkedHashMap<>();
		arr.forEach(val -> map.put(val, map.getOrDefault(val, 0) + 1));
		Optional<Integer> ans = arr.stream().filter(val->map.get(val)==1).findFirst();
		return ans.get();
		
	}


}
