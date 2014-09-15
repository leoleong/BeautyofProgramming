package bop;

public class _0214_MaxSumofSubCyclicArray {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3, 4 };
		int result = maxSum(nums);
		System.out.println(result);
	}

	private static int maxSum(int[] nums) {

		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}

		int result = 0;
		int[] dp = new int[nums.length];

		// find max subarray
		dp[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < dp.length; i++) {
			if (dp[i - 1] < 0) {
				dp[i] = nums[i];
			}
			max = Math.max(max, dp[i]);
		}

		// find sum
		int sum = nums[0];
		for (int i = 1; i < dp.length; i++) {
			sum += nums[i];
		}

		// find min subarray
		dp[0] = nums[0];
		int min = nums[0];
		for (int i = 1; i < dp.length; i++) {
			if (dp[i - 1] > 0) {
				dp[i] = nums[i];
			}
			min = Math.min(min, dp[i]);
		}

		result = Math.max(sum, sum - min);
		result = Math.max(result, max);

		return result;
	}
}
