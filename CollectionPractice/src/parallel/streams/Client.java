package parallel.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Client {

	public static void main(String[] args) {
		
		//System.out.println(Runtime.getRuntime().availableProcessors());
//		long st = System.currentTimeMillis();
//		getStudents().stream().filter(std -> std.getAge()>20).forEach(System.out::println);
//		long et = System.currentTimeMillis();
//		System.out.println("Time taken by sequential stream : "+(et-st));
//		
//		long st1 = System.currentTimeMillis();
		
		/**
		getStudents().stream().parallel()
        .filter(std -> {
            System.out.println("student : " + std.getName() + " current processing thread : " + Thread.currentThread().getName());
            return std.getAge() > 20;
        })
        .map(std -> {
            System.out.println("student : " + std + " current processing thread : " + Thread.currentThread().getName());
            return std.getId();
        })
        .forEach(System.out::println);**/
		/**
		List<Integer> nums = new ArrayList<>();
		nums.addAll(List.of(1,2,3,4,5,6,7,8,9));
		
		Stream<Integer> numsStream = nums.stream().parallel().map(x->x*x).filter(val-> val>10);
		numsStream.sorted().forEachOrdered(System.out::println);
		//System.out.println(numsStream.isParallel());
		**/
		
		Stream.iterate(1, i->i<=9, i->i+1).forEach(System.out::println);
		
		
//		long et1 = System.currentTimeMillis();
//		System.out.println("Time taken by parallel stream : "+(et1-st1));
	}

	private static List<Student> getStudents() {

		List<Student> students = new ArrayList<>();

		students.add(new Student(1, "John Doe", "1234567890", 20));
		students.add(new Student(2, "Jane Smith", "0987654321", 22));
		students.add(new Student(3, "Bob Johnson", "1112223333", 21));
		students.add(new Student(4, "Alice Williams", "4445556666", 19));
		students.add(new Student(5, "Tom Brown", "7778889999", 23));
		students.add(new Student(6, "Lisa Taylor", "0001112222", 20));
		students.add(new Student(7, "James Wilson", "3334445555", 22));
		students.add(new Student(8, "Laura Moore", "6667778888", 21));
		students.add(new Student(9, "David Lee", "9990001111", 23));
		students.add(new Student(10, "Megan White", "2223334444", 19));
		students.add(new Student(11, "Steve Harris", "5556667777", 20));
		students.add(new Student(12, "Karen Clark", "8889990000", 22));
		students.add(new Student(13, "Mark Walker", "1112223334", 21));
		students.add(new Student(14, "Susan Hall", "4445556667", 19));
		students.add(new Student(15, "Chris Allen", "7778889991", 23));
		return students;

	}

}
