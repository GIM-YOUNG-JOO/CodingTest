import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static ArrayList<ArrayList<Integer>> tree;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] str;
		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList<ArrayList<Integer>>();
		parent = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<Integer>());
		}

		for (int i = 1; i < n; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			tree.get(a).add(b);
			tree.get(b).add(a);
		}

		bfs(1);

		for (int i = 2; i <= n; i++) {
			sb.append(parent[i] + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static void bfs(int node) {
		parent[node] = -1;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		while (!queue.isEmpty()) {
			int newNode = queue.poll();

			for (int temp : tree.get(newNode)) {
				if (parent[temp] == 0) {
					parent[temp] = newNode;
					queue.add(temp);
				}
			}
		}
	}
}