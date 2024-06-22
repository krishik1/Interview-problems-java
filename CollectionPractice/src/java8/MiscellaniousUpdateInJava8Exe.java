package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Spliterator;

/**
 * Java 8 team made the most  out of the default methods introduced and added several new methods in collection interfaces
 * and other classes.Below is the snapshot of the same,
 * List -> replaceAll(),sort().
 * Iterator - foreachRemaining().
 * Iterable - forEach(),spliterator().
 * Collection - parallelStream(),stream(),removeIf().
 * Comparator - reversed(),thenComparing(),naturalOrder(),reverseOrder(),nulksFirst(),nullsLast().
 * Arrays - setAll(),parallelSetAll(),parallelSort(),parallelPrefix().
 * String - join().
 * Math - [add],[subtract],[multiply],[increment],[decrement],[negate],Exact,toIntExact,floorMod,floorDiv and nextDown.
 * Number - sum,min,max static methods in Short,Integer,Long,Float and Double etc.
 * Boolean - logicalAnd(),logicalOr(),logicalXor().
 * Objects - isNull(),nonNull().
 * 
 * **/
public class MiscellaniousUpdateInJava8Exe {
	public static void main(String[] args) {
		/**listReplaceAll();
		listSort();
		spliterator();
		forEach();
		forEachRemaining();
		mapEnhancements();
		stringJoin();
		arrayMethods();
		numberMethods();**/
		mathMethods();
		objectsNullChecks();
		booleanMethods();
	}

	private static void booleanMethods() {
		Boolean checkAnd = Boolean.logicalAnd(10>5 , "Eazy".equals("Eazy"));
		Boolean checkOr = Boolean.logicalOr(10< 5, "Eazy".equals("Eazy Bytes"));
		Boolean checkXor = Boolean.logicalXor(true, true);
		System.out.println(checkAnd);
		System.out.println(checkOr);
		System.out.println(checkXor);
		
	}

	private static void objectsNullChecks() {
		List<String> departmentList = new ArrayList<>();
		departmentList.add("CSE");
		departmentList.add("EEE");
		departmentList.add("ECE");
		departmentList.add("MECH");
		departmentList.add("CIVIL");
		departmentList.add("IT");
		departmentList.add(null);
		Long nullCount = departmentList.stream().filter(Objects :: isNull).count();
		Long notNullCount = departmentList.stream().filter(Objects :: nonNull).count();
		System.out.println(nullCount);
		System.out.println(notNullCount);
		
	}

	private static void mathMethods() {
		long sum = Math.addExact(12345, 75424);
		long inc = Math.incrementExact(45456);
		long neg = Math.negateExact(1234);
		int toInt =Math.toIntExact(1234);
		int floorDiv = Math.floorDiv(45654, 1233);
		int floorMod = Math.floorMod(45654, 1233);
		float nextDown = Math.nextDown(12);
		float nextAfter = Math.nextAfter(12, 16);
		System.out.println(sum);
		System.out.println(inc);
		System.out.println(neg);
		System.out.println(toInt);
		System.out.println(floorDiv);
		System.out.println(floorMod);
		System.out.println(nextDown);
		System.out.println(nextAfter);
	}

	private static void numberMethods() {
		int sum = Integer.sum(666, 333);
		int max = Integer.min(342, 324);
		int min = Integer.max(543, 435);
		System.out.println(min);
		System.out.println(max);
		System.out.println(sum);
	}

	private static void arrayMethods() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		/**Arrays.setAll() will update all th elements in the array based on lambda expression provided.**/
		Arrays.setAll(arr, (i -> {return arr[i] = arr[i]*2;}));
		System.out.println("New Array :"+Arrays.toString(arr));
		int[] unsortedArr = {3,9,2,4,7,5};
		Arrays.parallelSort(unsortedArr);
		System.out.println("Sorted list is :"+ Arrays.toString(unsortedArr));
		Arrays.parallelPrefix(unsortedArr, (first,second) ->{
		return first+second;
		});
		System.out.println(Arrays.toString(unsortedArr));
	}

	private static void stringJoin() {
		String departments = String.join("-", "CSE","ECE","EEE","MECH");
		System.out.println("Depatments : "+departments);
	}

	private static void mapEnhancements() {
		Map<String, String> cityMap = new HashMap<>();
		cityMap.put("India", "Vizag");
		cityMap.put("USA", "Washington");
		cityMap.put("Japan", "Tokyo");
		cityMap.put("China", "Beijing");
		cityMap.put("Australia", "Canbera");
		cityMap.put("Germany", "Berlin");
		cityMap.entrySet().stream().sorted(Entry.comparingByKey()).forEachOrdered(System.out::println);
		cityMap.entrySet().stream().sorted(Entry.comparingByValue()).forEachOrdered(System.out::println);
		
	}

	/**Note : forEach() and forEachRemaining() functionality is same and the difference is forEach() is present is iterable interface 
	 * so it is iterable specific traversal of elements and forEachRemaining is iterator inferface so it is iterator specific traversal of elements.**/
	private static void forEachRemaining() {
		List<String> departmentList = new ArrayList<>();
		departmentList.add("CSE");
		departmentList.add("EEE");
		departmentList.add("ECE");
		departmentList.add("MECH");
		departmentList.add("CIVIL");
		departmentList.add("IT");
		System.out.println("For Each Remaining:");
		departmentList.iterator().forEachRemaining(System.out::println);
	}

	private static void forEach() {
		List<String> departmentList = new ArrayList<>();
		departmentList.add("CSE");
		departmentList.add("EEE");
		departmentList.add("ECE");
		departmentList.add("MECH");
		departmentList.add("CIVIL");
		departmentList.add("IT");
		System.out.println("For Each:");
		departmentList.forEach(System.out::println);
	}

	private static void spliterator() {
		List<String> departmentList = new ArrayList<>();
		departmentList.add("CSE");
		departmentList.add("EEE");
		departmentList.add("ECE");
		departmentList.add("MECH");
		departmentList.add("CIVIL");
		departmentList.add("IT");
		ArrayList<String> list = new ArrayList<>();
		Spliterator<String> splitr = departmentList.spliterator();
		//while(splitr.tryAdvance(System.out::println));
		while(splitr.tryAdvance((i) -> list.add(i.toLowerCase())));
		Spliterator<String> splitr1 = list.spliterator();
		while(splitr1.tryAdvance(System.out::println));
		
	}

	private static void listSort() {
		List<String> departmentList = new ArrayList<>();
		departmentList.add("CSE");
		departmentList.add("EEE");
		departmentList.add("ECE");
		departmentList.add("MECH");
		departmentList.add("CIVIL");
		departmentList.add("IT");
		System.out.println("Before Sort :"+departmentList);
		departmentList.sort(Comparator.naturalOrder());
		System.out.println("After Sort :"+departmentList);
	}

	private static void listReplaceAll() {
		List<String> departmentList = new ArrayList<>();
		departmentList.add("CSE");
		departmentList.add("EEE");
		departmentList.add("ECE");
		departmentList.add("MECH");
		departmentList.add("CIVIL");
		departmentList.add("IT");
		System.out.println("Before replaceAll operation:"+departmentList);
		departmentList.replaceAll(i -> i.toLowerCase());
		departmentList.forEach(System.out::println);
		
	}

}
