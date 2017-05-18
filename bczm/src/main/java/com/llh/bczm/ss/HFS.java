package com.llh.bczm.ss;

import java.util.LinkedList;
import java.util.Queue;

public class HFS {

	public static void main(String[] args) {
		HFS dfs = new HFS();
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
		
		sort(root);
	}
	
	Queue queue = new LinkedList<Integer>();
	
	public void sort(Node root){
		queue.add(root);
		while(!queue.isEmpty()){
			Node n = (Node)queue.poll();
			if(null != n.getLeft()){
				queue.add(n.getLeft());
			}
			if(null != n.getRight()){
				queue.add(n.getRight());
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
