package com.llh.bczm.ss;

import java.util.Stack;

public class DFS {

	public static void main(String[] args) {
		
		DFS dfs = new DFS();
		dfs.dfs();
		
	}
	
	public void dfs(){
		Node root = new Node(1);
		Node left = new Node(2);
		Node right = new Node(3);
		root.setLeft(left);
		root.setRight(right);
		
		Node l_left = new Node(4);
		Node l_right = new Node(5);
		left.setLeft(l_left);
		left.setRight(l_right);
		Node ll_left = new Node(7);
		l_left.setLeft(ll_left);
		
		Node r_left = new Node(6);
		right.setLeft(r_left);
		
		sort1(root);
	}
	
	public void sort(Node root){
		System.out.print(root.getNum() + " ");
		if(null != root.getLeft()){
			//System.out.print(root.getLeft().getNum() + " ");
			sort(root.getLeft());
		}
		
		if(null != root.getRight()){
			//System.out.print(root.getRight().getNum() + " ");
			sort(root.getRight());
		}
		
	}
	
	Stack stack = new Stack<Integer>();
	
	public void sort1(Node root){
		stack.push(root);
		while(!stack.isEmpty()){
			Node n = (Node)stack.pop();
			if(null != n.getRight()){
				stack.push(n.getRight());
			}
			if(null != n.getLeft()){
				stack.push(n.getLeft());
			}
			System.out.print(n.getNum() + " ");
		}
		
	}
	
	class Node{
		int num;
		Node left;
		Node right;
		public Node(int num) {
			this.num = num;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
	}
}
