package bop;

public class _0202_Factorial {

	public static void main(String[] args) {

		int n = 25;
		int result = numberofZero(n);
		System.out.println(result);

		int m = 4;
		int pos = positionofOne(m);
		System.out.println(pos);
	}

	private static int numberofZero(int n) {

		int count = 0;

		while (n > 0) {
			count += n / 5;
			n /= 5;
		}

		return count;
	}

	private static int positionofOne(int n) {

		int pos = 0;

		while (n > 0) {
			pos += n / 2;
			n /= 2;
		}

		return pos + 1;
	}
}
