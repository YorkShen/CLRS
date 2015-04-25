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
		insertFix(node);
	}

	@Override
	public void add(Collection<T> collection) {
		for (T t : collection)
			add(t);
	}

	@Override
	public void delete(TreeNode<T> treeNode) {
		RedBlackTreeNode<T> z = (RedBlackTreeNode<T>) treeNode;
		RedBlackTreeNode<T> y = (RedBlackTreeNode<T>) treeNode;
		RedBlackTreeNode<T> x;
		COLOR yOriginalColor = y.getColor();
		if (!z.hasLeftNode() || z.getLeftNode() == SentinelNode.getInstance()) {
			x = z.getRightNode();
			transplant(z, z.getRightNode());
		} else if (!z.hasRightNode()
				|| z.getRightNode() == SentinelNode.getInstance()) {
			x = z.getLeftNode();
			transplant(z, z.getLeftNode());
		} else {
			y = z.getRightNode().getMin();
			yOriginalColor = y.getColor();
			x = y.getRightNode();
			if (y.getParentNode() == z)
				x.setParentNode(z);
			else {
				transplant(y, y.getRightNode());
				y.setRightNode(z.getRightNode());
				y.getRightNode().setParentNode(y);
			}
			transplant(z, y);
			y.setLeftNode(z.getLeftNode());
			y.getLeftNode().setParentNode(y);
			y.setColor(z.getColor());
		}
		if (yOriginalColor == COLOR.BLACK)
			deleteFix(x);
	}

	protected void deleteFix(RedBlackTreeNode<T> node) {
		while (node != getRoot() && node.getColor() != COLOR.BLACK) {
			if (node == node.getParentNode().getLeftNode()) {
				node = deleteLeftFix(node);
			} else {
				node = deleteRightFix(node);
			}
		}
		node.setColor(COLOR.BLACK);
	}

	protected void insertFix(RedBlackTreeNode<T> node) {
		while (node.hasParentNode()
				&& node.getParentNode().getColor() == COLOR.RED) {
			if (node.getParentNode().hasParentNode()) {
				if (node.getParentNode() == node.getParentNode()
						.getParentNode().getLeftNode()) {
					node = insertLeftFix(node);
				} else {
					node = insertRightFix(node);
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
		if (node.hasRightNode()
				&& node.getRightNode() != SentinelNode.getInstance())
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
		if (node.hasLeftNode()
				&& node.getLeftNode() != SentinelNode.getInstance())
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

	private RedBlackTreeNode<T> insertRightFix(RedBlackTreeNode<T> node) {
		RedBlackTreeNode<T> y = node.getParentNode().getParentNode()
				.getLeftNode();
		if (y.getColor() == COLOR.RED) {
			node.getParentNode().setColor(COLOR.BLACK);
			y.setColor(COLOR.BLACK);
			node.getParentNode().getParentNode().setColor(COLOR.RED);
			node = node.getParentNode().getParentNode();
		} else if (node.getParentNode().getLeftNode() == node) {
			node = node.getParentNode();
			rightRotate(node);
		}
		if (node.hasParentNode()) {
			node.getParentNode().setColor(COLOR.BLACK);
			if (node.getParentNode().hasParentNode()) {
				node.getParentNode().getParentNode().setColor(COLOR.RED);
				leftRotate(node.getParentNode().getParentNode());
			}
		}
		return node;
	}

	private RedBlackTreeNode<T> insertLeftFix(RedBlackTreeNode<T> node) {
		RedBlackTreeNode<T> y = node.getParentNode().getParentNode()
				.getRightNode();
		if (y.getColor() == COLOR.RED) {
			node.getParentNode().setColor(COLOR.BLACK);
			y.setColor(COLOR.BLACK);
			node.getParentNode().getParentNode().setColor(COLOR.RED);
			node = node.getParentNode().getParentNode();
		} else if (node.getParentNode().getRightNode() == node) {
			node = node.getParentNode();
			leftRotate(node);
		}
		if (node.hasParentNode()) {
			node.getParentNode().setColor(COLOR.BLACK);
			if (node.getParentNode().hasParentNode()) {
				node.getParentNode().getParentNode().setColor(COLOR.RED);
				rightRotate(node.getParentNode().getParentNode());
			}
		}
		return node;
	}

	private RedBlackTreeNode<T> deleteLeftFix(RedBlackTreeNode<T> node) {
		RedBlackTreeNode<T> w = node.getParentNode().getRightNode();
		if (w.getColor() == COLOR.RED) {
			w.setColor(COLOR.BLACK);
			node.getParentNode().setColor(COLOR.RED);
			leftRotate(node.getParentNode());
			w = node.getParentNode().getRightNode();
		}
		if (w.getLeftNode().getColor() == COLOR.BLACK
				&& w.getRightNode().getColor() == COLOR.BLACK) {
			w.setColor(COLOR.RED);
			node = node.getParentNode();
		} else if (w.getRightNode().getColor() == COLOR.BLACK) {
			w.getLeftNode().setColor(COLOR.BLACK);
			w.setColor(COLOR.RED);
			rightRotate(w);
			w = node.getParentNode().getRightNode();
		}
		w.setColor(w.getParentNode().getColor());
		node.getParentNode().setColor(COLOR.BLACK);
		if (w.getRightNode() != SentinelNode.getInstance())
			w.getRightNode().setColor(COLOR.BLACK);
		leftRotate(node.getParentNode());
		node = getRoot();
		return node;
	}

	private RedBlackTreeNode<T> deleteRightFix(RedBlackTreeNode<T> node) {
		RedBlackTreeNode<T> w = node.getParentNode().getLeftNode();
		if (w.getColor() == COLOR.RED) {
			w.setColor(COLOR.BLACK);
			node.getParentNode().setColor(COLOR.RED);
			rightRotate(node.getParentNode());
			w = node.getParentNode().getLeftNode();
		}
		if (w.getRightNode().getColor() == COLOR.BLACK
				&& w.getLeftNode().getColor() == COLOR.BLACK) {
			w.setColor(COLOR.RED);
			node = node.getParentNode();
		} else if (w.getLeftNode().getColor() == COLOR.BLACK) {
			w.getRightNode().setColor(COLOR.BLACK);
			w.setColor(COLOR.RED);
			leftRotate(w);
			w = node.getParentNode().getLeftNode();
		}
		w.setColor(w.getParentNode().getColor());
		node.getParentNode().setColor(COLOR.BLACK);
		if (w.getLeftNode() != SentinelNode.getInstance())
			w.getLeftNode().setColor(COLOR.BLACK);
		rightRotate(node.getParentNode());
		node = getRoot();
		return node;
	}
}
