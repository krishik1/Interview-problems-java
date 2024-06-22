package leetcode;

import java.util.HashSet;

public class Contest1 {
	public static void main(String[] args) {
		int[] arr= {3,6,9};
		int k=3;
		System.out.println("ans : "+findKthSmallest(arr, k));
		
	}
	
	    public static long findKthSmallest(int[] coins, int k) {
	        int minVal=getMin(coins),maxRange=minVal*k,val=0;
	        HashSet<Integer> set=new HashSet<>();
	        int x=k;
	        for(int j=1;j<=x;j++){
	            for(int i=0;i<coins.length;i++){
	                val=j*coins[i];
	                if(!set.contains(val) && val<=maxRange){
	                    set.add(val);
	                    k-=1;
	                }
	                if(k==0) return val;
	            }
	        }
	        return val;
	    }
	   
	    public static int getMin(int[] coins){
	        int min=Integer.MAX_VALUE;
	        for(int i=0;i<coins.length;i++){
	            min=Math.min(min,coins[i]);
	        }
	        return min;
	    }
	}


