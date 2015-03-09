package hk.edu.cityu.tree.binary;

import hk.edu.cityu.tree.TreeNode;

public interface BinaryTreeNode<T> extends TreeNode<T> {
	public boolean hasLeftNode();

	public boolean hasRightNode();

	public BinaryTreeNode<T> getLeftNode();

	public BinaryTreeNode<T> getRightNode();

	public void setLeftNode(BinaryTreeNode<T> leftNode);
	
	public void setRightNode(BinaryTreeNode<T> rightNode);
	
	public Iterable<? extends BinaryTreeNode<T>> travelInOrder();

	public Iterable<? extends BinaryTreeNode<T>> travelInPreOrder();

	public Iterable<? extends BinaryTreeNode<T>> travelInPostOrder();

	@Override
	public BinaryTreeNode<T> getParentNode();

	@Override
	public BinaryTreeNode<T> search(T t);

	@Override
	public Iterable<? extends BinaryTreeNode<T>> getSubNodes();

}
