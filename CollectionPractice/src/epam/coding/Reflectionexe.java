package epam.coding;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflectionexe {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = Maths.class.getDeclaredMethod("write");
		method.setAccessible(true);
		method.invoke(new Maths());
		System.out.println("------------------------------------");
		Method sumMethod = Maths.class.getDeclaredMethod("summation", new Class[] {Integer.TYPE,Integer.TYPE});
		sumMethod.setAccessible(true);
		System.out.println("The sum of 2 Numbers : "+sumMethod.invoke(new Maths(), new Integer[] {10,30}));
	}

}
