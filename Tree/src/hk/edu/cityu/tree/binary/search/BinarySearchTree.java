package hk.edu.cityu.tree.binary.search;

import java.util.Collection;

import hk.edu.cityu.tree.binary.BinaryTree;

public interface BinarySearchTree<T extends Comparable<T>> extends
		BinaryTree<T> {

	public void add(T value);

	public void add(Collection<T> collection);
	
	public BinarySearchTreeNode<T> getSuccessor(BinarySearchTreeNode<T> node);

	public BinarySearchTreeNode<T> getPrecessor(BinarySearchTreeNode<T> node);

	@Override
	public BinarySearchTreeNode<T> getRoot();
}
