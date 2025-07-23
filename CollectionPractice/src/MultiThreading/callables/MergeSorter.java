package MultiThreading.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
	
	private List<Integer> ls;
	private ExecutorService es;
	public MergeSorter(List<Integer> ls,ExecutorService es) {
		this.ls = ls;
		this.es = es;
	}

	@Override
	public List<Integer> call() throws Exception {
		if(ls.size()<=1) {
			return ls;
		}
		int mid = ls.size()/2;
		List<Integer> leftListToSort = new ArrayList<>();
		List<Integer> rightListToSort = new ArrayList<>();
		
		for(int i=0;i<mid;i++) {
			leftListToSort.add(ls.get(i));
		}
		for(int i=mid;i<ls.size();i++) {
			rightListToSort.add(ls.get(i));
		}
		MergeSorter leftSorter = new MergeSorter(leftListToSort, es);
		MergeSorter rightSorter = new MergeSorter(rightListToSort, es);
		Future<List<Integer>> leftSortedFutureList= es.submit(leftSorter);
		Future<List<Integer>> rightSortedFutureList= es.submit(rightSorter);
		List<Integer> leftSortedList = leftSortedFutureList.get();
		List<Integer> rightSortedList = rightSortedFutureList.get();
		//merging 
		int i=0,j=0;
		List<Integer> sortedArray = new ArrayList<>();
		while(i<leftSortedList.size() && j<rightSortedList.size()) {
			if(leftSortedList.get(i) < rightSortedList.get(j)) {
				sortedArray.add(leftSortedList.get(i));
				i++;
			} else {
				sortedArray.add(rightSortedList.get(j));
				j++;
			}
		}
		while(i<leftSortedList.size()) {
			sortedArray.add(leftSortedList.get(i));
			i++;
		}
		while(j<rightSortedList.size()) {
			sortedArray.add(rightSortedList.get(j));
			j++;
		}
		return sortedArray;
	}

}
