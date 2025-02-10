import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int[] arr;
	static ArrayList<String> list;
	static StringBuilder sb = new StringBuilder();
	static String[] str;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			str = br.readLine().split(" ");

			if (str[0].equals("0"))
				break;

			n = str.length;
			list = new ArrayList<String>();

			dfs(1, 1);
			sb.append("\n");
		}

		sb.setLength(sb.length() - 2);
		System.out.println(sb.toString());
	}

	private static void dfs(int idx, int depth) {
		if (depth == 7) {
			sb.append(String.join(" ", list) + "\n");
			return;
		}

		for (int i = idx; i < n; i++) {
			list.add(str[i]);
			dfs(i + 1, depth + 1);
			list.remove(str[i]);
		}
	}
}