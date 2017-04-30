package hk.edu.cityu.sort.implementation.integer;

import hk.edu.cityu.sort.LinearTimeSortInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSort implements LinearTimeSortInterface {
	
	static interface DigitInterface{
		int getDigit(int digit);
	}
	
	private DigitInterface digitInterface;
	
	public CountingSort() {
		this(new DigitInterface() {
			
			@Override
			public int getDigit(int digit) {
				return digit;
			}
		});
	}
	
	CountingSort(DigitInterface digitInterface){
		this.digitInterface=digitInterface;
	}
	
	@Override
	public void sort(List<Integer> list) {
		if (list != null && list.size() > 1) {
			int range;
			int min=preProcessNegative(list);
			range = Collections.max(generateFormatList(list));
			List<Integer> tempList = createTempStorage(range);
			count(list, tempList);
			sumCount(tempList);
			List<Integer> result = sort(list, tempList);
			Collections.copy(list, result);
			postProcessNegative(list,min);
		}
	}

	private List<Integer> generateFormatList(List<Integer> list){
		List<Integer> result=new ArrayList<>(list.size());
		for(int i=0;i<list.size();i++)
			result.add(digitInterface.getDigit(list.get(i)));
		return result;
	}
	
	static int preProcessNegative(List<Integer> list) {
		int min, supply;
		min = Collections.min(list);
		if (min < 0) {
			supply = Math.abs(min);
			for (int i = 0; i < list.size(); i++)
				list.set(i, list.get(i) + supply);
		}
		if(Collections.min(list)<0)
			throw new RuntimeException("Integer OverFlow");
		else
			return min;
	}

	private List<Integer> createTempStorage(int range) {
		List<Integer> arrayList = new ArrayList<>(range + 1);
		for (int i = 0; i <= range; i++)
			arrayList.add(0);
		return arrayList;
	}

	private void count(List<Integer> list, List<Integer> storage) {
		for (Integer item : list)
			storage.set(digitInterface.getDigit(item), storage.get(digitInterface.getDigit(item)) + 1);
	}

	private void sumCount(List<Integer> storage) {
		for (int i = 1; i < storage.size(); i++)
			storage.set(i, storage.get(i - 1) + storage.get(i));
	}

	private List<Integer> sort(List<Integer> list, List<Integer> storage) {
		List<Integer> result = new ArrayList<Integer>(list);
		int value;
		for (int i = list.size() - 1; i >= 0; i--) {
			value = digitInterface.getDigit(list.get(i));
			result.set(storage.get(value)-1, list.get(i));
			storage.set(value, storage.get(value) - 1);
		}
		return result;
	}
	
	static void postProcessNegative(List<Integer> result, int min){
		if(min<0){
			for(int i=0;i<result.size();i++)
				result.set(i, result.get(i)+min);
		}
	}
}