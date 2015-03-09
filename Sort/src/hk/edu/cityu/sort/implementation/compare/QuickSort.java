package hk.edu.cityu.sort.implementation.compare;

import hk.edu.cityu.sort.SortInterface;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort<T extends Comparable<T>> implements SortInterface<T> {
	private Random random;
	public QuickSort() {
		random=new Random();
	}
	@Override
	public void sort(List<T> list) {
		if(list.size()>1){
			int index=partition(list);
			sort(list.subList(0, index));
			sort(list.subList(index+1, list.size()));
		}
	}

	private int partition(List<T> list){
		int i,j;
		final int index=0;
		Collections.swap(list, index, random.nextInt(list.size()));
		T pivot=list.get(index);
		for(i=0,j=i+1;j<list.size();j++)
			if(list.get(j).compareTo(pivot)<0)
				Collections.swap(list, ++i, j);
		Collections.swap(list, i, index);
		return i;
	}
}
