package Streams;

import java.util.Arrays;
import java.util.List;

public class AvgOfArrayElements {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(22, 21, 31, 15, 17, 16);
		System.out.println("Average : "+getAvg1(list));
	}
	public static double getAvg(List<Integer> list) {
		return list.stream().mapToInt(Integer::intValue).average().orElseThrow();
	}
	public static double getAvg1(List<Integer> list) {
		int sum = list.stream().reduce(0, (s,ele)->s+ele);
		int cnt = list.stream().reduce(0, (count,ele)->count+1);
		return sum/cnt;
	}

}
