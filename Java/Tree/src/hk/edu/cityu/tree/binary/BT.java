package hk.edu.cityu.tree.binary;

abstract public class BT<T> implements BinaryTree<T> {
	private BinaryTreeNode<T> root;

	@Override
	public boolean contains(T value) {
		return root == null ? false : root.search(value) != null;
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	protected void setRoot(BinaryTreeNode<T> root){
		this.root=root;
	}
	
	protected void transplant(BinaryTreeNode<T> cut,BinaryTreeNode<T> paste){
		if(cut.isRoot())
			setRoot(paste);
		else if (cut.getParentNode().getLeftNode()==cut) 
			cut.getParentNode().setLeftNode(paste);
		else
			cut.getParentNode().setRightNode(paste);
		if(paste!=null)
			paste.setParentNode(cut.getParentNode());
	}
}
