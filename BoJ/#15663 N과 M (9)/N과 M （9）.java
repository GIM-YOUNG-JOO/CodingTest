import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int n, m;
	static ArrayList<Integer> path;
	static ArrayList<Integer> arr;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		arr = new ArrayList<Integer>();
		path = new ArrayList<Integer>();
		visit = new boolean[10001];

		str = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			arr.add(Integer.parseInt(str[i]));

		Collections.sort(arr);

		dfs(0);

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static void dfs(int depth) {
		if (depth == m) {
			if(!set.contains(path)) {
				for(int i : path)
					sb.append(i + " ");
			}
			set.add(path);
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				path.add(arr.get(i));
				dfs(depth + 1);
				path.remove(path.size() - 1);
				visit[i] = false;
			}
		}
	}
}
