package Interviewproblems;
/*You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true*/
public class FlowersBed {
	public static void main(String[] args) {
		int[] arr = {1,0,0,0,1};
		int n=2;
		System.out.println("res : "+canPlaceFlowers(arr, n));
	}
	
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){return true;}
        for(int i=0;i<flowerbed.length;i++){
            boolean left= i==0 || flowerbed[i-1]==0;
            boolean right= i==flowerbed.length-1 || flowerbed[i+1]==0;
            if(left && right && flowerbed[i]==0){
                flowerbed[i]=1;
                n--;
                if(n==0){return true;}
            }
        }
        return false;
    }


}
