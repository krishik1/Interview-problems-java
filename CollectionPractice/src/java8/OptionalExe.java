package java8;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalExe {
     public static void optionalMethod() {
    	 String[] str=new String[10];
    	 str[5]="Eazy Bytes";
    	 //Optional.empty()
    	 Optional<String> empty=Optional.empty();
    	 System.out.println(empty);
    	 //Optional.of()
    	 Optional<String> value = Optional.of(str[5]);
    	 System.out.println(value);
    	 //.get
    	 System.out.println(value.get());
    	 
    	 //Optional.ofNullable()
    	 Optional<String> nullValue=Optional.ofNullable(str[4]);
    	 //ifPresent()
    	 nullValue.ifPresent(System.out::println);
    	 //.orElse()
    	 System.out.println(nullValue.orElse("No Value"));
    	 Optional<String> val=Optional.of("Eazy Bytes");
    	 Optional<String> emptyVal=Optional.empty();
    	 System.out.println(val.map(String::toUpperCase));
    	 System.out.println(emptyVal.map(String::toUpperCase));
    	 Optional<Optional<String>> val1=Optional.of(Optional.of("EazyBytes"));
    	 System.out.println("Optional Value :"+val1.map(i->i.map(String::toLowerCase)));
    	 System.out.println("Optional Value :"+val1.flatMap(i->i.map(String::toLowerCase)));
    	 
    	 Optional<String> country=Optional.of("India");
    	 Optional<String> emptyCountry=Optional.empty();
    	 
    	 //filter on optional
    	 System.out.println(country.filter(i->i.equals("india")));
    	 System.out.println(country.filter(i->i.equalsIgnoreCase("india")));
    	 System.out.println(emptyCountry.filter(i->i.equalsIgnoreCase("india")));
    	 if(country.isPresent()) {
    		 System.out.println("Value Available");
    	 }

    	 country.ifPresent(c->System.out.println("Country Is:"+c));
    	 emptyCountry.ifPresent(c->System.out.println("Country Is:"+c));
    	 System.out.println(emptyCountry.orElse("No Country data Is available."));
    	 System.out.println(emptyCountry.orElseGet(()->"No Country Is Available"));
    	 System.out.println(emptyCountry.orElseThrow(NoSuchElementException::new));
    	 
     }
     
     public static void main(String[] args) {
    	 optionalMethod();
     }
}
