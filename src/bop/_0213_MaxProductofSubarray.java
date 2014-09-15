package bop;

public class _0213_MaxProductofSubarray {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 4, 3 };
		int result = maxProductDP(nums);
		System.out.println(result);
	}

	// method 1: DP
	private static int maxProductDP(int[] nums) {

		if (nums == null || nums.length <= 1) {
			return Integer.MIN_VALUE;
		}

		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		left[0] = right[nums.length - 1] = 1;
		int max = Integer.MIN_VALUE;

		for (int i = 1; i < left.length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}
		for (int i = right.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			int product = left[i] * right[i];
			max = product > max ? product : max;
		}

		return max;
	}

	// method 2: enum(not perfect)
	private static int maxProductEnum(int[] nums) {

		if (nums == null || nums.length <= 1) {
			return Integer.MIN_VALUE;
		}

		int product = 1;
		int count = 0;
		int maxNegative = Integer.MIN_VALUE;
		int minPositive = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			product *= nums[i];
			if (nums[i] == 0) {
				count++;
			} else if (nums[i] < 0 && nums[i] > maxNegative) {
				maxNegative = nums[i];
			} else if (nums[i] > 0 && nums[i] < minPositive) {
				minPositive = nums[i];
			}
		}

		if (count >= 2) {
			product = 0;
		} else if (count == 1) {
			// product = ...;
		} else {
			if (product > 0) {
				product /= minPositive;
			} else {
				product /= maxNegative;
			}
		}

		return product;
	}
}
