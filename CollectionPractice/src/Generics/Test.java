package Generics;

//public class Test<T extends Number> {--->with class
public class Test<T extends Runnable> {//--->with interface
	public static void main(String[] args) {
//		Test<Integer> t1=new Test<>();
//		Test<String> t2=new Test<>();
		
		Test<Thread> t1=new Test<>();
		Test<Runnable> t2=new Test<>();
		//Test<String> t3=new Test<>();
		
	}
	
}
