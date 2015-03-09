package hk.edu.cityu.tree.binary;

import hk.edu.cityu.tree.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class BTNode<T> implements BinaryTreeNode<T> {

	private T value;
	private BinaryTreeNode<T> parent;
	private BinaryTreeNode<T> leftNode;
	private BinaryTreeNode<T> rightNode;

	public BTNode() {
		this(null);
	}

	public BTNode(T t) {
		this.value = t;
	}

	@Override
	public int getHeight() {
		int left = -1, right = -1;
		if (leftNode != null)
			left = leftNode.getHeight();
		if (rightNode != null)
			right = rightNode.getHeight();
		return 1 + Math.max(left, right);
	}

	@Override
	public int getSubNodeNumber() {
		int count = 1;
		if (leftNode != null)
			count += leftNode.getSubNodeNumber();
		if (rightNode != null)
			count += rightNode.getSubNodeNumber();
		return count;
	}

	@Override
	public boolean isLeaf() {
		return leftNode == null && rightNode == null;
	}

	@Override
	public boolean isRoot() {
		return parent == null;
	}

	@Override
	public boolean hasParentNode() {
		return !isRoot();
	}
	
	@Override
	public void setValue(T t) {
		value = t;
	}

	@Override
	public T getValue() {
		return value;
	}

	@Override
	public BinaryTreeNode<T> getParentNode() {
		return parent;
	}

	@Override
	public BinaryTreeNode<T> search(T t) {
		BinaryTreeNode<T> node = null;
		if (t != null) {
			if (value.equals(t))
				node = this;
			else {
				if (leftNode != null)
					node = leftNode.search(t);
				if (node == null && rightNode != null)
					node = rightNode.search(t);
			}
		}
		return node;
	}

	@Override
	public boolean hasLeftNode() {
		return leftNode != null;
	}

	@Override
	public boolean hasRightNode() {
		return rightNode != null;
	}

	@Override
	public BinaryTreeNode<T> getLeftNode() {
		return leftNode;
	}

	@Override
	public BinaryTreeNode<T> getRightNode() {
		return rightNode;
	}

	@Override
	public void setLeftNode(BinaryTreeNode<T> leftNode) {
		this.leftNode=leftNode;
	}
	
	@Override
	public void setRightNode(BinaryTreeNode<T> rightNode) {
		this.rightNode=rightNode;
	}
	
	@Override
	public Iterable<? extends BinaryTreeNode<T>> travelInOrder() {
		return new Iterable<BinaryTreeNode<T>>() {

			@Override
			public Iterator<BinaryTreeNode<T>> iterator() {
				List<BinaryTreeNode<T>> list = new LinkedList<>();
				if (leftNode != null)
					list.addAll(toList(leftNode.travelInOrder()));
				list.add(BTNode.this);
				if (rightNode != null)
					list.addAll(toList(rightNode.travelInOrder()));
				return list.iterator();
			}
		};
	}

	@Override
	public Iterable<? extends BinaryTreeNode<T>> travelInPreOrder() {
		List<BinaryTreeNode<T>> list = new LinkedList<>();
		list.add(BTNode.this);
		if (leftNode != null)
			list.addAll(toList(leftNode.travelInOrder()));
		if (rightNode != null)
			list.addAll(toList(rightNode.travelInOrder()));
		return list;
	}

	@Override
	public Iterable<? extends BinaryTreeNode<T>> travelInPostOrder() {
		List<BinaryTreeNode<T>> list = new LinkedList<>();
		if (leftNode != null)
			list.addAll(toList(leftNode.travelInOrder()));
		if (rightNode != null)
			list.addAll(toList(rightNode.travelInOrder()));
		list.add(BTNode.this);
		return list;
	}

	@Override
	public Iterable<? extends BinaryTreeNode<T>> getSubNodes() {
		return travelInOrder();
	}
	
	@Override
	public void setParentNode(TreeNode<T> parent) {
		this.parent=(BinaryTreeNode<T>) parent;
	}
	
	private static <T> List<BinaryTreeNode<T>> toList(
			Iterable<? extends BinaryTreeNode<T>> iterator) {
		List<BinaryTreeNode<T>> list = new LinkedList<>();
		for (BinaryTreeNode<T> node : iterator)
			list.add(node);
		return list;
	}

	public static <T> Iterable<T> toIterableValue(
			Iterable<? extends BinaryTreeNode<T>> iterable) {
		List<T> list = new LinkedList<>();
		for (BinaryTreeNode<T> node : iterable)
			list.add(node.getValue());
		return list;
	}
	

}
