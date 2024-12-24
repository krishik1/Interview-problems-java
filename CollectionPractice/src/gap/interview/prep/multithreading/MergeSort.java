package gap.interview.prep.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSort implements Callable<List<Integer>>{
	
	List<Integer> list;
	ExecutorService es;

	public MergeSort(List<Integer> list, ExecutorService es) {
		super();
		this.list = list;
		this.es = es;
	}



	@Override
	public List<Integer> call() throws Exception {
		if(list.size()<=1) {
			return list;
		}
		
		int mid = list.size()/2;
		List<Integer> left = new ArrayList<>(list.subList(0, mid));
        List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));
		MergeSort leftSorted = new MergeSort(left,es);
		MergeSort rightSorted = new MergeSort(right,es);
		Future<List<Integer>> futureLeftSorted = es.submit(leftSorted);
		Future<List<Integer>> rightRightSorted = es.submit(rightSorted);
		List<Integer> resLeftList = futureLeftSorted.get();
		List<Integer> resRightList = rightRightSorted.get();
		int i=0,j=0;
		List<Integer> res = new ArrayList<>();
		while(i<resLeftList.size() && j<resRightList.size()) {
			if(resLeftList.get(i)>resRightList.get(j)) {
				res.add(resRightList.get(j));
				j++;
			} else {
				res.add(resLeftList.get(i));
				i++;
			}
		}
		
		while(i<resLeftList.size()) {
			res.add(resLeftList.get(i));
			i++;
		}
		while(j<resRightList.size()) {
			res.add(resRightList.get(j));
			j++;
		}
		
		return res;
	}
	

}
