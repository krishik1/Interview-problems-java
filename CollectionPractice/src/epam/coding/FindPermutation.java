package epam.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPermutation {
	static int c=0;
	public static void main(String[] args) {
		List<Integer> in = Arrays.asList(1,2,3);
		List<List<Integer>> res = new ArrayList();
		//backTrack(in,new ArrayList<Integer>(),res); 
		backTrack1(in, 0, res);
		for(List<Integer> lis:res) {
			for(int val:lis) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
		try {
			System.out.println(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//not work for duplicates
	private static void backTrack(List<Integer> in, ArrayList<Integer> temp, List<List<Integer>> res) {
		if(temp.size()==in.size()) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int val:in) {
			c+=1;
			if(temp.contains(val)) {
				continue;
			}
			temp.add(val);
			backTrack(in, temp, res);
			temp.remove(temp.size()-1);
		}
	}
	
//	private static void backTrack1(List<Integer> in, int idx, List<List<Integer>> res) {
//		if(idx==in.size()) {
//			if(!res.contains(in)) {
//				res.add(new ArrayList<Integer>(in));
//			}
//			return;
//		}
//		for(int i=idx;i<in.size();i++) {
//			swap(in,i,idx);
//			backTrack1(in, idx+1, res);
//			swap(in,i,idx);
//		}
//	}
	
private static void backTrack1(List<Integer> in, int idx, List<List<Integer>> res) {
		
		if(idx==in.size()) {
			if(!res.contains(in)) {
				for(int val:in) {
					System.out.print(val+" ");
				}
				System.out.println();
				res.add(new ArrayList<Integer>(in));
			}
			return;
		}
		for(int i=idx;i<in.size();i++) {
			System.out.println(i+" "+idx);
			swap(in,i,idx);
			backTrack1(in, idx+1, res);
			swap(in, i, idx);
		}
	}

	private static void swap(List<Integer> in, int i, int idx) {
		int temp=in.get(i);
		in.set(i, in.get(idx));
		in.set(idx, temp);
		
	}
}
