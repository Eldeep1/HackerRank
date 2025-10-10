import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
   
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

	public static Node insert(Node root,int data) {

        if (root==null) {
           return new Node(data);
        }
        Node movingNode = root;
        while (movingNode!=null) {
            if (data==movingNode.data) {
                return root;
            }
            if (data>movingNode.data) {
                if (movingNode.right==null) {
                    movingNode.right=new Node(data);
                    return root;
                }
                movingNode=movingNode.right;
            }
            else{
                if (movingNode.left==null) {
                    movingNode.left=new Node(data);
                    return root;
                }
                movingNode=movingNode.left;
            }
        }

        return root;
    }

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }	
}