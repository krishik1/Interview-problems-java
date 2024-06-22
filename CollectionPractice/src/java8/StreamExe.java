package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.security.auth.Subject;

/**
 * Stream : Major difference between streams and collections is :
 * Collection is a physical holding of elements where as Streams represent the data.
 * 1.we can create stream by using either by calling stream() default method introduced in all 
 * the collections to support streams or with the help ofStream.of()
 * 2.Processing the elements inside streams parallelly is very simple.we just
 * need to call parallelStream( default method instead of stream.
 * 3.Stream Operations dont mutate their source.Instead they return new streams that hold the result.
 *    **/
/**Inside java.util.Arrays new static methods were added to convert an array in to a stream,
 * 1.arrays.stram(array) - To create stream of an array.
 * 2.Arrays.stream(array,from,to) - To create a stream from a part of an array.
 * To create Infinate stream of elements which is suitable for stream of random elements, stream has 
 * 2 static methods called Strem.generate() & Stream.iterate().
 * **/
/**Map Method in Stream Api:
 * if we have  Scenario where we need to apply business logic or transform each element inside a collection, we use map()
 * method inside stream to process.
 * 2.Stream map is an intermediate operation and i returns ne streams as return value.these operations are always lazy.
 * 3.Stream operations dont mutate their source. instead, they return new streams that hold the result.
 * **/

public class StreamExe {

	
	public static void main(String[] args) {
		List<String> deptList = new ArrayList<>();
		deptList.add("CSE");
		deptList.add("EEE");
		deptList.add("CIVIL");
		deptList.add("MECH");
		Stream<String> depStream = deptList.stream();
		//depStream.forEach(i -> System.out.println(i));
//		depStream.forEach(System.out :: println);
//		
//		Stream<String> subStream = Stream.of("Krishik","Jaga","Adi","Santosh","Chidvi");
//		subStream.forEach(System.out :: println);
//		
//		Stream<String> paralleltream = deptList.parallelStream();
//		paralleltream.forEach(System.out :: println);
		
		/**
		mapInStreams();
		flatMapsInStreams();
		filterInstreams();
		mixIntermediateOperation();
		traverseOnceInStreams();
		reduceInStreams();
		collectStreams();
		collectingAndThen();
		streamPipeline();
		parallelStreams();**/
		missinfEle();
	
	}
	//int x;
	private static int missinfEle() {
		//int n =9;
		int[] array = {1,2,3,5};
		int n =5;
		int x;
	//	int res;
        for(int i=0;i<n-1;i++){
//           xor1= xor1^array[i];
//           System.out.println("xor 1 is:"+xor1);
//           xor2=xor2^(i+1);
//           System.out.println("xor 2 is:"+xor2);
        	 int res = array[i]^(i+1);
        	 if(res == 1) {
        		 System.out.println(i+1);
        	 }
        	 System.out.println("result is :"+res);
        }
       // res= xor1^xor2;
        
        return 0;
		 
	}
	/**
	 *parallelStream(): stream interface allows you to process its elements n parallel in a convenient way:its possible to a collection
	 *in parallel stream  by invoking the method parallelStream() on the collection source.
	 *A parallel stream is a stream that splits its elements in to multiple chunks with a different thread.Thus, you can automatically
	 * partition the work load of given operation on all the  cores of your multicore processor and keep all of them equally busy.
	 * if we want to convert a sequential stream in to prallel one, just call the method parallel() on the stream.**/
	private static void parallelStreams() {
		List<String> deptList = new ArrayList<>();
		deptList.add("CSE");
		deptList.add("EEE");
		deptList.add("CIVIL");
		deptList.add("MECH");
		deptList.add("ECE");
        deptList.add("CHEMICAL");
        deptList.add("IT");
        deptList.parallelStream().forEach(System.out::println);
	}
	/**
	Stream Pipeline : input ---->filter---->map---->sort---->collect---->output
     *we form a chain of stream operation using filter,map and sort are some of intermediate operations and collect is the terminal operation.
	**/
	private static void streamPipeline() {
		List<Integer> numList = new ArrayList<>();
		numList.add(2);
		numList.add(9);
		numList.add(7);
		numList.add(6);
		numList.add(3);
		numList.add(8);
		List<Integer> printList= numList.stream().filter(i -> i%2 == 0).map(i -> i * i).sorted().collect(Collectors.toList());
		printList.forEach(System.out::println);
	}
	/**CollectingAndThen:
	 * This method will be used in the scenarios where the stream lements need to b collected and then collected 
	 * object needs to be transformed using a given rule/fuvtion.Using this method collector both these tasks of collection and transformation
	 * can be specified and executed together.
	 * 2.it accepts 2 prameters:
	 * 1. 1st input parameter is downstream which is an instance of a collector.in other words ,any collector can be used here.
	 * 2.2nd input is a finisher which needs to be an instance of a functional interface. **/
	/** groupingBy:
	 * The groupingBy method of collectors class in java are used for grouping objects by same property and storing results
	 * in a map instance.This method provides a similar functionality to sql GROUP BY clause.in order to use it, we always need
	 * to specify a property by which the grouping would be performed.**/
	/**partitionBy() :
	 *1. collectors partitionBy is used to partition a stream of objects based on a given predicate.The fact that that partition function 
	 * returns a boolean means the resulting grouping map will have a boolean as a key type, and therefore there can be at most 2 different groups
	 * - one for true and one for false.
	 * 2.Compared to filters , partitioning has the advantage keeping both the lists of the stream elements, for which the application of 
	 * the partitioning function returns true or false.**/
	
