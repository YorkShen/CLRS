package hk.edu.cityu.sort.implementation.compare;

import hk.edu.cityu.sort.SortInterface;
import hk.edu.cityu.tree.binary.search.BST;
import hk.edu.cityu.tree.binary.search.BinarySearchTree;
import hk.edu.cityu.tree.binary.search.BinarySearchTreeNode;

import java.util.List;

public class BSTSort<T extends Comparable<T>> implements SortInterface<T> {

	@Override
	public void sort(List<T> list) {
		BinarySearchTree<T> tree=new BST<T>();
		tree.add(list);
		list.clear();
		for(BinarySearchTreeNode<T> node:tree.getRoot().travelInOrder())
			list.add(node.getValue());
	}

}
