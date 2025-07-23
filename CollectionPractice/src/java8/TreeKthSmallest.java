package java8;

public class TreeKthSmallest {
	class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    // Insert method to build the BST
    public Node insert(Node root, int x) {
        if (root == null) {
        	//System.out.print(root.data+" - ");
            return new Node(x);
        }
        if (x < root.data) {
            root.left = insert(root.left, x);
            //System.out.print(root.left.data+" - ");
        }
        else if (x > root.data) {
            root.right = insert(root.right, x);
            //System.out.print(root.right.data+" - ");
        }
        return root;
        
    }

    // Kth Smallest method
    int c = 0, res = -1;

    public int kthSmallest(Node A, int B) {
        if (A == null) {
            return res;
        }
        kthSmallest(A.left, B);
        c++;
        System.out.println(A.data+" "+c);
        if (c == B) {
            res = A.data;
            return res;
        }
        kthSmallest(A.right, B);
        // Removed return res; from here
        return res;
    }

    public static void main(String[] args) { // Changed from void to static
        TreeKthSmallest tree = new TreeKthSmallest(); // Create an instance of the class
        Node root = null;
        int keys[] = {20,10,22,5,12,21};
        for (int x : keys) {
            root = tree.insert(root, x);
        //System.out.print(x+" - ");
        }
        // Use the instance to call insert method
        int k = 3;
        System.out.println("The " + k + "th smallest element is: " + tree.kthSmallest(root, k));
    }
}
