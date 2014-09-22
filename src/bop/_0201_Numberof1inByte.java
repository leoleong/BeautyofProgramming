package bop;

public class _0201_Numberof1inByte {

	public static void main(String[] args) {

		byte bt = (byte) 0xff;
		int result = count(bt);
		System.out.println(result);
	}

	private static int count(byte bt) {

		int count = 0;

		while (bt != 0) {
			bt &= bt - 1;
			count++;
		}

		return count;
	}
}
