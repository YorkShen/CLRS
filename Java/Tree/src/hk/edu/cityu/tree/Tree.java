package hk.edu.cityu.tree;

public interface Tree<T> {
	public TreeNode<T> getRoot();

	public void delete(TreeNode<T> treeNode);

	public boolean contains(T value);

	public void clear();

	public boolean isEmpty();

}
