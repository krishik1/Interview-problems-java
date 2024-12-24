package gap.interview.prep.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenAndPrime {
	public static void main(String[] args) {
		List<Integer> list =  Arrays.asList(12,17,10,22,19,39,11);
		List<Integer> res = list.stream().filter(i -> i%2==0).collect(Collectors.toList());
		for(int val:res) {
			System.out.print(val+" ");
		}
		System.out.println();
		List<Integer> primes = list.stream().filter(FilterEvenAndPrime::isPrime).collect(Collectors.toList());
		primes.forEach(System.out::println);
	}
	
	public static boolean isPrime(int val) {
		int cnt=0;
		for(int i=2;i*i<=val;i++) {
			if(val%i==0) {
				cnt++;
			}
		}
		return cnt==0?true:false;
	}

}
