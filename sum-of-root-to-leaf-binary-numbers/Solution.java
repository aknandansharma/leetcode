// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	public int sumRootToLeaf(TreeNode root) {
		return search(root, 0);
	}

	int search(TreeNode node, int parentNumber) {
		if (node == null) {
			return 0;
		}

		int currentNumber = parentNumber * 2 + node.val;

		if (node.left == null && node.right == null) {
			return currentNumber;
		}

		return search(node.left, currentNumber) + search(node.right, currentNumber);
	}
}
