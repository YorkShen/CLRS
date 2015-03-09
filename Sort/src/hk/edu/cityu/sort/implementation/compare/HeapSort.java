package hk.edu.cityu.sort.implementation.compare;

import java.util.Collections;
import java.util.List;

import hk.edu.cityu.sort.SortInterface;

public class HeapSort<T extends Comparable<T>> implements SortInterface<T> {

	@Override
	public void sort(List<T> list) {
		buildMaxHeap(list);
		for(int i=list.size()-1;i>=0;i--){
			Collections.swap(list, 0, i);
			maxHeapify(list.subList(0, i), 0);
		}
	}

	private void buildMaxHeap(List<T> list){
		for(int i=(list.size()-1)/2;i>=0;i--)
			maxHeapify(list, i);
	}
	
	
	private void maxHeapify(List<T> list,int i){
		int left=i*2+1, right=i*2+2,largest;
		if(left<list.size()&&list.get(left).compareTo(list.get(i))>0)
			largest=left;
		else
			largest=i;
		if(right<list.size()&&list.get(right).compareTo(list.get(largest))>0)
			largest=right;
		if(i!=largest){
			Collections.swap(list, i, largest);
			maxHeapify(list, largest);
		}
	}

}
