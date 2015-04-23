package hk.edu.cityu.tree.binary.search.rb;

import hk.edu.cityu.tree.binary.search.BinarySearchTreeNode;

public interface RedBlackTreeNode<T extends Comparable<T>> extends
		BinarySearchTreeNode<T> {
	public enum COLOR {
		RED, BLACK
	};

	public COLOR getColor();

	public void setColor(COLOR color);

	@Override
	public RedBlackTreeNode<T> getMin();

	@Override
	public RedBlackTreeNode<T> getMax();

	@Override
	public RedBlackTreeNode<T> getLeftNode();

	@Override
	public RedBlackTreeNode<T> getRightNode();

	@Override
	public RedBlackTreeNode<T> getParentNode();

	@Override
	public RedBlackTreeNode<T> search(T t);

	@Override
	public Iterable<? extends RedBlackTreeNode<T>> travelInOrder();

	@Override
	public Iterable<? extends RedBlackTreeNode<T>> travelInPreOrder();

	@Override
	public Iterable<? extends RedBlackTreeNode<T>> travelInPostOrder();

	@Override
	public Iterable<? extends RedBlackTreeNode<T>> getSubNodes();
}
