package hk.edu.cityu.tree;

public interface TreeNode<T> {
	public int getHeight();

	public int getSubNodeNumber();

	public boolean isLeaf();

	public boolean isRoot();

	public boolean hasParentNode();
	
	public void setValue(T t);

	public T getValue();

	public TreeNode<T> getParentNode();

	public void setParentNode(TreeNode<T> parent);
	
	public TreeNode<T> search(T t);

	public Iterable<? extends TreeNode<T>> getSubNodes();
}
