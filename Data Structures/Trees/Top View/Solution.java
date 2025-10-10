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
    static class QueueEntry {
    Node node;
    int hd; // Horizontal Distance

    public QueueEntry(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
public static void topView(Node root) {
    if (root == null) {
        return;
    }


    TreeMap<Integer, Integer> topViewMap = new TreeMap<>();

    Queue<QueueEntry> queue = new LinkedList<>();

    queue.add(new QueueEntry(root, 0));

    while (!queue.isEmpty()) {
        QueueEntry current = queue.poll();
        Node node = current.node;
        int hd = current.hd;

        if (!topViewMap.containsKey(hd)) {
            topViewMap.put(hd, node.data);
        }

        if (node.left != null) {
            queue.add(new QueueEntry(node.left, hd - 1));
        }

        if (node.right != null) {
            queue.add(new QueueEntry(node.right, hd + 1));
        }
    }

    StringBuilder result = new StringBuilder();
    for (int data : topViewMap.values()) {
        result.append(data).append(" ");
    }

    // Print the final string, trimming the trailing space
    System.out.println(result.toString().trim());
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
        scan.close();
        topView(root);
    }	
}