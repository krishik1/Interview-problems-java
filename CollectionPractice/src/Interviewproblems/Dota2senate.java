package Interviewproblems;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2senate {

	public static void main(String[] args) {
		String senate ="DDRRR";
		System.out.println("res : "+predictPartyVictory(senate));
	}
	
	public static String predictPartyVictory(String senate) {
        int n=senate.length();
        Queue<Integer> qr =new LinkedList<>();
        Queue<Integer> qd =new LinkedList<>();
        for(int i=0;i<n;i++) {
            char ch = senate.charAt(i);
           if(ch == 'R') {
                qr.add(i);
            } else {
                qd.add(i);
            }
        }
        while(!qr.isEmpty() && !qd.isEmpty()) {
            int r=qr.poll();
            int d=qd.poll();
            if(r>d) {
                qd.add(d+n);
            } else {
                qr.add(r+n);
            }
        }

        return qd.size()>qr.size()?"Dire":"Radiant";
        
    }
}
