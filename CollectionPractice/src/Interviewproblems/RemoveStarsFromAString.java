package Interviewproblems;

import java.util.Stack;

public class RemoveStarsFromAString {
	public static void main(String[] args) {
		String str = "leet**cod*e";
		System.out.println("res : "+removeStars1(str));
	}
	
	public static String removeStars1(String s) {
        Stack<Character> st =new Stack();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && ch=='*') {
                st.pop();
            } else {
                 st.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.empty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
	
	public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                 sb.append(ch);
            }
        }
        
        return sb.toString();
    }

}
