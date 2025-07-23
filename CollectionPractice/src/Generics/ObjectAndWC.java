package Generics;

import java.util.ArrayList;

public class ObjectAndWC {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(40);
		addEle(list);
		System.out.println("ans :"+list.get(0));
	}
	
	public static void addEle(ArrayList<?> list) {
		for (Object element : list) {
	        System.out.println(element);
	    }
	}
	
	/** This wont work because of Type casting issues.**/
	public static void addEleObj(ArrayList<Object> list, Object element) {
		list.add(element);
	}
}
