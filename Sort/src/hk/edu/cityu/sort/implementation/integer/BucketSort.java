package hk.edu.cityu.sort.implementation.integer;

import hk.edu.cityu.sort.LinearTimeSortInterface;
import hk.edu.cityu.sort.implementation.compare.InsertSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort implements LinearTimeSortInterface {

	@Override
	public void sort(List<Integer> list) {
		if(list!=null&&list.size()>1){
			int size=list.size(),ratio=size/Collections.max(list);
			List<List<Integer>> externalList=getExternalStorage(size);
			addToExternalList(list, ratio, externalList);
			sortSubList(externalList);
			concatnateList(list, externalList);
		}
	}

	private void addToExternalList(List<Integer> list, int ratio,
			List<List<Integer>> externalList) {
		int item;
		for(int i=0;i<list.size();i++){
			item=list.get(i);
			externalList.get(item*ratio).add(item);
		}
	}

	private void concatnateList(List<Integer> list,
			List<List<Integer>> externalList) {
		list.clear();
		for(List<Integer> subList:externalList)
			list.addAll(subList);
	}
	
	private List<List<Integer>> getExternalStorage(int size){
		List<List<Integer>> list=new ArrayList<List<Integer>>(size);
		for(int i=0;i<size;i++)
			list.add(new LinkedList<Integer>());
		return Collections.unmodifiableList(list);
	}

	private void sortSubList(List<List<Integer>> externalList){
		InsertSort<Integer> insertSort=new InsertSort<>();
		for(List<Integer> subList:externalList)
			insertSort.sort(subList);
	}
	
}
