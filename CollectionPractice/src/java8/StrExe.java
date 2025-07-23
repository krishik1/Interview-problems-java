package java8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StrExe {
	 public static void main(String[] args) {
		 String s= "leEeetcode";
		 //System.out.println("Ans :"+getLength(s));
		 //String x="foo",y="bar";
		 //System.out.println("isIsomorphic :"+isIsomorphic(x, y));
		 int[] students = {1,1,1,0,0,1};
		 int[] sandwiches = {1,0,0,0,1,1};
		 //System.out.println("makeGood : "+makeGood(s));
		 System.out.println(" COUNT : "+countStudents(students,sandwiches));

	 }
	 public static int getLength(String s) {
		 s=s.trim();
		 int n=s.length(),len=0;
		 for(int i=n-1;i>=0;i--) {
			 if(s.charAt(i)!=' ') {
				 len++;
			 } else if(len>0) {
				 break;
			 }
		 }
		 return len;
	 }
	 public static boolean isIsomorphic(String s,String t) {
		 HashMap<Character,Character> hm=new HashMap<>();
		 for(int i=0;i<s.length();i++) {
			 char curr=s.charAt(i),replace=t.charAt(i);
			 if(!hm.containsKey(curr)) {
				 if(!hm.containsValue(replace)) {
					 hm.put(curr, replace);
				 } else {
					 return false;
				 }
			 } else {
				 if(hm.get(curr)!=replace) {
					 return false;
				 }
			 }
		 }
		 return true;
	 }
	 
	 
	 public static String makeGood(String s) {
	        char[] ch=s.toCharArray();
	        int endPos=0;
	        for(int i=0;i<s.length();i++){//i=curr
	            if(endPos>0 && Math.abs(ch[endPos-1]-ch[i])==32){
	                endPos--;
	            } else{
	                //ch[endPos]=ch[i];  
	                System.out.println(ch[endPos]+" "+ch[i]);
	                endPos++;
	            }
	        }
	        return new String(ch).substring(0,endPos);
	        
	    }
	 
	 public static int countStudents(int[] students, int[] sandwiches) {
	        Queue<Integer> q=new LinkedList<>();
	        Stack<Integer> st=new Stack<>();
	        for(int i=0;i<students.length;i++){
	            q.add(students[i]);
	            st.add(sandwiches[i]);
	        }
	        int j=0;
	        while(!st.isEmpty() && j<st.size()){
	            if(q.peek().equals(st.peek())){
	            	System.out.println(q.poll());
	            	System.out.println(st.pop());
	               // System.out.println();
	                j=0;
	            } else{
	                int x=q.poll();
	                q.add(x);
	                System.out.println("size() :"+st.size());
	                j++;
	            }
	        }
	        return st.size();
	    }

}
