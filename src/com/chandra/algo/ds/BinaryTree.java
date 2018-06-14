package com.chandra.algo.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author cjoshi
 *
 */
public class BinaryTree {

	public static void main(String[] args) {
		BinaryTree bi=new BinaryTree();
		  // Creating a binary tree
		 // TreeNode rootNode=bi.createBinaryTree();
		
		Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode rootNode = null;
        while(t-- > 0){
            int data = scan.nextInt();
            rootNode = insert(rootNode, data);
        }
        scan.close();
        int height = bi.getHeight(rootNode);
		 
		  System.out.println("Binary Tree:");
		  BTreePrinter.printNode(rootNode);
		  System.out.println();
		  System.out.println("-------------------------");
		  
		  System.out.println("Recursive preorder traversal:");
		  bi.preorder(rootNode);
		  System.out.println();
		  System.out.println("-------------------------");
		  
		  System.out.println("Iterative preorder traversal:");
		  bi.preOrderIterative(rootNode);
		  System.out.println();
		  System.out.println("-------------------------");
		  
		  System.out.println("Recursive inorder traversal:");
		  bi.inOrder(rootNode);
		  System.out.println();
		  System.out.println("-------------------------");
		  
		  System.out.println("Iterative inorder traversal:");
		  bi.inOrderIterative(rootNode);
		  System.out.println();
		  System.out.println("-------------------------");
		  
		  System.out.println("Recursive postorder traversal:");
		  bi.postOrder(rootNode);
		  System.out.println();
		  System.out.println("-------------------------");
		  
		  System.out.println("Iterative postorder traversal:");
		  bi.postOrderIterative(rootNode);
		  System.out.println();
		  System.out.println("-------------------------");
		  
		  System.out.println("Level Order traversal:");
		  bi.levelOrder(rootNode);
		  System.out.println();
		  System.out.println("-------------------------");
		  
		  System.out.println("Reverse Level Order traversal:");
		  bi.reverseLevelOrder(rootNode);
		  System.out.println();
		  System.out.println("-------------------------");
		 
		  System.out.println("Height of the tree:");
		  System.out.println("Height - "+bi.getHeight(rootNode));
		  System.out.println();
		  System.out.println("-------------------------");
		  
	}
	public TreeNode createBinaryTree(){
		TreeNode rootNode =new TreeNode(40);
		TreeNode node20=new TreeNode(20);
		TreeNode node10=new TreeNode(10);
		TreeNode node30=new TreeNode(30);
	 	TreeNode node60=new TreeNode(60);
	 	TreeNode node50=new TreeNode(50);
	 	TreeNode node70=new TreeNode(70);
	  
		  rootNode.left=node20;
		  rootNode.right=node60;
		  
		  node20.left=node10;
		  node20.right=node30;
		  
		  node60.left=node50;
		  node60.right=node70;
		return rootNode;
	}
	
	/*
	 * Inorder traversal - left->node->right
	 */
	public void inOrder(TreeNode root) {
		  if(root !=  null) {
		   inOrder(root.left);
		   //Visit the node by Printing the node data  
		   System.out.printf("%d ",root.data);
		   inOrder(root.right);
		  }
	 }
	
	public void inOrderIterative(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = root;

		while (!stack.empty() || currentNode != null) {

			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			} else {
				TreeNode n = stack.pop();
				System.out.printf("%d ", n.data);
				currentNode = n.right;
			}
		}
	}
	/*
	 * PreOrder Traversal - Node->Left->Right
	 */
	public void preorder(TreeNode root) {
	    if(root !=  null) {
	   //Visit the node by Printing the node data  
	      System.out.printf("%d ",root.data);
	      preorder(root.left);
	      preorder(root.right);
	    }
	  }
	public void preOrderIterative(TreeNode root){
		// empty tree
		if(root== null)
			return;
		
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);
		while(!nodeStack.isEmpty()){
			TreeNode node=(TreeNode) nodeStack.pop();
			System.out.printf("%d ",node.data);
			if(node.right !=null)
				nodeStack.push(node.right);
			if(node.left !=null)
				nodeStack.push(node.left);
			
			
		}
	}
	/*
	 * PostOrder Traversal - Left->Right->Node
	 */
	public void postOrder(TreeNode root){
		
		
		if(root != null){
			// visit left tree
			postOrder(root.left);
			// visit right tree
			postOrder(root.right);
			System.out.printf("%d ",root.data);
		}
	}
	
	public void postOrderIterative(TreeNode root){
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		
		while(true){
			if(current != null){
				if(current.right != null)
					stack.push(current.right);
				stack.push(current);
				current=current.left;
				continue;
			}
			if(stack.isEmpty())
				return;
			current = stack.pop();
			if((current.right != null) 
					&&(!stack.isEmpty()) 
					&& (current.right==stack.peek()) ){
				stack.pop();
				stack.push(current);
				current=current.right;
			}else{
				System.out.print( current.data + " " );
				current=null;
			}
		}
	}
	
	public void levelOrder(TreeNode startNode){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(startNode);
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.printf("%d ",node.data);
			   if(node.left!=null)
				   queue.add(node.left);
			   if(node.right!=null)
				   queue.add(node.right);
		}
	}
	
	// prints in reverse level order
	 public void reverseLevelOrder(TreeNode startNode) {
	 Queue<TreeNode> queue=new LinkedList<TreeNode>();
	 Stack<TreeNode> stack=new Stack<TreeNode>();
	 queue.add(startNode);
	 while(!queue.isEmpty())
	 {
	 TreeNode tempNode=queue.poll();
	 if(tempNode.right!=null)
	 queue.add(tempNode.right);
	 if(tempNode.left!=null)
	 queue.add(tempNode.left);
	 
	 stack.push(tempNode);
	 }
	 
	 while(!stack.empty())
	 System.out.print(stack.pop().data+" " );
	 }
	 
	public int getHeight(TreeNode root) {
		int leftlength =0;
		int rightlenght=0;
		
		if (root == null)
			return -1;
		
		System.out.println("Root node data-"+root.data);
		
		
		leftlength = getHeight(root.left);
		
		rightlenght = getHeight(root.right);
		if (leftlength > rightlenght)
			return leftlength+1;
		else
			return rightlenght+1;

	}
	
	public static  TreeNode insert(TreeNode root, int data) {
        if(root == null){
            return new TreeNode(data);
        }
        else {
            TreeNode cur;
            int rootData = (int) root.data;
            if(data <= rootData){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else{
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
class TreeNode<T extends Comparable<?>>{
	T data;
	TreeNode<T> left, right;
	
	TreeNode(T data){
		this.data= data;
	}
}