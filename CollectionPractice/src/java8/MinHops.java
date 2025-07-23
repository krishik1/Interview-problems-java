package java8;

public class MinHops {
	static int minJumps(int arr[],int n) {
		int pos=0,des=0,jmp=1;
		for(int i=0;i<n;i++) {
			if(arr[0]==0)return -1;
			else {
				if(i==n-1) {
					return jmp;
				}
				des=Math.max(des, i+arr[i]);
				if(pos==i) {
					pos=des;
					jmp++;
				}
			}
		}
		return jmp;
	}
	public static void main(String[] args) {
		//int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int arr[] = { 2,3,1,1,4};
        int n = arr.length;
        System.out.print(
            "Minimum number of jumps to reach end is "
            + minJumps(arr, n));
    }

}
