package MultiThreadingANDSynchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
	private List<Integer> arrayToSort;
	private ExecutorService ex;

	public Sorter(List<Integer> arrayToSort, ExecutorService es) {
		this.arrayToSort = arrayToSort;
		ex = es;
	}

	@Override
	public List<Integer> call() throws Exception {
		if (arrayToSort.size() <= 1) {
			return arrayToSort;
		}
		int mid = arrayToSort.size() / 2;
		List<Integer> leftListToSort = new ArrayList<>();
		
		for (int i = 0; i <mid; i++) {
			leftListToSort.add(arrayToSort.get(i));
		}
		List<Integer> rightListToSort = new ArrayList<>();
		for (int i = mid; i < arrayToSort.size(); i++) {
			rightListToSort.add(arrayToSort.get(i));
		}
		Sorter leftSorterList = new Sorter(leftListToSort, ex);
		Sorter rightSorterList = new Sorter(rightListToSort, ex);
		

		Future<List<Integer>> futureleftList = ex.submit(leftSorterList);
		Future<List<Integer>> futurerightList = ex.submit(rightSorterList);
		
		List<Integer> finalList = new ArrayList<>();
		int i = 0, j = 0;
		
		List<Integer> leftSortedList = futureleftList.get();
		List<Integer> rightSortedList = futurerightList.get();

		while (i < leftSortedList.size() && j < rightSortedList.size()) {
			if(leftSortedList.get(i)<=rightSortedList.get(j)) {
				finalList.add(leftSortedList.get(i));
				i++;
			} else {
				finalList.add(rightSortedList.get(j));
				j++;
			}
		}
		while (i < leftSortedList.size()) {
			finalList.add(leftSortedList.get(i));
			i++;
		}

		while (j < rightSortedList.size()) {
			finalList.add(rightSortedList.get(j));
			j++;
		}
		return finalList;
	}

}
