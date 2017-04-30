package hk.edu.cityu.tree.binary.search.rb;

import java.util.LinkedList;
import java.util.List;

import hk.edu.cityu.tree.binary.search.BSTNode;

public class RBTNode<T extends Comparable<T>> extends BSTNode<T> implements
		RedBlackTreeNode<T> {
	private COLOR color;

	public RBTNode() {
		super();
	}

	public RBTNode(T t) {
		super(t);
	}

	public RBTNode(T t, COLOR color) {
		this(t);
		this.color = color;
	}

	@Override
	public COLOR getColor() {
		return color;
	}

	@Override
	public void setColor(COLOR color) {
		this.color = color;
	}

	@Override
	public RedBlackTreeNode<T> getLeftNode() {
		return (RedBlackTreeNode<T>) super.getLeftNode();
	}

	@Override
	public RedBlackTreeNode<T> getRightNode() {
		return (RedBlackTreeNode<T>) super.getRightNode();
	}

	@Override
	public RedBlackTreeNode<T> getParentNode() {
		return (RedBlackTreeNode<T>) super.getParentNode();
	}

	@Override
	public RedBlackTreeNode<T> search(T t) {
		return (RedBlackTreeNode<T>) super.search(t);
	}

	@Override
	public RedBlackTreeNode<T> getMin() {
		return (hasLeftNode() && getLeftNode() != SentinelNode.getInstance()) ? getLeftNode()
				.getMin() : this;
	}

	@Override
	public RedBlackTreeNode<T> getMax() {
		return (hasRightNode() && getRightNode() != SentinelNode.getInstance()) ? getRightNode()
				.getMax() : this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends RedBlackTreeNode<T>> travelInOrder() {
		return removeSentinel((Iterable<? extends RedBlackTreeNode<T>>) super
				.travelInOrder());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends RedBlackTreeNode<T>> travelInPreOrder() {
		return removeSentinel((Iterable<? extends RedBlackTreeNode<T>>) super
				.travelInPreOrder());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends RedBlackTreeNode<T>> travelInPostOrder() {
		return removeSentinel((Iterable<? extends RedBlackTreeNode<T>>) super
				.travelInPostOrder());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends RedBlackTreeNode<T>> getSubNodes() {
		return (Iterable<? extends RedBlackTreeNode<T>>) super.getSubNodes();
	}

	private static <T extends Comparable<T>> Iterable<RedBlackTreeNode<T>> removeSentinel(
			Iterable<? extends RedBlackTreeNode<T>> iterable) {
		List<RedBlackTreeNode<T>> list = new LinkedList<>();
		for (RedBlackTreeNode<T> node : iterable)
			if (node != SentinelNode.getInstance())
				list.add(node);
		return list;
	}
}
