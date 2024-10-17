import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]) + 1; // 정점의 개수
		int[][] node = new int[n][n];
		;
		int m = Integer.parseInt(str[1]); // 간선의 개수
		int start = Integer.parseInt(str[2]);

		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			node[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
			node[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
		}

		System.out.println(dfs(node, start, n));
		sb.setLength(0);
		System.out.println(bfs(node, start, n));
	}

	private static String dfs(int[][] arr, int start, int n) {
		boolean[] visited = new boolean[n];
		Stack<Integer> stack = new Stack<>(); // DFS를 위한 스택
		stack.push(start); // 시작 노드를 스택에 추가

		while (!stack.isEmpty()) {
			int node = stack.pop(); // 스택에서 현재 노드를 꺼냄

			// 방문한 노드를 출력
			if (!visited[node]) { // 아직 방문하지 않은 경우에만 출력
				visited[node] = true; // 방문 처리
				sb.append(node + " "); // 방문한 노드 출력
			}

			for (int i = n - 1; i >= 1; i--) { // 역순으로 탐색
				if (arr[node][i] == 1 && !visited[i]) {
					stack.push(i); // 스택에 인접 노드를 추가
				}
			}
		}
		
		return sb.toString();
	}

	private static String bfs(int[][] arr, int start, int n) {
		boolean[] visited = new boolean[n];
		Queue<Integer> stack = new LinkedList<>();
		stack.add(start);

		while (!stack.isEmpty()) {
			int node = stack.remove();

			// 방문한 노드를 출력
			if (!visited[node]) {
				visited[node] = true;
				sb.append(node + " ");
			}

			for (int i = 1; i < n; i++) {
				if (arr[node][i] == 1 && !visited[i]) {
					stack.add(i);
				}
			}
		}
		
		return sb.toString();
	}
}