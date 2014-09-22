package bop;

public class _0204_Numberof1 {

	public static void main(String[] args) {

		int n = 123;
		int result = numberof1(n);
		System.out.println(result);
	}

	private static int numberof1(int n) {

		if (n < 1) {
			return 0;
		}

		int factor = 1;
		int count = 0;
		int lower, cur, higher;

		while (n / factor != 0) {
			lower = n - (n / factor) * factor;
			cur = (n / factor) % 10;
			higher = n / (factor * 10);

			if (cur < 1) {
				count += higher * factor;
			} else if (cur == 1) {
				count += higher * factor + lower + 1;
			} else {
				count += (higher + 1) * factor;
			}
			factor *= 10;
		}

		return count;
	}
}
