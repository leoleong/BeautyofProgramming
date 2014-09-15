package bop;

public class _0216_LongestIncreasingSubsequence {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, -1, 2, -3, 4, -5, 6, -7 };
		int result = lis(nums);
		System.out.println(result);
	}

	private static int lis(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] dp = new int[nums.length];
		dp[0] = 1;
		int result = 1;

		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			result = Math.max(result, dp[i]);
		}

		return result;
	}
}
