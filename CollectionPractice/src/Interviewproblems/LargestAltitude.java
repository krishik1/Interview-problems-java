package Interviewproblems;

public class LargestAltitude {

	public static void main(String[] args) {
		int[] arr= {-5,1,5,0,-7};
		System.out.println("res : "+largestAltitude(arr));
	}
	public static int largestAltitude(int[] gain) {
        int[] pf=new int[gain.length+1];
        pf[0]=0;
        int max=pf[0];
        for(int i=0;i<gain.length;i++){
            pf[i+1]=pf[i]+gain[i];
            max=Math.max(max,pf[i+1]);
        }
        return max;
    }
}
