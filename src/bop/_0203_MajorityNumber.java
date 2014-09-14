package bop;

import java.util.Arrays;

public class _0203_MajorityNumber {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 1, 1, 2, 2, 1 };
		int result = find(nums);
		System.out.println(result);

		nums = new int[] { 2, 4, 2, 3, 1, 3, 1 };
		int[] results = findAdvanced(nums);
		System.out.println(Arrays.toString(results));
	}

	// decrease & conquer
	private static int find(int[] nums) {

		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}

		int candidate = Integer.MIN_VALUE;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (candidate == nums[i]) {
				count++;
			} else {
				if (count == 0) {
					candidate = nums[i];
					count++;
				} else {
					count--;
				}
			}
		}

		return candidate;
	}

	private static int[] findAdvanced(int[] nums) {

		if (nums == null || nums.length == 0) {
			return new int[3];
		}

		int[] candicate = new int[3];
		int[] count = new int[3];

		Arrays.fill(candicate, Integer.MIN_VALUE);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == candicate[0]) {
				count[0]++;
			} else if (nums[i] == candicate[1]) {
				count[1]++;
			} else if (nums[i] == candicate[2]) {
				count[2]++;
			} else {
				if (count[0] == 0) {
					candicate[0] = nums[i];
					count[0]++;
				} else if (count[1] == 0) {
					candicate[1] = nums[i];
					count[1]++;
				} else if (count[2] == 0) {
					candicate[2] = nums[i];
					count[2]++;
				} else {
					count[0]--;
					count[1]--;
					count[2]--;
				}
			}
		}

		return candicate;
	}
}
