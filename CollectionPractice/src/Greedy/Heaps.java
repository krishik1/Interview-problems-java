package Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Heaps {
	public static void main(String[] args) {
		ArrayList<Integer> A=new ArrayList<>();
		A.add(8);
		A.add(6);
		A.add(4);
		A.add(2);
		System.out.println("ans  "+solve(A, 8));
	}
	
//	public static int solve(ArrayList<Integer> A, int B) {
//        int candies=0;
//        PriorityQueue<Integer> pq=new PriorityQueue<>();
//        for(int i=0;i<A.size();i++){
//            pq.add(A.get(i));
//        }
//        if(A.size()<=1){
//            if(A.get(0)<=B){
//                candies+=A.get(0)/2;
//            }
//            return candies;
//        }
//        while(!pq.isEmpty()){
//            int x=pq.poll();
//            if(x>B) {
//            	break;
//            }
//            
//            if(x>1){
//                if(x%2==0){
//                     x/=2;
//                    candies+=x;
//                } else{
//                     x/=2;
//                    candies+=x;
//                    x+=1;
//                }
//            }
//            if(!pq.isEmpty()) {
//            	int y=pq.poll(); 
//                pq.add(y+x);
//            }
//            
//        }
//        return candies;
//    }

	public static int solve(ArrayList<Integer> A, int B) {
		PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<A.size();i++){
            pq.add(new Pair(i,A.get(i)));
        }
        
        int c=0;
        while(B>0){
            Pair curr=pq.poll();
            int z=curr.val+A.get(curr.ind);
            Pair newEntr=new Pair(curr.ind,z);
            if(B==1) {
            	return newEntr.val;
            }
            pq.add(newEntr);
            c++;
            System.out.println("c :"+c);
            B--;
        }
        int res=0;
//        System.out.println("ele :"+pq.peek().val);
//        for(int i=0;i<pq.size();i++) {
//        	pq.poll();
//        	Pair k=pq.peek();
//        	res=Math.max(res, k.val);
//        	System.out.println("ele :"+k.val); 	
//        }
        while (!pq.isEmpty()) {
            Pair k = pq.poll();
            System.out.println("ele :"+k.val);
            res = Math.max(res, k.val);
        }
        
        return res;
    }
}
