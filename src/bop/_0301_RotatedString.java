package bop;

public class _0301_RotatedString {

	public static void main(String[] args) {

		String src = "aabbcd";
		String dst = "cdaa";
		boolean result = containStr1(src, dst);
		System.out.println(result);
	}

	// time : O(m*n), space : O(n)
	private static boolean containStr(String src, String dst) {

		String temp = src + src;

		for (int i = 0; i < temp.length() - dst.length(); i++) {
			int j = 0;
			for (; j < dst.length() && temp.charAt(i + j) == dst.charAt(j); j++)
				;
			if (j == dst.length()) {
				return true;
			}
		}

		return false;
	}

	// time : O(m*n), space : O(1)
	private static boolean containStr1(String src, String dst) {

		for (int i = 0; i < src.length(); i++) {
			int j = 0;
			for (; j < dst.length()
					&& src.charAt((i + j) % src.length()) == dst.charAt(j); j++)
				;
			if (j == dst.length()) {
				return true;
			}
		}

		return false;
	}
}
