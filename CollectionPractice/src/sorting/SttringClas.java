package sorting;

import java.util.HashMap;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
     val = x;
     left=null;
     right=null;
    }
}
public class SttringClas {
	public static void main(String[] args) {
		String str="crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv";
		//System.out.println("longestPalindrome : "+longestPalindrome(str));
//		String A="bgipsvukg";
//		String B="ylwfyulte";
//		int[] A= {1,17};
//		int B=15;
		//int A=4,B=3,C=20;
		TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(2);
        

        // Calculate and print the sum of left leaves
        int sum = solve(root);
//        System.out.println("Sum of left leaves: " + sum);
//		System.out.println(solve(root));
		//System.out.println(solve(83557));
        System.out.println(findAthFibonacci(4));
		
	}
	 
	
	public static int solve(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int sum=0;
		if(root.left!=null && root.left.left==null && root.right.right==null) {
			sum+=root.left.val;
		}
		sum+=solve(root.left);
		sum+=solve(root.right);
		return sum;
    }

	public static int findAthFibonacci(int A) {
        if(A==0){
            return 0;
        }
        if(A==1){
            return 1;
        }
        int sum1=findAthFibonacci(A-1);
        int sum2=findAthFibonacci(A-2);
        return sum1+sum2;
    }
	
	
//	 public static int solve(int A, long B) {
//	        if(A==1){
//	            return 0;
//	        }
//	        int parent=solve(A-1,B/2);
//	        if(B%2==0){
//	            return parent;
//	        }else { 
//	            return 1-parent;
//	        }
//	    }
	
//	public static int solve(int A) {
//        int sum=summation(A),x=0;
//        System.out.println("sum :"+sum);
//        if(sum<10) {
//        	if(sum==1) {
//        		return 1;
//        	} else {
//        		return 0;
//        	}
//        }
//        //solve(sum);
//        return solve(sum);
//    }
//    public static int summation(int A){
//        if(A<10){
//            return A%10;
//        }
//        return A%10+summation(A/10);
//    }
//	
	
	    public static int pow(int A, int B, int C) {
	        // Just write your code below to complete the function. Required input is available to you as the function arguments.
	        // Do not print the result or any output. Just return the result via this function.
	    	if (A == 0) {
	            return 0;
	        }
	        if (B == 0) {
	            return 1;
	        }

	        A = (A % C + C) % C; 

	        long temp = pow(A, B / 2, C);;
	        if (B % 2 == 0) {    
	            temp = (temp * temp) % C;
	        } else {
	            temp = ((temp * temp) % C * A) % C;
	        }

	        return (int) temp;
	    }

	
//	public static int solve(int[] A, int B) {
//		int n=A.length,c=0;
//        HashMap<Integer,Integer> hm=new HashMap<>();
//        for(int i=0;i<n;i++){
//		int a=A[i],b=B-a;
//		if(hm.containsKey(b)) {
//        	c=hm.get(b);
//        }
//        if(hm.containsKey(a)){
//            int k=hm.get(a);
//            k+=1;
//            hm.put(a,k);
//        } else{
//            hm.put(a,1);
//        }
//        
//        }
//        return c;
//    }
	
//	    public static String sort(String A){
//	        int n=A.length();
//	        int[] freq = new int[26];
//	        for (int i = 0; i < 26; i++) {
//	            freq[i] = 0;
//	        }
//	        for(int i=0;i<n;i++){
//	            freq[A.charAt(i)-'a']++;
//	        }
//	        StringBuilder sb=new StringBuilder();
//	        for(int j=0;j<26;j++){
//	            char ch=(char) (j+'a');
//	            for(int i=0;i<freq[j];i++){
//	                sb.append(ch);
	
//	            }
//	        }
//	        //System.out.println(sb.toString());
//	        return sb.toString();
//	    }
//	    public static int solve(String A, String B) {
//	        String x=sort(A);
//	        String y=sort(B);
//	        System.out.println("x :"+x+"y :"+y);
//	        if(x.equals(y)){
//	            return 1;
//	        }
//	        return 0;
//	    }
//	
//
//	
//	public static String solve(String A) {
//        String str=A.replaceAll("\\s+"," ");
//        System.out.println("str :"+str);
//        String[] s=str.split(" ");
////        for(String val:s) {
////        	System.out.println("val : "+val);
////        }
//        int j=s.length-1,i=0;
//        while(i<j){
//            String temp=s[i];
//            s[i]=s[j];
//            s[j]=temp;
//            i++;
//            j--;
//        }
//        //String b=String.join(" ",s);
//        StringBuilder sb=new StringBuilder();
//        for(int k=0;k<s.length;k++){
//            sb.append(s[k]);
//            if (k < s.length - 1) {
//                sb.append(" ");
//            }
//        }
//        
//        return sb.toString();
//    }
//	
//	    public static int[] palidrome(char[] A,int s,int e){
//	        int i=0,j=A.length;
//	        int[] arr=new int[3];
//	        while(s>=i && e<j && A[s]==A[e]){
//	            s--;
//	            e++;
//	        }
//	        arr[0]=s+1;
//	        arr[1]=e;
//	        arr[2]=e-s-1;
//	        return arr;
//	    }
//	    public static String longestPalindrome(String A) {
//	        int n=A.length(),ans=0;
//	        StringBuilder sb=new StringBuilder(A);
//	        char[] ch=A.toCharArray();
//	        int s=0,e=0;
//	        for(int i=0;i<n;i++){
//	            int[] odd=palidrome(ch,i,i);
//	            if(ans<odd[2]){
//	                ans=odd[2];
//	                s=odd[0];
//	                e=odd[1];
//	            }
//	        }
//	        for(int i=0;i<n-1;i++){
//	            int[] even=palidrome(ch,i,i+1);
//	             if(ans<even[2]){
//	                ans=even[2];
//	                s=even[0];
//	                e=even[1];
//	            }
//	        }
//	        System.out.println("S :"+s+" E :"+e);
//	        String v=sb.substring(s,e).toString();
//	        return v;
//
//	    }
	}

