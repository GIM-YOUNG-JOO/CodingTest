import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int n;
	static int m;
	static boolean[] visit;
	static ArrayList<Integer> path;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		path = new ArrayList<Integer>();
		arr = new ArrayList<Integer>();
		visit = new boolean[n];

		str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(str[i]));
		}

		Collections.sort(arr);

		dfs(0, 0);

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static void dfs(int start, int depth) {
		if (depth == m) {
			for (int i : path)
				sb.append(arr.get(i) + " ");
			sb.setLength(sb.length() - 1);
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				path.add(i);
				dfs(i, depth + 1);
				path.remove(path.size() - 1);
				visit[i] = false;
			}
		}
	}
}