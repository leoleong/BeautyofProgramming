package bop;

import java.util.ArrayList;
import java.util.List;

public class _0302_PhoneNumbertoWord {

	public static void main(String[] args) {

		String number = "5869872";
		List<String> result = parse(number);
		System.out.println(result.toString());
	}

	private static List<String> parse(String number) {

		if (number == null || number.length() == 0) {
			return new ArrayList<String>();
		}

		List<String> result = new ArrayList<String>();
		String[] dict = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		StringBuilder path = new StringBuilder();
		dfs(result, path, dict, number.replaceAll("1", ""), 0);

		return result;
	}

	private static void dfs(List<String> result, StringBuilder path,
			String[] dict, String num, int start) {

		if (start == num.length()) {
			result.add(path.toString());
			return;
		}

		char ch = num.charAt(start);
		String range = dict[ch - '0'];
		for (int i = 0; i < range.length(); i++) {
			path.append(range.charAt(i));
			dfs(result, path, dict, num, start + 1);
			path.deleteCharAt(path.length() - 1);
		}
	}
}