	private static void collectingAndThen() {

		List<Product> productList = Arrays.asList(new Product("Apple", 1200),new Product("Samsung", 1000),new Product("Nokia", 800),
				new Product("Blackberry", 1500),new Product("OnePlus", 1000));
		String maxPriceProduct = productList.stream().collect(Collectors.collectingAndThen(Collectors.maxBy
				(Comparator.comparing(Product::getPprice)), (Optional<Product> product) -> product.isPresent() ? product.get().pname:"Null"));
		System.out.println("The Product is :"+maxPriceProduct);
		//GroupingBy
		Map<Integer,List<Product>> groupByMap = productList.stream().collect(Collectors.groupingBy(Product::getPprice));
		System.out.println("The List of Product by price : "+groupByMap);
		Map<Boolean, List<Product>> partitionMap = productList.stream().collect(Collectors.partitioningBy(in -> in.getPprice()>1000));
		System.out.println("The List of Partition Product by price : "+partitionMap);
	}
	/**Collect method:
	 * stream.collect() allows us to repackaging elements to some data structures and applying some additional logic etc. on data elements held
	 * on Stream interface.
	 * Some important methods inside collector class are :
	 * 1.toList() - convert stream to List.
	 * 2.toSet() - convert stream to set.
	 * 3.toCollection() - convert stream into collection.
	 * 4.toMap() - convert stream into map after applying key/value determination function.
	 * 5.Counting - Counting no of stream elements.
	 * 6.joining() - For concatination of stream elements in to a single stream.
	 * 7.minBy() - To find minimum of all stream elements based on given comparator.
	 * 8.maxBy() - To find maximum of all stream elements based on given comparator.
	 * 9.reducing - Reducing elements of stream based on Binary operator function provided. as same as reduce.**/
	private static void collectStreams() {
		List<String> deptList = new ArrayList<>();
		deptList.add("CSE");
		deptList.add("EEE");
		deptList.add("CIVIL");
		deptList.add("MECH");
		deptList.add("ECE");
        Stream<String> streamList = deptList.stream();
//        List<String> colList = streamList.filter(word -> word.startsWith("E")).collect(Collectors.toList());
        List<String> colList = streamList.filter(word -> word.startsWith("E")).collect(Collectors.toCollection(ArrayList::new));
        colList.forEach(System.out :: println);
		
	}
	/**Reduce:The operation which will combine all the elements in stream repeatedly to produce a single value such as integer.
	 * These queries can be classified as reduction operation(Stream is reduced to value).it is a terminal operation.
	 * 2.this method accepts two parameters .one is initial value of the sum variable such as 0 and second one is operation that we going
	 * perform.
	 * There is also a overloaded version of reduce that dont take an initial value, but it returns an optional object considering empty
	 * streams scenario.**/
	private static void reduceInStreams() {
		System.out.println(Stream.iterate(0, n -> n+1).limit(10).reduce(0,(a,b) -> (a+b)));
		
	}
	/**Streams are traversable only once as same as iterators.After that a stream is said to consumed.once the termmminal operation is
	 * called we can traverse again.
	 * you can get a new stream from the initial data source to traverse it again as you would for an iterator 
	 * assuming its a repeatable source like collection but not an i/o channel. 
	 * **/
	private static void traverseOnceInStreams() {
		try {
		List<String> deptList = new ArrayList<>();
		deptList.add("CSE");
		deptList.add("EEE");
		deptList.add("CIVIL");
		deptList.add("MECH");
		deptList.add("ECE");
        Stream<String> streamList = deptList.stream();
        streamList.forEach(System.out::println);
        streamList.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Limit : 1.if we have a scenario  where we need to limit the no of elements inside a stream,we can use limit(n)
	 * function inside streams.
	 * 2.note: limit always works on unordered streams (for examaple: if the source is a set).in this case we shouldnt assume any order
	 * on the result produced by limit. if we are recievinng 1000 elements from backend and we need to process only first 100 numbers 
	 * the  this used to process first 100 elemwents. **/
	/**Skip : 1.Streams support the skip(n) method to return a stream that discareds first n elements.if the stream has lesser than
	 * n elements, an empty stream is returned. limit and skip are complementry.
	 * distinct: this operation is used to remove duplicates iside the collection.for ordered streams, the selection of distinct elements 
	 * is stable,but for unordered streams , no stability gaurantees are made.
	 * sorted: it will sort te given stream.
	 * peek : Returns a stream consisting f the elements of this stream,additionally performing the provided action on each
	 * elements are consumed from the resulting stream.**/
	private static void mixIntermediateOperation() {
		//limit
		//Stream.generate(new Random() :: nextInt).limit(10).forEach(System.out::println);
		int[] array = {20,27,89,84,66,45,21,16,21,84};
		IntStream arr = Arrays.stream(array);
		//arr.distinct().forEach(System.out :: println);
		arr.sorted().forEach(System.out :: println);
		//skip
		Stream.iterate(1, n ->n+1).skip(4).limit(10).peek(i -> System.out.println("peek is :"+i)).forEach(System.out :: println);
	}
	/**
	 * Filter :1. if we have scenario to exclude certain elements inside a collection based on a condition, we can use 
	 * filter() method inside streams to process them.
	 * Stream filter methods takes predicate as argument that is a functuonal inreface which can acts as a boolean to filter the 
	 * elements based on condition defined.it is an intermediate operation and it returns  a new stream as a return value.**/
	
	private static void filterInstreams() {
		int[] array = {20,27,89,84,66,45,21,16};
		IntStream num = Arrays.stream(array);
		num.filter(i -> i%2 != 0).forEach(System.out::println);
		
	}
	/**
	 * FlatMap:: Sometimes based on the input elements we may ended up with multiple streams post map method and if 
	 * we try to collet them we will get a list of strweams instead of a single stream.
	 * 2.For such cases we can use flat map. it is a combination of map and a flat operation i.e., it applies a function to elements as well as 
	 * flatten them.**/
	private static void flatMapsInStreams() {
		String[] arr = {"Jagadeesh","Krish","Adi"};
		Stream<String> nameList = Arrays.stream(arr);
		nameList.map(word -> word.split("")).flatMap(Arrays :: stream).forEach(System.out::println);
				
	}
	public static void mapInStreams() {
		List<String> deptList = new ArrayList<>();
		String[] arr = {"Jaga","Krish","Adi","Santosh","Chid"};
		deptList.add("CSE");
		deptList.add("EEE");
		deptList.add("CIVIL");
		deptList.add("MECH");
		deptList.add("ECE");
        deptList.stream().map(i ->i.toUpperCase()).forEach(System.out :: println);
        Arrays.stream(arr,0,2).forEach(System.out::println);
        
	}
	
}
