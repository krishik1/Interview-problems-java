package tech.mahinda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeListReadOnly {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		List<Integer> readOnlyList = Collections.unmodifiableList(list);
		list.add(40);
		readOnlyList.forEach(System.out::println);
		System.out.println("List is : ");
		list.forEach(System.out::println);
	}

}
