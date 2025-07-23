package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Enhancementexe {

	/**
	 * Java 8 team provides several default methods inside Map interface. Below are the few important enhancements happened for map.
	 * 1.forEach() - Using this we can iterate the map values easily.
	 * 2.Entry.comparingByValue() - Sorting the map elements based on value.
	 * 3.Entry.comparingByKey() - Sorting the map elements based on key.
	 * 4.getOrDefault() - Can be used to pass a default value instead of null if key is not present.
	 * 5.computeIfAbsent() - Can be used to calculate a value if there is no key given.
	 * 6.computeIfPresent() - if the specified key is present, calculate a new value for it.
	 * 7.Compute() - Calculates a new value for the given key and stores it in Map.
	 * 8.remove(key,value) - To remove a map element if both key and value matches.
	 * 9.replace() - For replacement of value if the key is present.
	 * 10.replaceAll() - For replacement of all the values inside the map.**/
	public static void main(String[] args) {
		Map<String, String> cityMap = new HashMap<>();
		cityMap.put("India", "Vizag");
		cityMap.put("USA", "Washington");
		cityMap.put("Japan", "Tokyo");
		cityMap.put("China", "Beijing");
		cityMap.put("Australia", "Canbera");
		cityMap.put("Germany", "Berlin");
		
		cityMap.forEach((Country,Capital) -> System.out.println("The Capital of "+ Country + "Is : "+Capital));
		cityMap.entrySet().stream().sorted(Entry.comparingByValue()).forEachOrdered(System.out::println);
//		cityMap.entrySet().stream().sorted(Entry.comparingByKey()).forEachOrdered(System.out::println);
		System.out.println("Map is :");
		cityMap.entrySet().stream().sorted(Entry.comparingByKey()).forEach(System.out::println);
		cityMap.computeIfAbsent("Spain", name ->"Mardid");
		cityMap.computeIfPresent("USA", (k,v) -> "Washington Dc");
		cityMap.compute("India", (k,v) -> "New Delhi");
		cityMap.remove("China","Beijing");
		cityMap.replace("India", "Delhi");
		cityMap.replaceAll((k,v) -> v.toUpperCase());
		cityMap.entrySet().stream().sorted(Entry.comparingByKey()).forEach(System.out::println);
	}
}
