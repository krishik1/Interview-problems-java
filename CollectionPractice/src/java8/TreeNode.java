package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TreeNode {
	
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
    
}

class MaxSumOfTree {
	
    static int maxSum=Integer.MIN_VALUE;

    public static int findMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(findMaxSum(root.left), 0);
        int rightSum = Math.max(findMaxSum(root.right), 0);
        int currentNodeMaxSum = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, currentNodeMaxSum);
        return maxSum;
    }
    int max=Integer.MIN_VALUE;
    ArrayList<Integer> maxPath=new ArrayList<>();
    public ArrayList<Integer> findMaxSumPath(TreeNode root) {
    	ArrayList<Integer> currentPath = new ArrayList<>();
        getMaxPath(root, currentPath);
        return maxPath;
    }

    public int getMaxPath(TreeNode A,ArrayList<Integer> currentPath){
    	if(A==null)return 0;
    	int leftSum = Math.max(getMaxPath(A.left, currentPath), 0);
        int rightSum = Math.max(getMaxPath(A.right, currentPath), 0);

        // Calculate the maximum sum for the current node
        int currentNodeMaxSum = A.val + leftSum + rightSum;

        // Check if the current path yields a greater sum
        if (currentNodeMaxSum > maxSum) {
            max = currentNodeMaxSum;
            maxPath = new ArrayList<>(currentPath);
            maxPath.add(A.val);
        }
    	return max;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // Find the maximum sum
        findMaxSum(root);
        MaxSumOfTree obj=new MaxSumOfTree();
        ArrayList<Integer> list=obj.maxPath;
        for(int val:list) {
        	System.out.println("val"+val);
        }
        // Print the result
        System.out.println("Maximum Sum of the Tree: " + maxSum);
    }
}
