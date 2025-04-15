package parallel.streams;

import java.util.stream.LongStream;

public class ThreadSafetyInPaallelStreams {
	public static void main(String[] args) {
		/**List<Integer> list = Collections.synchronizedList(new ArrayList<>());
		
		for(int i=0;i<5;i++) {
			list.clear();
			Stream.iterate(0, n->n<20, n->n+1).parallel().forEachOrdered(no->list.add(no));
			System.out.println(list);
			System.out.println(list.size());
		}**/
		
		/**long sum = LongStream.rangeClosed(0, 10).parallel().sum();
		System.out.println(sum);
		
		long sum1 = LongStream.rangeClosed(0, 10).sequential().sum();
		System.out.println(sum1);**/
		
		long sum = LongStream.rangeClosed(0, 10).parallel().reduce(0,Long::sum);
		System.out.println(sum);
		
	}

}
