package Greedy;

public class CoinsProblem {
	 public static void main(String[] args) {
		 int ip=20;
		 int ans=solve(ip);
		 System.out.println("ans :"+ans);
	 }
	 public static int getMaxPower(int A){
	        int mp=0;
	        if(A==Math.pow(5,mp)){
                return mp;
            }
	        while(A>Math.pow(5,mp)){
	            mp++;
	            if(A==Math.pow(5,mp)){
	                return mp;
	            }
	        }
	        System.out.println("mp :"+mp);
	        return mp-1;
	    }
	    public static int solve(int A) {
	        int mp=getMaxPower(A);
	        int c=0;
	        if(A%Math.pow(5,mp)==0){
	            c+=A/Math.pow(5,mp);
	            return c;
	        } else{
	            while(A!=0){
	                c+=A/Math.pow(5,mp);
	                System.out.println("c :"+c+"A :"+A);
	                A%=Math.pow(5,mp);
	                mp--;
	            }
	        }
	        return c;
	    }


}
