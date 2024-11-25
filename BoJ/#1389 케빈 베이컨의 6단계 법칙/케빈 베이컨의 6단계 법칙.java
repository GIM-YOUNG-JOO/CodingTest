import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		int[][] user = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		int kevin = 0;

		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			user[a][b] = 1;
			user[b][a] = 1;
		}

		for (int i = 1; i <= n; i++) {
			int temp = bfs(user, i);
			if (temp < min) {
				min = temp;
				kevin = i;
			}
			visited = new boolean[n + 1];
		}
		
		System.out.println(kevin);
	}

	private static int bfs(int[][] user, int f) {
		int[] distance = new int[visited.length];
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(f);
		while (!queue.isEmpty()) {
			int a = queue.remove();
			for (int i = 1; i < visited.length; i++) {
				if (user[a][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					distance[i] = distance[a] + 1;
				}
			}
		}

		int answer = 0;

		for (int i : distance) {
			answer += i;
		}

		return answer;
	}
}