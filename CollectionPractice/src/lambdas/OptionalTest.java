package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalTest {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>(Arrays.asList("raju", "jaga", "chid", null, null));
//		List<Optional<String>> optList = list.stream().map(Optional::ofNullable).collect(Collectors.toList());
//		optList.forEach(val -> {
//			val.map(String::toUpperCase).ifPresent(System.out::println);
//			if (!val.isPresent()) {
//				System.out.println("value is absent");
//			}
//		}
//
//		);
		
		List<Optional<String>> listOptional = list.stream().map(Optional::ofNullable).collect(Collectors.toList());
		
		listOptional.forEach( val -> {val.map(String::toUpperCase).ifPresent(System.out::println);
		if(!val.isPresent()) {
			System.out.println("value is absent");
		}
		});
		
//		listOptional.forEach(val -> val.map(String::toUpperCase).ifPresentOrElse(
//			    System.out::println,
//			    () -> System.out.println("value is absent")
//			));
		
		
	}

}
