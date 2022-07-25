package com.greatlearning.findsumofpair.main;

import java.util.HashSet;
import java.util.Scanner;

public class FindSumOfPair {

	static class Node {
		int nodeData;
		Node left;
		Node right;
	}

	static Node newNode(int nodeData) {
		Node n = new Node();
		n.nodeData = nodeData;
		n.left = null;
		n.right = null;
		return n;
	}

	public Node insert(Node root, int key) {
		if (root == null)
			return newNode(key);
		if (key < root.nodeData) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}
		return root;
	}

	public boolean findPair(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;
		if (findPair(root.left, sum, set))
			return true;
		if (set.contains(sum - root.nodeData)) {
			System.out.println("Pair is found " + (sum - root.nodeData) + "," + root.nodeData);
			return true;
		}

		else {
			set.add(root.nodeData);
		}
		return findPair(root.right, sum, set);
	}

	public void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findPair(root, sum, set))
			System.out.println("Pairs do not exist" + "\n");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node root = null;

		FindSumOfPair findSP = new FindSumOfPair();
		root = findSP.insert(root, 40);
		root = findSP.insert(root, 20);
		root = findSP.insert(root, 60);
		root = findSP.insert(root, 10);
		root = findSP.insert(root, 30);
		root = findSP.insert(root, 50);
		root = findSP.insert(root, 70);

		System.out.println("Enter the sum");

		int sum = sc.nextInt();
		findSP.findPairWithGivenSum(root, sum);
	}

}
