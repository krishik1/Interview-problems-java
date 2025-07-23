package completable.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
	List<Integer> list;
	ExecutorService es;
	

	public MergeSorter(List<Integer> list, ExecutorService es) {
		this.list = list;
		this.es = es;
	}


	@Override
	public List<Integer> call() throws Exception {
		if(list.size()<=1) {
			return list;
		}
		int mid = list.size()/2;
		List<Integer> ls = new ArrayList<>();
		List<Integer> rs = new ArrayList<>();
		for(int i=0;i<mid;i++) {
			ls.add(list.get(i));
		}
		for(int i=mid;i<list.size();i++) {
			rs.add(list.get(i));
		}
		MergeSorter leftSorter = new MergeSorter(ls, es);
		MergeSorter rightSorter = new MergeSorter(rs, es);
		Future<List<Integer>> futureLeftList = es.submit(leftSorter);
		Future<List<Integer>> futureRightList = es.submit(rightSorter);
		List<Integer> leftSortedList = futureLeftList.get();
		List<Integer> rightSortedList = futureRightList.get();
		int i=0,j=0;
		List<Integer> resList = new ArrayList<>();
		while(i<leftSortedList.size() && j<rightSortedList.size()) {
			if(leftSortedList.get(i)<rightSortedList.get(j)) {
				resList.add(leftSortedList.get(i));
				i++;
			} else {
				resList.add(rightSortedList.get(j));
				j++;
			}
		}
		while(i<leftSortedList.size()) {
			resList.add(leftSortedList.get(i));
			i++;
		}
		while(j<rightSortedList.size()) {
			resList.add(rightSortedList.get(j));
			j++;
		}
		return resList;
	}

}
