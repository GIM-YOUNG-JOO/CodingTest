import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cpu = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[2];
		Node node = new Node(cpu);

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			node.setUndirectedEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}

		System.out.println(node.bfs(1));
	}
}

class Node {
	int[][] graph;
	boolean[] visited;

	public Node(int size) {
		this.graph = new int[size + 1][size + 1];
		this.visited = new boolean[size + 1];
	}

	public void setUndirectedEdge(int a, int b) {
		this.graph[a][b] = 1;
		this.graph[b][a] = 1;
	}

	public int bfs(int start) {
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int node = queue.remove();

			// 방문한 노드 체크
			if (!visited[node]) {
				visited[node] = true;
				count++;
			}

			// 현재 노드에 인접한 노드를 역순으로 탐색
			for (int i = 0; i < graph.length; i++) {
				if (graph[node][i] == 1 && !visited[i]) {
					queue.add(i);
				}
			}
		}
		return count-1;
	}
}