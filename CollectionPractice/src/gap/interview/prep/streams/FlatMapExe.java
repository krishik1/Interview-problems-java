package gap.interview.prep.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExe {
	public static void main(String[] args) {
		List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2,3), Arrays.asList(3, 4,6),Arrays.asList(9, 7,6));
		List<Integer> flattened = lists.stream().flatMap(List::stream).collect(Collectors.toList());
			for(int val:flattened) {
				System.out.print(val+" ");
			}
	}
}
