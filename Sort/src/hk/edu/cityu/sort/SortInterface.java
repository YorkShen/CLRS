package hk.edu.cityu.sort;

import java.util.List;

public interface SortInterface<T extends Comparable<T>> {
	public void sort(List<T> list);
}
