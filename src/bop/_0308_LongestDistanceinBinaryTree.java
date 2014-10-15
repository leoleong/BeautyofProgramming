package bop;

import java.util.ArrayList;
import java.util.List;

public class _0308_LongestDistanceinBinaryTree {

	public static void main(String[] args) {

	}

	public static int longestDistance(TreeNode root) {
		if (root == null) {
			return 0;
		}

		List<Integer> result = new ArrayList<Integer>();
		result.add(Integer.MIN_VALUE);
		longestDistance(root, result);

		return result.get(0);
	}

	public static int longestDistance(TreeNode root, List<Integer> result) {
		if (root == null) {
			return 0;
		}

		// divide
		int left = longestDistance(root.left, result);
		int right = longestDistance(root.right, result);

		// conquer
		if (result.get(0) < left + right + 1) {
			result.set(0, left + right + 1);
		}
		int distance = Math.max(left, right) + 1;

		return distance;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}
