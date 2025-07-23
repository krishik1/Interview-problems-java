package alogorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Welcome {
	public static void main(String args[]) {
		System.out.println("Welcome to Eclipse");
		int array[]= {1,2,3,5};
		System.out.println(MissingNumber(array,5));
	}
    static int MissingNumber(int array[], int n) {
        Arrays.sort(array);
        int len=array.length;
        int first=1;
        for(int i=0;i<n;i++) {
        	if(array[i]!=first && i<n-1) {
        		return first;
        	} else if(array[len-1]<n){
        		return n;
				
			}
        	first++;
        }
        return -1;
    }

}
