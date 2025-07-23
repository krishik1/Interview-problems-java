package Greedy;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] A= {1,2,3,4,5};
        //System.out.println("ANS :"+countSubarrays(A,1,5));
        int[] res=getPF(A);
        for(int val:res) {
        	System.out.print(val+" ");
        }
        
    }
//    public static int maxSubarrayLength(int[] nums, int k) {
//        HashMap<Integer,Integer> hm=new HashMap<>();
//        int i=0,j=0,n=nums.length,max=0;
//        
//        while(j<n){
//        	hm.put(nums[j],hm.getOrDefault(nums[j], 0)+1);
//        	while(hm.get(nums[j])>k && i<=j) {
//        		hm.put(nums[i], hm.get(nums[i])-1);
//        		i++;
//        	}
//        	max=Math.max(max,j-i+1);
//        	j++;
//        }
//        
//        return max;
//    }
//    public static int getMax(int[] nums) {
//    	int max=0;
//    	for(int val:nums) {
//    		max=Math.max(val, max);
//    	}
//    	return max;    	
//    }
//    
//	public static long countSubarrays(int[] nums, int k) {
//		int max=getMax(nums);
//		int i=0,j=0,c=0,n=nums.length;
//		long subCount=0;
//		while(j<n) {
//			if(nums[j]==max) {
//				c++;
//			}
//			while(c>=k) {
//				subCount+=n-j;
//				if(nums[i]==max) {
//					c--;
//				}
//				i++;
//			}
//			j++;
//		}
//		return subCount;      
//		
//	 }

//	public static long countSubarrays(int[] nums, int minK, int maxK) {
//	      int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,n=nums.length;
//	      int i=0,mini=0,maxi=0,j=0,ans=0,c1=0,c2=1;
//	      long c=0;
//	      while(nums[i]!=minK) {
//	    	  i++;
//	      }
//	      
//	      while(nums[j]!=maxK) {
//	    	  j++;
//	      }
//	      maxi=i;mini=j;
//	      while(j<n) {
//	    	  
//	    	 while(minK>=nums[i+1] && i<=j) {
//	    		 if(minK>nums[i+1]) {
//	    			 c1=0;
//	    			 i++;
//	    		 } else {
//	    			 c1++;
//	    			 i++;
//	    		 }
//	    	 }
//	    	 while(maxK<=nums[i+1] && j<n-1) {
//	    		 if(maxK<nums[j+1]) {
//	    			 c2=0;
//	    			 //j++;
//	    		 } else {
//	    			 c2++;
//	    			 j++;
//	    		 }
//	    	 }
//	    	 c+=(c1*(c1+1)/2)+(c2*(c2+1)/2)+1;
//	    	 j++;
//	      }
//	      
//	      
//	      return c;
//    }
    
    public static int[] getPF(int[] A){
    	int[] pf=new int[A.length];
    	int[] sf=new int[A.length];
    	int[] res=new int[A.length];
    	int n=A.length;
    	pf[0]=A[0];
    	for(int i=1;i<n;i++){
    		pf[i]=pf[i-1]*A[i];
    	}
    	sf[n-1]=A[n-1];
    	for(int i=n-2;i>=0;i--){
    		sf[i]=sf[i+1]*A[i];
    	}
    	res[0]=sf[1];
    		res[n-1]=pf[n-2];
    	for(int i=1;i<n-1;i++){
    		res[i]=pf[i-1]*sf[i+1];
    	}

    	return res;
    }
  }
