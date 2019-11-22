package com.algorithm.structure;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import com.algorithm.structure.grace.Dealer;
import com.algorithm.structure.grace.Player;
import com.algorithm.structure.sortpractice.HeapSort;
import com.algorithm.structure.steven.BaseInterface;
import com.algorithm.structure.steven.Steven1;
import com.algorithm.structure.steven.Steven2;
import com.algorithm.structure.steven.StevenBase;
import com.algorithm.structure.steven.StevenSub;
import com.algorithm.structure.treepractice.BinaryHeap;
import com.algorithm.structure.treepractice.BinarySearchTree;
//import com.algorithm.structure.treepractice.TreeNode;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		
//		String patten = "\\d*-\\d*";
//		String str = "7657-";
//        boolean bl = str.matches(patten);
//        System.out.println("the result is " + bl);
//        if(bl) {
//        	   String[] str_list = str.split("-");
//        	   System.out.println("str_list[0] is " + str_list[0]);
//        	   System.out.println("str_list[1] is " + str_list[1]);
//        }
        
        String testStr = "https://s3.amazonaws.com/dev-datafiles.ec268.snc.com/original/inbound/edpp/edpp_20180630.csv_2018-07-13-19-20-47%2B0000";
        String spec = "/";
        int lastIndex = testStr.lastIndexOf(spec);
        String substr = testStr.substring(lastIndex+1, testStr.length());
        System.out.println("the substr is " + substr);
        
        int value =3;
        String aql = "select " + value + "hello";
        System.out.println("the sql is " + aql);
//		ByteBuffer buf = ByteBuffer.allocate(1);
//		buf.put((byte)1);
//		byte[] headerlen = buf.array();
//		int i = headerlen[0];
//		System.out.println("Hello World!");
////		binaryTreefunction();
////		consgructBinayHeap();
//		sortPractice();
		
		//graceDemo();
//		Steven1 steven = new Steven1();
//		steven.name = "jioanjun";
//		
//		Steven1 steven1 = steven;
//		Steven1 steven2 = null;
//		steven = steven2;
//		steven2 = steven1;
//		steven1.name = "change";
//		steven1.city = "qixian";
//		System.out.println("steven.name is " + steven.name);
//		String str1 = "fanjian";
//		String str2 = str1;
//		str2 = "heheheh";
//		System.out.println("str1 is "+str1 + "str2 is " + str2);
//		steven.test();
		
		StevenBase stevenBase = new StevenSub();
		int var;
		if((var=6)!=7) {
			System.out.println("var is not null "+var );
			 
		}
		
		StevenSub stevenSub = (StevenSub)stevenBase;
		
		stevenSub.baseprintPublic();
		stevenSub.subprintPublic();
		
		Steven2 s2 = new Steven2("fan","bj",3);
		System.out.println("s2.count is " + s2.count);
		System.out.println("s2.count is " + Steven2.count);
		
		s2.s2Print();
		Steven2.s2Print();

		String num = "23432.45";
		DecimalFormat df = new DecimalFormat("0.00000"); 
		
//		String formatted = df.format(2.45);
		String formatted = df.format(Double.valueOf(num));
		System.out.println("formatted is "+formatted );
				 
	}
	
	public static void graceDemo() {
		Scanner scan=new Scanner(System.in);
        System.out.println("What is your name?");
        String name=scan.next();
        System.out.println("How many chips do you have?");
        int chip=scan.nextInt();
        Player p1=new Player(name, chip);
        Dealer d1=new Dealer(p1);
        d1.start();
	}

	public static void binaryTreefunction() {
		BinarySearchTree bst = BinarySearchTree.constructBinaryTree();

		// BinarySearchTree bst = new BinarySearchTree(10);
		// bst.rootNode.leftNode = new TreeNode(5);
		// bst.rootNode.rightNode = new TreeNode(15);

		// System.out.println("in inorder traversal, the node data be ascend sequence");
		// bst.inOrderTraversal(bst.rootNode);
		//
		// System.out.println("in outorder traversal, the node data be decs sequence");
		// bst.outOrderTraversal(bst.rootNode);
		//
		// System.out.println("in preorder traversal, it is for copy a tree");
		// bst.preOrderTraversal(bst.rootNode);
		//
		// System.out.println("in outorder traversal, it is delete a tree");
		// bst.postOrderTraversal(bst.rootNode);

		// System.out.println("in deleteAllNode, it is delete all tree node");
		// bst.rootNode = bst.deleteAllNode(bst.rootNode);
		// if(bst.rootNode == null) System.out.println("the tree is empty now");

//		System.out.println("in deleteAllLeftNode, it is delete all left tree node");
//		bst.rootNode = bst.deleteAllLeftNode(false, bst.rootNode);
//
//		System.out.println("in preorder traversal, it is for copy a tree");
//		bst.preOrderTraversal(bst.rootNode);
		

	}
	
	public static void consgructBinayHeap() {
		BinaryHeap binaryHeap = new BinaryHeap();
		int[] array = {4,6,7,8,12,9};
		binaryHeap.constructMaxBinatyHeap(array);
		
		int[] array1 = {4,6,7,8,12,9};
		binaryHeap.constructMinBinatyHeap(array1);
	}
	
	public static void sortPractice() {
		//test heap-sort
		int[] array = {4,6,7,8,12,9};
		HeapSort heapSort = new HeapSort();
		heapSort.heapSortImplement(array);
		
	}
	
}
