package gap.interview.prep.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MergeSortCF {
	List<Integer> list;

	public MergeSortCF(List<Integer> list) {
		super();
		this.list = list;
	}

	public CompletableFuture<List<Integer>> sortList() {
		return CompletableFuture.supplyAsync(() -> {
			if (list.size() <= 1) {
				return list;
			}
			int mid = list.size() / 2;
			List<Integer> leftList = new ArrayList<>(list.subList(0, mid));
			List<Integer> rightList = new ArrayList<>(list.subList(mid, list.size()));
			MergeSortCF leftSort = new MergeSortCF(leftList);
			MergeSortCF rightSort = new MergeSortCF(rightList);
			CompletableFuture<List<Integer>> leftRes = leftSort.sortList();
			CompletableFuture<List<Integer>> rightRes = rightSort.sortList();

			return leftRes.thenCombine(rightRes, this::merge).join();
		});
	}

	private List<Integer> merge(List<Integer> leftSortedList, List<Integer> rightSortedList) {
		int i = 0, j = 0;
		List<Integer> resList = new ArrayList<>();
		while (i < leftSortedList.size() && j < rightSortedList.size()) {
			if (leftSortedList.get(i) < rightSortedList.get(j)) {
				resList.add(leftSortedList.get(i));
				i++;
			} else {
				resList.add(rightSortedList.get(j));
				j++;
			}
		}
		while (i < leftSortedList.size()) {
			resList.add(leftSortedList.get(i));
			i++;
		}
		while (j < rightSortedList.size()) {
			resList.add(rightSortedList.get(j));
			j++;
		}
		return resList;
	}

}
