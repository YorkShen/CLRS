package hk.edu.cityu.sort.implementation.compare;

import hk.edu.cityu.sort.SortInterface;

import java.util.List;

public class InsertSort<T extends Comparable<T>> implements SortInterface<T> {

	@Override
	public void sort(List<T> list) {
		if(list!=null&&list.size()>1){
			for(int i=1;i<list.size();i++){
				T key=list.get(i);
				int j;
				for(j=i-1;j>=0&&list.get(j).compareTo(key)>=0;j--)
					list.set(j+1, list.get(j));
				list.set(j+1, key);
			}
		}
	}
}
