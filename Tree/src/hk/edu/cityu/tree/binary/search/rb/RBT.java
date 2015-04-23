package hk.edu.cityu.tree.binary.search.rb;

import hk.edu.cityu.tree.TreeNode;
import hk.edu.cityu.tree.binary.search.BST;
import hk.edu.cityu.tree.binary.search.BinarySearchTreeNode;
import hk.edu.cityu.tree.binary.search.rb.RedBlackTreeNode.COLOR;

import java.util.Collection;

public class RBT<T extends Comparable<T>> extends BST<T> implements
		RedBlackTree<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void add(T value) {
		RedBlackTreeNode<T> parent = null, node = getRoot();
		while (node != null && node != SentinelNode.getInstance()) {
			parent = node;
			if (value.compareTo(node.getValue()) < 0)
				node = node.getLeftNode();
			else
				node = node.getRightNode();
		}
		node = new RBTNode<>(value);
		node.setParentNode(parent);
		if (parent == null)
			setRoot(node);
		else if (node.getValue().compareTo(parent.getValue()) < 0)
			parent.setLeftNode(node);
		else
			parent.setRightNode(node);
		node.setColor(COLOR.RED);
		node.setLeftNode(SentinelNode.getInstance());
		node.setRightNode(SentinelNode.getInstance());
		insertFixUp(node);
	}

	@Override
	public void add(Collection<T> collection) {
		for (T t : collection)
			add(t);
	}

	@Override
	public void delete(TreeNode<T> treeNode) {
		// TODO Auto-generated method stub
	}

	protected void insertFixUp(RedBlackTreeNode<T> node) {
		while (node.hasParentNode()
				&& node.getParentNode().getColor() == COLOR.RED) {
			if (node.getParentNode().hasParentNode()) {
				if (node.getParentNode() == node.getParentNode()
						.getParentNode().getLeftNode()) {
					RedBlackTreeNode<T> y = node.getParentNode()
							.getParentNode().getRightNode();
					if (y.getColor() == COLOR.RED) {
						node.getParentNode().setColor(COLOR.BLACK);
						y.setColor(COLOR.BLACK);
						node.getParentNode().getParentNode()
								.setColor(COLOR.RED);
						node = node.getParentNode().getParentNode();
					} else if (node.getParentNode().getRightNode() == node) {
						node = node.getParentNode();
						leftRotate(node);
					}
					if (node.hasParentNode()) {
						node.getParentNode().setColor(COLOR.BLACK);
						if (node.getParentNode().hasParentNode()) {
							node.getParentNode().getParentNode()
									.setColor(COLOR.RED);
							rightRotate(node.getParentNode().getParentNode());
						}
					}
				} else {
					RedBlackTreeNode<T> y = node.getParentNode()
							.getParentNode().getLeftNode();
					if (y.getColor() == COLOR.RED) {
						node.getParentNode().setColor(COLOR.BLACK);
						y.setColor(COLOR.BLACK);
						node.getParentNode().getParentNode()
								.setColor(COLOR.RED);
						node = node.getParentNode().getParentNode();
					} else if (node.getParentNode().getLeftNode() == node) {
						node = node.getParentNode();
						rightRotate(node);
					}
					if (node.hasParentNode()) {
						node.getParentNode().setColor(COLOR.BLACK);
						if (node.getParentNode().hasParentNode()) {
							node.getParentNode().getParentNode()
									.setColor(COLOR.RED);
							leftRotate(node.getParentNode().getParentNode());
						}
					}
				}
			}
		}
		getRoot().setColor(COLOR.BLACK);
	}

	protected boolean leftRotate(RedBlackTreeNode<T> x) {
		if (x.hasRightNode()) {
			RedBlackTreeNode<T> y = x.getRightNode();
			x.setRightNode(y.getLeftNode());
			if (y.hasLeftNode())
				y.getLeftNode().setParentNode(x);
			y.setParentNode(x.getParentNode());
			if (x.getParentNode() == null)
				setRoot(y);
			else if (x.getParentNode().getRightNode() == x)
				x.getParentNode().setRightNode(y);
			else
				x.getParentNode().setLeftNode(y);
			y.setLeftNode(x);
			x.setParentNode(y);
			return true;
		} else
			return false;
	}

	protected boolean rightRotate(RedBlackTreeNode<T> y) {
		if (y.hasLeftNode()) {
			RedBlackTreeNode<T> x = y.getLeftNode();
			y.setLeftNode(x.getRightNode());
			if (x.hasRightNode())
				x.getRightNode().setParentNode(y);
			x.setParentNode(y.getParentNode());
			if (y.getParentNode() == null)
				setRoot(x);
			else if (y == y.getParentNode().getRightNode())
				y.getParentNode().setRightNode(x);
			else
				y.getParentNode().setLeftNode(x);
			x.setRightNode(y);
			y.setParentNode(x);
			return true;
		} else
			return false;
	}

	@Override
	public RedBlackTreeNode<T> getSuccessor(BinarySearchTreeNode<T> node) {
		if (node.hasRightNode()&&node.getRightNode()!=SentinelNode.getInstance())
			return (RedBlackTreeNode<T>) node.getRightNode().getMin();
		else {
			BinarySearchTreeNode<T> p = node.getParentNode();
			if (p != null && node.getParentNode() == p.getRightNode()) {
				node = p;
				p = p.getParentNode();
			}
			return (RedBlackTreeNode<T>) p;
		}
	}

	@Override
	public RedBlackTreeNode<T> getPrecessor(BinarySearchTreeNode<T> node) {
		if (node.hasLeftNode()&&node.getLeftNode()!=SentinelNode.getInstance())
			return (RedBlackTreeNode<T>) node.getLeftNode().getMax();
		else {
			BinarySearchTreeNode<T> p = node.getParentNode();
			if (p != null && node == p.getLeftNode()) {
				node = p;
				p = p.getParentNode();
			}
			return (RedBlackTreeNode<T>) p;
		}
	}

	@Override
	public RedBlackTreeNode<T> getRoot() {
		return (RedBlackTreeNode<T>) super.getRoot();
	}
}
