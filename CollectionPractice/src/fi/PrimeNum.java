package fi;

import java.util.Arrays;
import java.util.List;

public class PrimeNum {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11,7,12,22,23,67,47);
		list.stream().filter(val -> {
			if(val==1 ||val==2 || val==3) return true;
			for(int i=2;i*i<=val;i++ ) {
				if(i*(val/i) == val) {
					return false;
				}
			}
			return true;
		}).forEach(System.out::println);
	}
}
