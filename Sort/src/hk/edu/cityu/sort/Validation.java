package hk.edu.cityu.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Validation<T extends Comparable<T>> {
	private List<T> list;

	public static Validation<Integer> getInstance(int size) {
		List<Integer> list = new ArrayList<>(size);
		Random random = new Random();
		for (int i = 0; i < size; i++)
			list.add(random.nextInt(100000));
		return new Validation<>(list);
	}

	public Validation(List<T> list) {
		this.list = list;
	}

	public boolean valiate(SortInterface<T> sort) {
		if (list != null) {
			List<T> systemSort = new ArrayList<>(list), homemadeSort = new ArrayList<>(
					list);
			Collections.sort(systemSort);
			sort.sort(homemadeSort);
			if (systemSort.equals(homemadeSort))
				return true;
		}
		return false;
	}
}
