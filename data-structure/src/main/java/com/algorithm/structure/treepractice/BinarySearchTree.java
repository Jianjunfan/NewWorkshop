package com.algorithm.structure.treepractice;

public class BinarySearchTree {
	
	public static class TreeNode{
		public int key;
		public TreeNode leftNode, rightNode;
		public TreeNode(int key){
			this.key = key;
			leftNode = rightNode = null;
		}
	} 	
	
	public TreeNode rootNode = null;
	
	public BinarySearchTree(int rootValue){
		TreeNode node = new TreeNode(rootValue);
		this.rootNode = node;		
	}
	
	public BinarySearchTree(){
		this.rootNode = null;
	}
	
	public static BinarySearchTree constructBinaryTree() {
		
		/**
		 *            10
		 *           /  \
		 *          5   15
		 *         / \  / \
		 *        4  6 14  16
		 */
		BinarySearchTree bt = new BinarySearchTree(10);
		bt.rootNode.leftNode = new TreeNode(5);
		bt.rootNode.rightNode = new TreeNode(15);
		
		bt.rootNode.leftNode.leftNode = new TreeNode(4);
		bt.rootNode.leftNode.rightNode = new TreeNode(6);
//		
		bt.rootNode.rightNode.leftNode = new TreeNode(14);
		bt.rootNode.rightNode.rightNode  = new TreeNode(16);		
		return bt;
	}
	
	/*
	 * Tree traversal 
	 * inorder:   leftSubTree -> root -> RightSubTree -- for binary search tree, this way will list node by increasing way.
	 * outorder:  RightSubTree -> root -> LeftSubTree
	 * preorder:  root->leftSubTree->rightSubTree, this order mainly for tree copy..
	 * postorder: leftSubTree->rightSubTree->root, this order mainly for delete a tree.
	 * 
	 */
	
	public void inOrderTraversal(TreeNode node) {
		if(node == null) return;
		inOrderTraversal(node.leftNode);
		System.out.println("the node data is " + node.key);
		inOrderTraversal(node.rightNode);
		
	}
	
	public void outOrderTraversal(TreeNode node) {
		if(node ==null) return;
		outOrderTraversal(node.rightNode);
		System.out.println("the node data is " + node.key);
		outOrderTraversal(node.leftNode);
	}
	
	public void preOrderTraversal(TreeNode node) {
		if(node==null) return;
		System.out.println("the node data is " + node.key);
		preOrderTraversal(node.leftNode);
		preOrderTraversal(node.rightNode);
		
	}
	
	public void postOrderTraversal(TreeNode node) {
		if(node==null) return;
		postOrderTraversal(node.leftNode);
		postOrderTraversal(node.rightNode);
		System.out.println("the node data is " + node.key);
	}
	
	public TreeNode deleteAllNode(TreeNode node) {
		if(node == null) return null;
		
		node.leftNode = deleteAllNode(node.leftNode);
		node.rightNode = deleteAllNode(node.rightNode);
		
		node = null;
		
		return node;
	}
	
	public TreeNode deleteAllLeftNode(boolean leftFlag, TreeNode node) {
		if(node == null) return null;
		node.leftNode = deleteAllLeftNode(true, node.leftNode);
		node.rightNode = deleteAllLeftNode(false, node.rightNode);
		if(leftFlag) {
			System.out.println("delete left node:  " + node.key);
			node = null;
		}
		else {
			System.out.println("reserve right node:  " + node.key);
		}
		return node;
	}
	
	public void deleteAllRightNode(boolean rightFlag, TreeNode node) {
		
	}
	
	

}
