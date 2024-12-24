package gap.interview.prep.streams;

import java.util.Arrays;
import java.util.List;

public class ReduceExe {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12,19,13,10,40,26);
		int sum = list.stream().reduce(0,(init,s)->s+=init);
		System.out.println(sum);
		int maxi=list.stream().reduce(Integer.MIN_VALUE,(max,a)->Math.max(max, a));
		System.out.println(maxi);
	}
}
