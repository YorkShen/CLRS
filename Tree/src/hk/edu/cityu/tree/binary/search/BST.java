package hk.edu.cityu.tree.binary.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import hk.edu.cityu.tree.TreeNode;
import hk.edu.cityu.tree.binary.BT;

public class BST<T extends Comparable<T>> extends BT<T> implements
		BinarySearchTree<T> {

	@Override
	public void delete(TreeNode<T> treeNode) {
		BinarySearchTreeNode<T> node=(BinarySearchTreeNode<T>) treeNode;
		if(!node.hasLeftNode())
			transplant(node, node.getRightNode());
		else if(!node.hasRightNode())
			transplant(node, node.getLeftNode());
		else {
			BinarySearchTreeNode<T> inserted=node.getRightNode().getMin();
			if(inserted!=node.getRightNode()){
				transplant(inserted, inserted.getRightNode());
				inserted.setRightNode(node.getRightNode());
				node.getRightNode().setParentNode(inserted);
			}
			transplant(node, inserted);
			inserted.setLeftNode(node.getLeftNode());
			node.setParentNode(inserted);
		}
	}

	@Override
	public void add(T value) {
		BinarySearchTreeNode<T> parent=null,node=getRoot();
		while(node!=null){
			parent=node;
			if(value.compareTo(node.getValue())<0)
				node=node.getLeftNode();
			else
				node=node.getRightNode();
		}
		node=new BSTNode<>(value);
		node.setParentNode(parent);
		if(parent==null)
			setRoot(node);
		else if(node.getValue().compareTo(parent.getValue())<0)
			parent.setLeftNode(node);
		else
			parent.setRightNode(node);
	}

	@Override
	public void add(Collection<T> collection) {
		List<T> list=new ArrayList<>(collection);
		Collections.shuffle(list);
		for(T t:list)
			add(t);
	}
	
	@Override
	public BinarySearchTreeNode<T> getSuccessor(BinarySearchTreeNode<T> node) {
		if(node.hasRightNode())
			return node.getRightNode().getMin();
		else{
			BinarySearchTreeNode<T> p=node.getParentNode();
			if(p!=null&&node.getParentNode()==p.getRightNode()){
				node=p;
				p=p.getParentNode();
			}
			return p;
		}
	}

	@Override
	public BinarySearchTreeNode<T> getPrecessor(BinarySearchTreeNode<T> node) {
		if(node.hasLeftNode())
			return node.getLeftNode().getMax();
		else{
			BinarySearchTreeNode<T> p=node.getParentNode();
			if(p!=null&&node==p.getLeftNode()){
				node=p;
				p=p.getParentNode();
			}
			return p;
		}
	}

	@Override
	public BinarySearchTreeNode<T> getRoot() {
		return (BinarySearchTreeNode<T>) super.getRoot();
	}
	
}
