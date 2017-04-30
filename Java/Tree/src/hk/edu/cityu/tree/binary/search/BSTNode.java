package hk.edu.cityu.tree.binary.search;

import hk.edu.cityu.tree.binary.BTNode;

public class BSTNode<T extends Comparable<T>> extends BTNode<T> implements
		BinarySearchTreeNode<T> {

	public BSTNode() {
		this(null);
	}

	public BSTNode(T t) {
		super(t);
	}

	@Override
	public BinarySearchTreeNode<T> getLeftNode() {
		return (BinarySearchTreeNode<T>) super.getLeftNode();
	}

	@Override
	public BinarySearchTreeNode<T> getRightNode() {
		return (BinarySearchTreeNode<T>) super.getRightNode();
	}

	@Override
	public BinarySearchTreeNode<T> getParentNode() {
		return (BinarySearchTreeNode<T>) super.getParentNode();
	}

	@Override
	public BinarySearchTreeNode<T> search(T t) {
		BinarySearchTreeNode<T> node = null;
		if (t != null) {
			int diff = t.compareTo(getValue());
			if (diff == 0)
				node = this;
			else if (diff < 0 && hasLeftNode())
				node = getLeftNode().search(t);
			else if (diff > 0 && hasRightNode())
				node = getRightNode().search(t);
		}
		return node;
	}

	@Override
	public BinarySearchTreeNode<T> getMin() {
		return hasLeftNode() ? getLeftNode().getMin() : this;
	}

	@Override
	public BinarySearchTreeNode<T> getMax() {
		return hasRightNode() ? getRightNode().getMax() : this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends BinarySearchTreeNode<T>> travelInOrder() {
		return (Iterable<? extends BinarySearchTreeNode<T>>) super
				.travelInOrder();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends BinarySearchTreeNode<T>> travelInPreOrder() {
		return (Iterable<? extends BinarySearchTreeNode<T>>) super
				.travelInPreOrder();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends BinarySearchTreeNode<T>> travelInPostOrder() {
		return (Iterable<? extends BinarySearchTreeNode<T>>) super
				.travelInPostOrder();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends BinarySearchTreeNode<T>> getSubNodes() {
		return (Iterable<? extends BinarySearchTreeNode<T>>) super
				.getSubNodes();
	}

}
