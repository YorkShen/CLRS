package hk.edu.cityu.sort.implementation.integer;

import java.util.Collections;
import java.util.List;

import hk.edu.cityu.sort.LinearTimeSortInterface;
import hk.edu.cityu.sort.implementation.integer.CountingSort.DigitInterface;

public class RadixSort implements LinearTimeSortInterface {
	private class Digit implements DigitInterface{
		private int position;
		
		@Override
		public int getDigit(int digit) {
			return (digit/((int)Math.pow(RADIX, position)))%RADIX;
		}
		
		private void add(){
			position++;
		}
	}
	private final static int RADIX=10;
	@Override
	public void sort(List<Integer> list) {
		Digit digit=new Digit();
		CountingSort countingSort;
		int min=CountingSort.preProcessNegative(list);
		int max=Collections.max(list);
		do{
			countingSort=new CountingSort(digit);
			countingSort.sort(list);
			digit.add();
		}while((max/=RADIX)!=0);
		CountingSort.postProcessNegative(list, min);
	}

}
