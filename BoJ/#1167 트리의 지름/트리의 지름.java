import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
	int point, length;

	public Node(int point, int length) {
		this.point = point;
		this.length = length;
	}
}

public class Main {
	static ArrayList<ArrayList<Node>> map;
	static boolean[] visited;
	static int max = 0;
	static int farNode;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		map = new ArrayList<>();
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while (true) {
		        int adjacent = Integer.parseInt(st.nextToken());
		        if (adjacent == -1) {
		            break;
		        }
		        int dist = Integer.parseInt(st.nextToken());

		        map.get(from).add(new Node(adjacent, dist));
		    }
		}
		visited[1] = true;
		dfs(1, 0);
		Arrays.fill(visited, false);
		visited[farNode] = true;
		dfs(farNode, 0);

		System.out.println(max);
	}

	private static void dfs(int start, int dist) {
		if (dist > max) {
			max = dist;
			farNode = start;
		}

		for (Node node : map.get(start)) {
			if (!visited[node.point]) {
				visited[node.point] = true;
				dfs(node.point, dist + node.length);
				visited[node.point] = false;
			}
		}
	}
}
