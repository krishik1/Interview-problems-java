package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintBoundaryNumbers {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		List<Integer> ans = list.stream().skip(50).limit(10).collect(Collectors.toList());

		for (int val : ans) {
			System.out.print(val+" ");
		}
	}

}
