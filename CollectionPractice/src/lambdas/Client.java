package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Client {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
//		int x=sc.nextInt();
//		int y=sc.nextInt();
//		
//		Logic obj=new Logic();
//		
//		Add ans2 = (a,b)-> a*b;
//		Runnable r= ()-> System.out.println("This is Runnable .");
//		System.out.println("ans : "+obj.add(x, y));
//		System.out.println("ans 2 : "+ans2.add(x, y));
//		r.run();
		List<Student> stu = new ArrayList<>();
		stu.add(new Student("krish", 26, 99.0));
		stu.add(new Student("chid", 25, 90.0));
		stu.add(new Student("raj", 22, 97.0));
		
		Comparator<Student> comparator = (a,b) ->
		{
			if(a.name.equalsIgnoreCase(b.name)) {
				return 0;
			} else if(a.name.compareTo(b.name) >0) {
				return 1;
			} else {
				return -1;
			}
		};
		
		Collections.sort(stu, comparator);
		
		for(Student num : stu) {
			System.out.println("name : "+num.name+" age : "+num.age+" psp : "+num.psp);
		}
		
		
		

		
		
		
	}
}
