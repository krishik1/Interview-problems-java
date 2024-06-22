package alogorithms;

import java.util.HashSet;

public class GCDofstring {

	public static void main(String[] args) {
		String str1 = "ABABAB", str2 = "ABAB";
		String res = gcdOfStrings(str1, str2);
		System.out.println("res : " + res);
		int[] test= {7,5,6,8,3,8,9};
		int[] result=countSort1(test);
		for(int val:result) {
			System.out.print(val+" ");
		}
	}

	public static String gcdOfStrings(String str1, String str2) {
		int m = str1.length(), n = str2.length();
		HashSet<Character> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (!set.contains(str2.charAt(i))) {
				sb.append(str2.charAt(i));
				set.add(str2.charAt(i));
			}
		}
		String x = sb.toString();
		System.out.println(" x: " + x);
		int len = x.length();
		int j = 0;
		while (j <= m) {
			if (j + len <= m && x.equals(str1.substring(j, j + len))) {
				j += len;
			} else {
				break;
			}
		}
		return j == m ? x : "";

	}

	public static int[] countSort(int[] x) {
		int max = Integer.MIN_VALUE;
		HashSet<Integer> set = new HashSet<>();
		int n = x.length;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, x[i]);
			set.add(x[i]);
		}
		int idx = 0;
		for (int i = 0; i <=max; i++) {
			if (set.contains(i)) {
				x[idx++] = i;
			}
		}
		return x;
	}
	
	public static int[] countSort1(int[] x) {
		int max = Integer.MIN_VALUE;
		int n = x.length;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, x[i]);
		}
		int idx = 0;
		int[] maxArr=new int[max+1];
		for(int i = 0; i <n; i++) {
			maxArr[x[i]]++;
		}
		for(int i=0;i<=max;i++) {
			while(maxArr[i]>0) {
				x[idx++]=i;
				maxArr[i]--;
			}
		}
		return x;
	}
}
