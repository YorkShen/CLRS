package hk.edu.cityu.tree.binary.search;

import hk.edu.cityu.tree.binary.BinaryTreeNode;

public interface BinarySearchTreeNode<T extends Comparable<T>> extends
		BinaryTreeNode<T> {

	public BinarySearchTreeNode<T> getMin();

	public BinarySearchTreeNode<T> getMax();

	@Override
	public BinarySearchTreeNode<T> getLeftNode();

	@Override
	public BinarySearchTreeNode<T> getRightNode();

	@Override
	public BinarySearchTreeNode<T> getParentNode();

	@Override
	public BinarySearchTreeNode<T> search(T t);

	@Override
	public Iterable<? extends BinarySearchTreeNode<T>> travelInOrder();

	@Override
	public Iterable<? extends BinarySearchTreeNode<T>> travelInPreOrder();

	@Override
	public Iterable<? extends BinarySearchTreeNode<T>> travelInPostOrder();

	@Override
	public Iterable<? extends BinarySearchTreeNode<T>> getSubNodes();

}
