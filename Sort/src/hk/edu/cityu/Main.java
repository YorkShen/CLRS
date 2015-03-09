package hk.edu.cityu;

import hk.edu.cityu.sort.SortInterface;
import hk.edu.cityu.sort.Validation;
import hk.edu.cityu.sort.implementation.compare.BSTSort;
import hk.edu.cityu.sort.implementation.compare.HeapSort;
import hk.edu.cityu.sort.implementation.compare.InsertSort;
import hk.edu.cityu.sort.implementation.compare.MergeSort;
import hk.edu.cityu.sort.implementation.compare.QuickSort;
import hk.edu.cityu.sort.implementation.integer.BucketSort;
import hk.edu.cityu.sort.implementation.integer.CountingSort;
import hk.edu.cityu.sort.implementation.integer.RadixSort;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Validation<Integer> validation=Validation.getInstance(1000);
		List<SortInterface<Integer>> list=Arrays.asList(new BSTSort<Integer>(),new BucketSort(),new HeapSort<Integer>(),new RadixSort(),new CountingSort(),new MergeSort<Integer>(),new InsertSort<Integer>(),new QuickSort<Integer>());
		for(SortInterface<Integer> item:list){
			boolean result=validation.valiate(item);
			System.out.print(item.getClass().getSimpleName());
			if(!result)
				System.out.println(" Sort error!!!");
			else
				System.out.println(" Sort correct");
		}
	}

}
