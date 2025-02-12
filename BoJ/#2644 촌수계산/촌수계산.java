import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());

		arr = new int[size + 1][size + 1];
		visited = new boolean[size + 1];

		String[] input = br.readLine().split(" ");

		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");

			arr[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
			arr[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
		}

		System.out.println(bfs(a, b, size));
	}

	private static int bfs(int start, int end, int size) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(start);
		visited[start] = true;
		int node;
		int count = 0;

		while (!queue.isEmpty()) {
			int step = queue.size();
			for (int c = 0; c < step; c++) {
				node = queue.poll();

				if (node == end) {
					return count;
				}

				for (int i = 1; i <= size; i++) {
					if (!visited[i] && arr[node][i] == 1) {
						visited[i] = true;
						queue.add(i);
					}
				}
			}

			count++;
		}
		
		return -1;
	}
}