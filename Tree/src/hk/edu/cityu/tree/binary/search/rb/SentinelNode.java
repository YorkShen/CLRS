package hk.edu.cityu.tree.binary.search.rb;

public class SentinelNode<T extends Comparable<T>> extends RBTNode<T> implements
		RedBlackTreeNode<T> {

	private static SentinelNode<?> instance;

	private SentinelNode() {
		super.setColor(COLOR.BLACK);
	}

	@SuppressWarnings("rawtypes")
	public static synchronized SentinelNode getInstance() {
		if (instance == null)
			instance = new SentinelNode();
		return instance;
	}

	@Override
	public void setColor(COLOR color) {
		throw new UnsupportedOperationException("Cannot change NIL's color");
	}

	@Override
	public T getValue() {
		throw new UnsupportedOperationException("Sentinel has no value");
	}

	@Override
	public RedBlackTreeNode<T> getMax() {
		throw new UnsupportedOperationException("Sentinel has no value");
	}

	@Override
	public RedBlackTreeNode<T> getMin() {
		throw new UnsupportedOperationException("Sentinel has no value");
	}

	@Override
	public RedBlackTreeNode<T> getParentNode() {
		throw new UnsupportedOperationException("Sentinel has no value");
	}

}
