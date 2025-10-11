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

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
      	Node firstValueMovingPointer=root;
      	Node secondValueMovingPointer=root;
        //there should be a map that stores the node with it's parent so that we can find the lca....
        List<Node> firstAncestorsList = new ArrayList<>();
        List<Node> secondAncestorsList = new ArrayList<>();
        while (firstValueMovingPointer.data!=v1&&secondValueMovingPointer.data!=v2) {

            if (firstValueMovingPointer.data!=v1) {
                 firstAncestorsList.add(firstValueMovingPointer);
                if (firstValueMovingPointer.data<v1) {
                    firstValueMovingPointer=firstValueMovingPointer.right;
                }
                else{
                    firstValueMovingPointer=firstValueMovingPointer.left;
                }
            }

            

                        
            if (secondValueMovingPointer.data!=v2) {          
                secondAncestorsList.add(secondValueMovingPointer);

                if (secondValueMovingPointer.data<v2) {
                    secondValueMovingPointer=secondValueMovingPointer.right;
                }
                else{
                    secondValueMovingPointer=secondValueMovingPointer.left;
                }
            }

        }
            if (firstValueMovingPointer != null) {
        firstAncestorsList.add(firstValueMovingPointer);
    }
    if (secondValueMovingPointer != null) {
        secondAncestorsList.add(secondValueMovingPointer);
    }

        Set<Node> nodesSet= new HashSet<>();
        int firstArarySize=firstAncestorsList.size()-1;
        int secondArarySize=secondAncestorsList.size()-1;
        int loopSize=firstArarySize>secondArarySize?firstArarySize:secondArarySize;

        while (loopSize>0) {
            if (loopSize<=firstArarySize) {
                if (!nodesSet.add(firstAncestorsList.get(loopSize))) {
                return firstAncestorsList.get(loopSize);                    
                }
            }
             if (loopSize<=secondArarySize) {

                if (!nodesSet.add(secondAncestorsList.get(loopSize))) {
                    return secondAncestorsList.get(loopSize);                    
                }
            }
            loopSize--;
        }
        return root;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}