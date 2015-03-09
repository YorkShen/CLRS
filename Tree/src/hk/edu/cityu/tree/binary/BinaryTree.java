package hk.edu.cityu.tree.binary;

import hk.edu.cityu.tree.Tree;

public interface BinaryTree<T> extends Tree<T> {

	@Override
	public BinaryTreeNode<T> getRoot();
}
