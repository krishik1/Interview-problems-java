package fi;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Checker {
	public static void main(String[] args) {
		String str ="abAcF25jC";
		String res = str.chars().mapToObj(ch->String.valueOf((char) ch)).filter(s->s.matches("[a-z]"))
		.collect(Collectors.joining(""));
		System.out.println(res);
		String res1 = str.chars().filter(Character::isUpperCase).mapToObj(Character::toString).
				collect(Collectors.joining(""));
		System.out.println(res1);
		String word = "This is Raju . Raju lives in Visakhapatnam . Raju works for TCS .";
		String ans = Arrays.stream(word.split("\\s+")).distinct().filter(val -> !val.equals(".")).collect(Collectors.joining(" "));
		String replace = Arrays.stream(word.split("\\s+")).map(strx -> strx.equals("Raju") ? "He" : strx) .filter(val -> !val.equals(".")).collect(Collectors.joining(" "));
		System.out.println(ans);
		System.out.println(replace);
	}

}
