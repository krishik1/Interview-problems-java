package java8;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**java.util.function.Consumer<T>:
 * 1.As name indicates consumer interface will always consumes/accept the given input forr processing but not return
 * anything to invocation method.it has only one parameter as it doenot contain any return type.
 * 2.SAM-void accept(T t);
 * one default method for performing chaining i.e andThen().
 * 3.NO static methods are available. 
 * **/
public class ConsumerEce {
	
//	public static void main(String[] args) {
//		Consumer<String> convertAndDisplay = i -> System.out.println("Converted Value is:"+i.toUpperCase());
//		convertAndDisplay.accept("Jagadeesh");
//		Consumer<String> appendinput = i -> System.out.println("New Value For Appending Is : "+"HELLO "+i.toUpperCase());
//		appendinput.andThen(convertAndDisplay).accept("java 8");
//		//convertAndDisplay.andThen(appendinput).accept("java8");
//	}
	/**java.util.function.supplier<T>:
	 * 1.Supplier interface will always return a value with out accepting any input.
	 * 2.T get();->Sing Abstract method
	 * 3.No static and chaining methods available in functional interface.
	 * 
	 **/
	public static void main(String[] args) {
		Supplier<Integer> currDateOfMonth = () ->LocalDate.now().getDayOfMonth();
		System.out.println("Day Of month : "+currDateOfMonth.get());
		Supplier<String> CurrDayOfWeek = () -> LocalDate.now().getDayOfWeek().name();
		System.out.println("Day Of week : "+CurrDayOfWeek.get());
	}

}             
