package printing.patterns;

import java.util.Scanner;

public class PatternPrintings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		upperTriangular(n);
//		lowerTriangular(n);
//		upperRightAngle(n);
//		lowerRightAngle(n);
		//rightArrow(n);
	}
	
	private static void upperTriangular(int n) {
		for(int i=0;i<n;i++) {
			//space
			for(int j=0;j<n-i-1;j++) {
				System.out.print(" ");
			}
			//star
			for(int j=0;j<2*i+1;j++) {
				System.out.print("*");
			}
			//space
			for(int j=0;j<n-i-1;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private static void lowerTriangular(int n) {
		for(int i=0;i<n;i++) {
			//space
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			//star
			for(int j=0;j<2*(n-i)-1;j++) {
				System.out.print("*");
			}
			//space
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private static void upperRightAngle(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	private static void lowerRightAngle(int n) {
		for(int i=0;i<n;i++) {
			for(int j=n;j>=i+1;j--) {
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private static void rightArrow(int n) {
		upperRightAngle(n);
		lowerRightAngle(n-1);
	}


}
