package sorting;

import java.util.ArrayList;

public class Solution2 {
	public static void main(String[] args) {
		String str="110000111001";
		//System.out.println("ans :"+flip(str));
//		int[] arr=flip(str);
//		for(int val:arr) {
//			System.out.println("val :"+val);
//		}
//		int[] A= {0,0,9,9,9};
//		int[] res=plusOne(A);
//		for(int val:res) {
//			System.out.println(val);
//		}
//		ArrayList<Integer> list=new ArrayList<>();
//		list.add(0);
//		ArrayList<Integer> res=plusOne(list);
//		for(int i=0;i<res.size();i++) {
//			System.out.println("val :"+res.get(i));
//		}
		//System.out.println("result:"+solve(2));
		towerOfHanoi(1);
	}
	
	public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        int s=1,t=2,d=3;
        tOH(res,list,A,s,t,d);
        return res;
    }
	
	public static void tOH(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int n, int source, int auxiliary, int destination) {
        if (n == 1) {
        	list.add(n);
            list.add(source);
            list.add(destination);
            res.add(new ArrayList<>(list));
            return;
        }

        tOH(res, list, n - 1, source, destination, auxiliary);
        list.add(n);
        list.add(source);
        list.add(destination);
        tOH(res, list, n - 1, auxiliary, source, destination);
       
    }
	    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
	        int n=A.size(),carry=1;
	        System.out.println("n is:"+n);
	        for(int i=n-1;i>=0;i--){
	            int sum=A.get(i)+carry;
	            A.add(i,sum%10);
	            carry=sum/10;
	        }

	        if(carry>0){
	            A.add(0,carry);
	        }

	        while(!A.isEmpty() && A.get(0)==0){
	            A.remove(0);
	        }
	        return A;
	    }

	    
	    public static int solve(int A) {
	        int x=0,y=A,c=0;
	        //(x+y)=(x^y)+2*(x&y)
	        for(int i=30;i>=0;i--){
	            if((A&(1<<i))>0){
	                x=1<<(i+1);
	                c=i;
	                break;
	            }
	        }
	        for(int i=c;i>=0;i--){
	            y=y^(1<<i);
	        }
	        return x^y;
	    }
	
//	public static int[] plusOne(int[] A) {
//        int n=A.length;
//        int carry=1;
//        for(int i=n-1;i>=0;i--){
//            int sum=A[i]+carry;
//            A[i]=sum%10;
//            carry=sum/10;
//        }
//        ArrayList<Integer> tempList=new ArrayList<>();
//        for(int val:A){
//        	System.out.println("val :"+val);
//            tempList.add(val);
//        }
//        if(carry>0){
//        	System.out.println("At 0 :"+tempList.get(0));
//            tempList.add(0,carry);
//        }
//        while(!tempList.isEmpty() && tempList.get(0)==0){
//        	System.out.println("xxx");
//            tempList.remove(0);
//        }
//        
//        int[] res=new int[tempList.size()];
//        for(int i=0;i<res.length;i++){
//            res[i]=tempList.get(i);
//        }
//        return res;
//    }

	public static int[] flip(String A) {
        int csum=0,maxSum=0,l=0,r=0;
        int[] ans=new int[2];
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(ch=='1'){
                csum-=1;
            }else{
                csum+=1;
            }
            if(maxSum<csum){
                maxSum=csum;
                ans[0]=l+1;
                ans[1]=r+1;
            }
            if(csum<0){
                csum=0;
                l=i+1;
                r=i+1;
            }else{
                r+=1;
            }
        }
        if(maxSum==0){
            return new int[0];
        }else{
            return ans;
        }
    }

//	    public static String getPalidrome(String A,int p1,int p2){
//	    	while(p1>=0 && p2<A.length() && A.charAt(p1)==A.charAt(p2)){
//	            p1--;
//	            p2++;
//	        }
//	        return A.substring(p1+1,p2);
//	    }
//	    public static String longestPalindrome(String A) {
//	    	String ans=A.substring(0,1);
//	        for(int i=0;i<A.length();i++){
//	            String temp=getPalidrome(A,i,i);
//	            if(temp.length()>ans.length()){
//	                ans=temp;
//	            } 
//	        }
//	        for(int i=0;i<A.length()-1;i++){
//	            String temp=getPalidrome(A,i,i+1);
//	            if(temp.length()>ans.length()){
//	                ans=temp;
//	            } 
//	        }
//	        return ans;  
//	    }

}
