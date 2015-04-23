package hk.edu.cityu;

import hk.edu.cityu.tree.binary.search.BinarySearchTree;
import hk.edu.cityu.tree.binary.search.BinarySearchTreeNode;
import hk.edu.cityu.tree.binary.search.rb.RBT;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree=new RBT<Integer>();
		tree.add(Arrays.asList(13,10,5,3,7,6,9,8,13,11,20,25,16));
		for(BinarySearchTreeNode<Integer> node:tree.getRoot().travelInOrder())
			System.out.println(node.getValue());
		tree.delete(tree.getRoot());
		System.out.println();
		for(BinarySearchTreeNode<Integer> node:tree.getRoot().travelInOrder())
			System.out.println(node.getValue());
		System.out.println(tree.getSuccessor(tree.getRoot()).getValue());
		System.out.println(tree.getRoot().getSubNodeNumber());
		System.out.println(tree.getRoot().isRoot());
	}

}
