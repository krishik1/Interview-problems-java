package gap.interview.prep.streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EliminateDuplicateWords {
	public static void main(String[] args) {
		String sentence = "She saw the cat and the dog playing in the yard";
		Map<String, Long> map = Arrays.stream(sentence.split("\\s+")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		String res = String.join(" ", map.keySet());
		System.out.println(res);
		String str = Arrays.stream(sentence.split("\\s+")).filter(val -> map.get(val)==1).collect(Collectors.joining(" "));
		System.out.println(str);
	}

}
