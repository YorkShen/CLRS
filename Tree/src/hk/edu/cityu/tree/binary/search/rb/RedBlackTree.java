package hk.edu.cityu.tree.binary.search.rb;

import hk.edu.cityu.tree.binary.search.BinarySearchTree;
import hk.edu.cityu.tree.binary.search.BinarySearchTreeNode;

public interface RedBlackTree<T extends Comparable<T>> extends
		BinarySearchTree<T> {

	@Override
	public RedBlackTreeNode<T> getSuccessor(BinarySearchTreeNode<T> node);

	@Override
	public RedBlackTreeNode<T> getPrecessor(BinarySearchTreeNode<T> node);

	@Override
	public RedBlackTreeNode<T> getRoot();

}
