import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int min = Integer.MAX_VALUE;
	static boolean visited[];
	static int[][] arr;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] input;

		arr = new int[n][n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int value = Integer.parseInt(input[j]);
				arr[j][i] += value;
				arr[i][j] += value;
			}
		}
		
		visited[0] = true;
		dfs(1, 1);

		System.out.println(min);
	}

	private static void dfs(int start, int depth) {
		if (depth == n / 2) {
			min = Math.min(min, calc());

			if (min == 0) {
				System.out.println(0);
				System.exit(0);
			}

			return;
		}

		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	private static int calc() {
		int start = 0;
		int link = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (visited[i] && visited[j])
					start += arr[i][j];
				else if (!visited[i] && !visited[j])
					link += arr[i][j];
			}
		}

		return Math.abs(start - link);
	}
}
