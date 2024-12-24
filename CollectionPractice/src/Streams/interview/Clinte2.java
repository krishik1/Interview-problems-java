package Streams.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Clinte2 {
	public static void main(String[] args) {
		Employee e1 = new Employee("Krish", 22, 120000);
		Employee e2 = new Employee("jaga", 22, 129000);
		Employee e3 = new Employee("adhi", 22, 120900);
		Employee e4 = new Employee("chid", 22, 110000);
		Employee e5 = new Employee("santos", 22, 111000);
		HashMap<String,Employee> map = new HashMap<>();
		map.put("Krishik", e1);
		map.put("Jagadeesh", e2);
		map.put("Adhitya", e3);
		map.put("Chidvi", e4);
		map.put("Santosh", e5);
		
		List<Employee> res = map.values().stream().filter(e -> e.getSalary()>=120000).collect(Collectors.toList());
		for(Employee emp:res) {
			System.out.println(emp.getName()+" "+emp.getSalary());
		}
		firstRepeatedChar("xabdanjdn daahadhk");
		int[] arr = {4,3,2,7,8,2,3,1};
		findRepeatingNumbers(arr);
		System.out.println();
		System.out.println(findLongestSubString());
	}
	
	private static void firstRepeatedChar(String str) {
		Map<Object, Long> map = str.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting()));
		String res = map.entrySet().stream().filter(ch->ch.getValue()>1).map(Map.Entry::getKey).findFirst().map(String::valueOf).orElse(null);
		System.out.println(res);
	}
	
	private static void findRepeatingNumbers(int[] arr) {
		int n= arr.length;
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			int idx = Math.abs(arr[i])-1;
			if(arr[idx]<0) {
				list.add(idx+1);
			} else {
				arr[idx] = -1*arr[idx];
			}
		}
	
		for(int val:list) {
			System.out.print(val+" ");
		}
	}
	
	public static String findLongestSubString() {
		String str ="pwwkew";
		int n = str.length();
		HashMap<Character,Integer> freqMap = new HashMap<>();
		int s=0,e=0,maxLen=Integer.MIN_VALUE,startIdx=0;
		for(int i=0;i<n;i++) {
			e=i;
			char ch=str.charAt(i);
			freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
			while(freqMap.get(ch)>1) {
				char startChar = str.charAt(s);
				freqMap.put(startChar, freqMap.get(startChar)-1);
				if(freqMap.get(ch)==0) {
					freqMap.remove(startChar);
				}
				s++;
			}
			if(i-s+1>maxLen) {
				maxLen = i-s+1;
				startIdx=s;
			}
			
		}
		System.out.println("max length is : "+maxLen);
		return str.substring(startIdx,startIdx+maxLen);
	}
}
