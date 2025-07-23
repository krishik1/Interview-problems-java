package Interviewproblems;

import java.util.Stack;

public class Decode {
	public static void main(String[] args) {
		String str = "2[abc]3[cd]ef";
		System.out.println("res : "+decodeString(str));
	}

	public static String decodeString(String s) {
		Stack<Integer> st = new Stack<>();
		Stack<StringBuilder> st1 = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = 0;
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				n = n * 10 + (ch - '0');
			} else if (ch == '[') {
				st.add(n);
				n = 0;
				st1.add(sb);
				sb = new StringBuilder();
			} else if (ch == ']') {
				int k = st.pop();
				StringBuilder temp = sb;
				sb = st1.pop();
				while (k-- > 0) {
					sb.append(temp);
				}
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

}
