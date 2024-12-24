package gap.interview.prep.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatableCharacter {
	public static void main(String[] args) {
		String str = "cascadeing";
		 Character x = str.chars().mapToObj(ch -> (char) ch).filter(val -> str.indexOf(val)== str.lastIndexOf(val)).findFirst().get();
		 System.out.println(x);
		 Map<Character, Long> map = str.chars().mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		 Character y = str.chars().mapToObj(ch -> (char) ch).filter(ch -> map.get(ch)==1).findFirst().orElse(null);
		 System.out.println(y);
	}

}
