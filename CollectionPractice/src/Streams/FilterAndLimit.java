package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterAndLimit {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(22,14,10,36,32,16,17,18,40,20,15,45,50,42,28,48);
		List<Integer> res = list.stream().filter(val->val%2==0).sorted((a,b)->b-a).limit(3).collect(Collectors.toList());
		list.stream().filter(val->val%2==0).sorted((a,b)->b-a).limit(3).forEach(System.out::print);
		System.out.println();
		for(int val : res) {
			System.out.print(val+" ");
		}
		System.out.println();
		
		  List<Integer> prefix = list.stream().map(e->e.toString()).filter(val->val.charAt(0)=='1').map(Integer::valueOf).sorted((a,b)->b-a).collect(Collectors.toList());
		  
		  for(int val : prefix) {
			  System.out.print(val+" ");
		  }
		  System.out.println();
		   Optional<Integer> val = list.stream().sorted((a,b)->b-a).limit(5).skip(4).findAny();
		   Integer x = val.get();
		   System.out.println("res : "+x);
		  
		   
	}

}
