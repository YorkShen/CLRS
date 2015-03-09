package hk.edu.cityu.sort.implementation.compare;

import hk.edu.cityu.sort.SortInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort<T extends Comparable<T>> implements SortInterface<T> {

	@Override
	public void sort(List<T> list) {
		if (list != null && list.size() > 1) {
			int half = list.size() / 2;
			List<T> a = list.subList(0, half), b = list.subList(half,
					list.size());
			sort(a);
			sort(b);
			Collections.copy(list, merge(a, b));
		}
	}

	private List<T> merge(List<T> a, List<T> b) {
		List<T> list = new ArrayList<>(a.size() + b.size());
		int i, j;
		for (i = 0, j = 0; i < a.size() && j < b.size();) {
			if (a.get(i).compareTo(b.get(j)) <= 0) {
				list.add(a.get(i));
				i++;
			} else {
				list.add(b.get(j));
				j++;
			}
		}
		if (i == a.size())
			list.addAll(b.subList(j, b.size()));
		else
			list.addAll(a.subList(i, a.size()));
		return list;
	}
}