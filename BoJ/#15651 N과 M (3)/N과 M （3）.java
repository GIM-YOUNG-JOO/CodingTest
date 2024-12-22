import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int n, m;
	static boolean[] visit;
	static ArrayList<Integer> path;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		path = new ArrayList<Integer>();
		dfs(0);

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static void dfs(int depth) {
		if (depth == m) {
			for (int i : path) {
				sb.append(i + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			path.add(i);
			dfs(depth + 1);
			path.remove(path.size() - 1);
		}
	}
}
